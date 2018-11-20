package com.example.com.morecharge.main.login;

import android.os.Bundle;
import android.view.View;

import com.example.com.common.BaseFragment;
import com.example.com.morecharge.R;

/**
 * Created by 71033 on 2018/11/20.
 */
public class QuickLoginFragment extends BaseFragment {
    
    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_login_quick;
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

    public static QuickLoginFragment newInstance() {
        
        Bundle args = new Bundle();
        
        QuickLoginFragment fragment = new QuickLoginFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
