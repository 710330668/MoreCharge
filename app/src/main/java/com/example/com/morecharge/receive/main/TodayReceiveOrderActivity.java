package com.example.com.morecharge.receive.main;

import android.content.Context;
import android.os.Bundle;

import com.example.com.common.BaseActivity;
import com.example.com.morecharge.R;

import butterknife.OnClick;

/**
 * Created by 71033 on 2018/11/22.
 */
public class TodayReceiveOrderActivity extends BaseActivity {


    @Override
    public int bindLayout() {
        return R.layout.activity_today_receive_order;
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

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
