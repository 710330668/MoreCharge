package com.example.com.morecharge.receive.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.com.common.BaseActivity;
import com.example.com.morecharge.R;

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


    @OnClick({R.id.lly_today_liushui, R.id.btn_receive})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lly_today_liushui:
                startActivity(TodayLiushuiActivity.class);
                break;
            case R.id.btn_receive:
                startActivity(ReceiveOrderListActivity.class);
                break;
        }
    }
}
