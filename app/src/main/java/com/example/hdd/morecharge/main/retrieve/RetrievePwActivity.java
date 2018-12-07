package com.example.hdd.morecharge.main.retrieve;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.hdd.common.BaseActivity;
import com.example.hdd.morecharge.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 71033 on 2018/11/20 1.
 */
public class RetrievePwActivity extends BaseActivity {

    @Override
    public int bindLayout() {
        return R.layout.activity_retrieve_pw1;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                startActivity(RetrievePwNextActivity.class);
                break;
        }
    }
}
