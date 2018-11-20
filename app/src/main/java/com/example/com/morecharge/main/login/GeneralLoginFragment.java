package com.example.com.morecharge.main.login;

import android.os.Bundle;
import android.view.View;

import com.example.com.common.BaseFragment;
import com.example.com.morecharge.R;
import com.example.com.morecharge.main.register.RegisterActivity;
import com.example.com.morecharge.main.retrieve.RetrievePwActivity;

import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 71033 on 2018/11/20.
 */
public class GeneralLoginFragment extends BaseFragment {

    Unbinder unbinder;

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_login_general;
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

    public static GeneralLoginFragment newInstance() {

        Bundle args = new Bundle();

        GeneralLoginFragment fragment = new GeneralLoginFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({ R.id.tv_retrieve_pw,R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_retrieve_pw:
                startActivity(RetrievePwActivity.class);
                break;
            case R.id.tv_register:
                startActivity(RegisterActivity.class);
                break;
        }
    }
}
