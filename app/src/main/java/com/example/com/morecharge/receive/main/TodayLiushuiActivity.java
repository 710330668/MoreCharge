package com.example.com.morecharge.receive.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.com.common.BaseActivity;
import com.example.com.morecharge.R;

import butterknife.OnClick;

/**
 * Created by 71033 on 2018/11/21.
 */
public class TodayLiushuiActivity extends BaseActivity {

    @Override
    public int bindLayout() {
        return R.layout.activity_today_liushui;
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


    @OnClick({R.id.iv_back, R.id.tv_shouyi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_shouyi:
                break;
        }
    }
}
