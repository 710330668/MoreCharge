package com.example.hdd.morecharge.usercenter.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hdd.common.BaseFragment;
import com.example.hdd.morecharge.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 71033 on 2018/11/26.
 */
public class EnterpriseAuthFragment extends BaseFragment {

    Unbinder unbinder;

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_enterprise_auth;
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

    public static EnterpriseAuthFragment newInstance() {

        Bundle args = new Bundle();

        EnterpriseAuthFragment fragment = new EnterpriseAuthFragment();
        fragment.setArguments(args);
        return fragment;
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

    @OnClick({R.id.btn_legal_auth, R.id.btn_business_lic})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_legal_auth:
                startActivity(LegalPersonAuthActivity.class);
                break;
            case R.id.btn_business_lic:
                startActivity(BusinessLicActivity.class);
                break;
        }
    }
}
