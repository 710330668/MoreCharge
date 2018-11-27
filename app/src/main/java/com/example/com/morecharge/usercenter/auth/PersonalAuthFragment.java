package com.example.com.morecharge.usercenter.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.common.BaseFragment;
import com.example.com.morecharge.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 71033 on 2018/11/26.
 */
public class PersonalAuthFragment extends BaseFragment {

    Unbinder unbinder;

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_personal_auth;
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

    public static PersonalAuthFragment newInstance() {

        Bundle args = new Bundle();

        PersonalAuthFragment fragment = new PersonalAuthFragment();
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

    @OnClick({R.id.btn_identity_auth, R.id.btn_face_auth})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_identity_auth:
                startActivity(IdentityAuthActivity.class);
                break;
            case R.id.btn_face_auth:
                break;
        }
    }
}
