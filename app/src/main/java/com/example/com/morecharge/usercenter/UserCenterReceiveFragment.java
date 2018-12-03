package com.example.com.morecharge.usercenter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.common.BaseFragment;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.main.WaterMelonCreditActivity;
import com.example.com.morecharge.receive.main.integrate.MyIntegrateActivity;
import com.example.com.morecharge.usercenter.auth.MyAuthActivity;
import com.example.com.morecharge.usercenter.setting.SettingActivity;
import com.example.com.morecharge.usercenter.wallet.MyWalletActivity;
import com.example.zxinglib.android.CaptureActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class UserCenterReceiveFragment extends BaseFragment {
    Unbinder unbinder;

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_user_center_receive;
    }

    @Override
    public void setView(View rootView) {

    }

    @Override
    public void initData(Bundle arguments) {

    }

    @Override
    public void onLazyLoad() {

    }

    @Override
    public void unVisible() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.ll_mine_authentication, R.id.ll_mine_wallet, R.id.ll_mine_order, R.id.ll_mine_skill, R.id.ll_receipt_code, R.id.ll_scan, R.id.ll_watermelon_credit, R.id.ll_mine_score, R.id.ll_complain_advice, R.id.ll_mine_setting, R.id.ll_mine_message})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_mine_authentication:
                startActivity(MyAuthActivity.class);
                break;
            case R.id.ll_mine_wallet:
                startActivity(MyWalletActivity.class);
                break;
            case R.id.ll_mine_order:
                break;
            case R.id.ll_mine_skill:
                break;
            case R.id.ll_receipt_code:
                break;
            case R.id.ll_scan:
                startActivity(CaptureActivity.class);
                break;
            case R.id.ll_watermelon_credit:
                startActivity(WaterMelonCreditActivity.class);
                break;
            case R.id.ll_mine_score:
                startActivity(MyIntegrateActivity.class);
                break;
            case R.id.ll_complain_advice:
                startActivity(ComplainSuggestActivity.class);
                break;
            case R.id.ll_mine_setting:
                startActivity(SettingActivity.class);
                break;
            case R.id.ll_mine_message:
                break;
        }
    }
}
