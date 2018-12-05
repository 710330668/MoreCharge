package com.example.hdd.morecharge.receive.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.hdd.common.BaseActivity;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.usercenter.MineActivity;

import butterknife.OnClick;

/**
 * Created by 71033 on 2018/11/19.
 */
public class ReceiveMainActivity extends BaseActivity {

    @Override
    public int bindLayout() {
        return R.layout.activity_receive_main;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void setView(Bundle savedInstanceState) {

    }

    @Override
    public void doBusiness(Context mContext) {

    }


    @OnClick({R.id.lly_today_liushui, R.id.btn_receive,R.id.iv_user_center,R.id.rl_score,R.id.rl_today_receive_order,
    R.id.rl_water_melon_credit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lly_today_liushui:
                startActivity(TodayLiushuiActivity.class);
                break;
            case R.id.btn_receive:
                startActivity(ReceiveOrderListActivity.class);
                break;
            case R.id.iv_user_center:
                startActivity(MineActivity.class);
                break;
            case R.id.rl_score:
                startActivity(ScoreActivity.class);
                break;
            case R.id.rl_today_receive_order:
                startActivity(TodayReceiveOrderActivity.class);
                break;
            case R.id.rl_water_melon_credit:
                startActivity(WaterMelonCreditActivity.class);
                break;
        }
    }
}
