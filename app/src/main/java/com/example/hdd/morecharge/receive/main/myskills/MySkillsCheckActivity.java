package com.example.hdd.morecharge.receive.main.myskills;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.hdd.common.BaseActivity;
import com.example.hdd.common.util.LogUtils;
import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.receive.main.myskills.datautil.SkillDataProcess;
import com.example.hdd.morecharge.receive.main.myskills.entity.SkillsResponseEntry;
import com.example.hdd.morecharge.receive.main.myskills.skilladapter.SkillCheckAdapter;
import com.example.hdd.morecharge.remote.Injection;
import com.example.hdd.morecharge.ui.widget.TopBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MySkillsCheckActivity extends BaseActivity {
    @BindView(R.id.skills_check_topbar)
    TopBar skillsCheckTopbar;
    @BindView(R.id.skills_check_recy)
    RecyclerView skillsCheckRecy;

    List<SkillsResponseEntry.DataBean> skillData;
    SkillCheckAdapter checkAdapter;


    @Override
    public int bindLayout() {
        return R.layout.activity_skills_check;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void setView(Bundle savedInstanceState) {

        initTopbar();
        initRecy();

    }

    private void initRecy() {
        skillData = new ArrayList<>();
        checkAdapter = new SkillCheckAdapter(this, skillData);
        skillsCheckRecy.setLayoutManager(new LinearLayoutManager(this));
        skillsCheckRecy.setHasFixedSize(true);
        skillsCheckRecy.setAdapter(checkAdapter);

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

                        if (skillsResponseEntry != null && skillsResponseEntry.isSuccess()) {

                            List<SkillsResponseEntry.DataBean> skillData = skillsResponseEntry.getData();

                            List<SkillsResponseEntry.DataBean> haveSkills = SkillDataProcess.filterUserOwnSkills(skillData);

                            checkAdapter.addData(haveSkills);
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        ToastUtils.showShort(MySkillsCheckActivity.this, throwable.getMessage());

                    }
                });


    }


    public void deleteEndPos(int parentPos) {
        List<SkillsResponseEntry.DataBean> datas = checkAdapter.getDatas();
        datas.remove(parentPos);
        checkAdapter.notifyItemRemoved(parentPos);
    }

    private void initTopbar() {

        skillsCheckTopbar.setOnTopBarClickListener(new TopBar.OnTopBarClickListener() {
            @Override
            public void onTopBarRightClick(View v) {

            }

            @Override
            public void onTopBarLeftClick(View v) {
                onBackPressed();
            }
        });


    }
}
