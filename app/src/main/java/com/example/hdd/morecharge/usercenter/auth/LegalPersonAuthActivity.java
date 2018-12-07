package com.example.hdd.morecharge.usercenter.auth;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.hdd.common.BaseActivity;
import com.example.hdd.morecharge.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 71033 on 2018/11/27.
 */
public class LegalPersonAuthActivity extends BaseActivity {

    @Override
    public int bindLayout() {
        return R.layout.activity_legal_person_auth;
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

    @OnClick({R.id.iv_back, R.id.btn_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_commit:
                break;
        }
    }
}
