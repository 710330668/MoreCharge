package com.example.hdd.morecharge.receive.main.myskills;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.example.hdd.common.BaseActivity;
import com.example.hdd.common.util.LogUtils;
import com.example.hdd.common.util.SP;
import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.config.C;
import com.example.hdd.morecharge.receive.main.myskills.entity.SkillPosSelect;
import com.example.hdd.morecharge.receive.main.myskills.entity.SkillResetResponse;
import com.example.hdd.morecharge.receive.main.myskills.entity.SkillsResponseEntry;
import com.example.hdd.morecharge.receive.main.myskills.entity.SkillsSelectedCode;
import com.example.hdd.morecharge.receive.main.myskills.skilladapter.SkillAddAdapter;
import com.example.hdd.morecharge.remote.Injection;
import com.example.hdd.morecharge.ui.widget.TopBar;
import com.example.hdd.morecharge.utils.GsonUtil;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MySkillsAddActivity extends BaseActivity {
    @BindView(R.id.skills_add_topbar)
    TopBar skillsAddTopbar;
    @BindView(R.id.skills_add_recy)
    RecyclerView skillsAddRecy;
    @BindView(R.id.skills_add_sure)
    Button skillsAddSure;

    private String accessToken = "";

    private SkillAddAdapter skillAdapter;

    List<SkillsResponseEntry.DataBean> skillData;

    public List<SkillsSelectedCode> selectedCodes;

    @Override
    public int bindLayout() {
        return R.layout.activity_skills_add;
    }

    @Override
    public void initParams(Bundle params) {
        selectedCodes = new ArrayList<>();
        accessToken = SP.getInstance(C.USER_DB, this).getString(C.USER_ACCESS_TOKEN, "");
    }

    @Override
    public void setView(Bundle savedInstanceState) {
        initTopBar();
        initRecy();

        initEnentBus();
    }

    private void initEnentBus() {

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    private void initRecy() {

        skillData = new ArrayList<>();
        skillAdapter = new SkillAddAdapter(this, skillData);
        skillsAddRecy.setLayoutManager(new LinearLayoutManager(this));
        skillsAddRecy.setHasFixedSize(true);
        skillsAddRecy.setAdapter(skillAdapter);

    }

    @Override
    public void doBusiness(Context mContext) {

        getSkills();

    }


    @SuppressLint("CheckResult")
    private void getSkills() {

        Injection.provideApiService().getAllSkills(TempConstant.token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SkillsResponseEntry>() {
                    @Override
                    public void accept(SkillsResponseEntry skillsResponseEntry) throws Exception {

                        LogUtils.i(new Gson().toJson(skillsResponseEntry));

                        if (skillsResponseEntry != null && skillsResponseEntry.isSuccess()) {

                            List<SkillsResponseEntry.DataBean> skillData = skillsResponseEntry.getData();

                            skillAdapter.addData(skillData);
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        ToastUtils.showShort(MySkillsAddActivity.this, throwable.getMessage());

                    }
                });


    }


    @OnClick({R.id.skills_add_sure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.skills_add_sure:
                commitMySelected();
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void notifyGetData(SkillPosSelect posSelect) {

        LogUtils.i(new Gson().toJson(posSelect));

        if (posSelect != null) {

            SkillsResponseEntry.DataBean.GroupValBean groupValBean = skillAdapter.getDatas().get(posSelect.getParentPos()).getGroupVal().get(posSelect.getChildPos());

            groupValBean.setIsHave("Y");
            skillAdapter.notifyItemChanged(posSelect.getParentPos());
        }


    }

    @SuppressLint("CheckResult")
    private void commitMySelected() {

        List<SkillsResponseEntry.DataBean> datas = skillAdapter.getDatas();

        LogUtils.i(new Gson().toJson(datas));

        if (datas != null) {
            for (int i = 0; i < datas.size(); i++) {

                SkillsResponseEntry.DataBean dataBean = datas.get(i);

                if (dataBean != null) {

                    List<SkillsResponseEntry.DataBean.GroupValBean> groupVal = dataBean.getGroupVal();

                    if (groupVal != null) {

                        for (int j = 0; j < groupVal.size(); j++) {

                            SkillsResponseEntry.DataBean.GroupValBean valBean = groupVal.get(j);

                            String isHave = valBean.getIsHave();

                            if ("Y".equalsIgnoreCase(isHave)) {

                                selectedCodes.add(new SkillsSelectedCode(valBean.getCode()));

                            }

                        }

                    }

                }

            }
        }

        Injection.provideApiService().AddSkills(TempConstant.token, GsonUtil.getRequestBody(selectedCodes))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SkillResetResponse>() {
                    @Override
                    public void accept(SkillResetResponse skillResetResponse) throws Exception {

                        if (skillResetResponse != null) {
                            boolean success = skillResetResponse.isSuccess();
                            if (success) {
                                ToastUtils.showLong(MySkillsAddActivity.this, skillResetResponse.getMsg());
                            }
                        }
                        onBackPressed();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showLong(MySkillsAddActivity.this, throwable.getMessage());
                        onBackPressed();
                    }
                });


    }


    private void initTopBar() {
        skillsAddTopbar.setOnTopBarClickListener(new TopBar.OnTopBarClickListener() {
            @Override
            public void onTopBarRightClick(View v) {
            }

            @Override
            public void onTopBarLeftClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
