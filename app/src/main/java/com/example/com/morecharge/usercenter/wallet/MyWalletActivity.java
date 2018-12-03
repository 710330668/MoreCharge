package com.example.com.morecharge.usercenter.wallet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.com.common.BaseActivity;
import com.example.com.morecharge.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 71033 on 2018/11/23.
 */
public class MyWalletActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.lly_recharge)
    LinearLayout llyRecharge;

    @Override
    public int bindLayout() {
        return R.layout.activity_my_wallet;
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

    @OnClick({R.id.iv_back, R.id.lly_recharge,R.id.lly_withdrawal,R.id.lly_water_subsidiary,R.id.lly_bankcard})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.lly_recharge:
                startActivity(ReChargeActivity.class);
                break;
            case R.id.lly_withdrawal:
                startActivity(ChoosePayMethodActivity.class);
                break;
            case R.id.lly_water_subsidiary:
                startActivity(WaterSubsidiaryActivity.class);
                break;
            case R.id.lly_bankcard:
                startActivity(BankCardActivity.class);
                break;
        }
    }
}
