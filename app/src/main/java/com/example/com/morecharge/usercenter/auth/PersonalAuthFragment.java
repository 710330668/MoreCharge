package com.example.com.morecharge.usercenter.auth;

import android.os.Bundle;
import android.view.View;

import com.example.com.common.BaseFragment;
import com.example.com.morecharge.R;

/**
 * Created by 71033 on 2018/11/26.
 */
public class PersonalAuthFragment extends BaseFragment {

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
}
