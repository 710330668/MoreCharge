package com.example.com.morecharge.release.main.ui.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.com.common.BaseActivity;
import com.example.com.morecharge.R;

import butterknife.OnClick;

public class BuySubBillingRuleActivity extends BaseActivity {

    @Override
    public int bindLayout() {
        return R.layout.activity_buy_sub_billing_rule;
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
        this.finish();
    }
}
