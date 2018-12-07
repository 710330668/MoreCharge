package com.example.hdd.morecharge.usercenter.setting;

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
public class ChangePwActivity extends BaseActivity {

    @Override
    public int bindLayout() {
        return R.layout.activity_change_pw;
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

    @OnClick({R.id.iv_back, R.id.btn_get_code, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_get_code:
                break;
            case R.id.btn_next:
                startActivity(ChangePw2Activity.class);
                break;
        }
    }
}
