package com.example.hdd.morecharge.receive.main.integrate;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hdd.common.BaseActivity;
import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.receive.main.integrate.entity.IntegrateDelegate;
import com.example.hdd.morecharge.receive.main.integrate.entity.IntegrateEntity;
import com.example.hdd.morecharge.receive.main.integrate.integrateadapter.IntegrateAdapter;
import com.example.hdd.morecharge.ui.widget.TopBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 我的 积分
 */
public class MyIntegrateActivity extends BaseActivity {
    @BindView(R.id.intgrade_topbar)
    TopBar intgradeTopbar;
    @BindView(R.id.intgrade_num_tv)
    TextView intgradeNumTv;
    @BindView(R.id.intgrade_num_fl)
    FrameLayout intgradeNumFl;
    @BindView(R.id.intgrade_divider_desc)
    LinearLayout intgradeDividerDesc;
    @BindView(R.id.intgrade_recy)
    RecyclerView intgradeRecy;

    private Context mContext;
    private IntegrateAdapter integrateAdapter;

    @Override
    public int bindLayout() {
        return R.layout.activity_my_integrate;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void setView(Bundle savedInstanceState) {
        mContext = MyIntegrateActivity.this;

        topbarOnClick();
        initRecycler();
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    private void initRecycler() {

        List<IntegrateEntity> datas = new ArrayList<>();

        for (int i = 0; i < 20; i++) {

            IntegrateEntity entity=new IntegrateEntity("title" + i,IntegrateDelegate.EMPTY_VIEW);

            datas.add(new IntegrateEntity("title" + i));
//            datas.add(entity);

        }

        integrateAdapter = new IntegrateAdapter(datas, new IntegrateDelegate());
        intgradeRecy.setLayoutManager(new LinearLayoutManager(this));

        intgradeRecy.setAdapter(integrateAdapter);

    }


    private void topbarOnClick() {

        intgradeTopbar.setOnTopBarClickListener(new TopBar.OnTopBarClickListener() {
            @Override
            public void onTopBarRightClick(View v) {
                ToastUtils.showLong(mContext, "左侧点击");
            }

            @Override
            public void onTopBarLeftClick(View v) {
                onBackPressed();
            }
        });

    }


}
