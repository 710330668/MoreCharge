package com.example.com.morecharge.main.login;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.example.com.common.BaseActivity;
import com.example.com.morecharge.R;
import com.example.com.morecharge.view.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 71033 on 2018/11/19.
 */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.viewpager)
    CustomViewPager viewpager;

    private List<Fragment> fragmentList = new ArrayList<>();
    private GeneralLoginFragment gLoginFragment;
    private QuickLoginFragment qLoginFragment;
    private MyPagerAdapter adapter;

    @Override
    public int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initParams(Bundle params) {
        gLoginFragment = GeneralLoginFragment.newInstance();
        qLoginFragment = QuickLoginFragment.newInstance();
        fragmentList.add(gLoginFragment);
        fragmentList.add(qLoginFragment);
    }

    @Override
    public void setView(Bundle savedInstanceState) {
        adapter = new MyPagerAdapter(getSupportFragmentManager(), fragmentList);
    }

    @Override
    public void doBusiness(Context mContext) {
        viewpager.setAdapter(adapter);
        viewpager.setScanScroll(false);
    }

    @OnClick({R.id.tv_login_account, R.id.tv_login_quick})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_login_account:
                viewpager.setCurrentItem(0);
                break;
            case R.id.tv_login_quick:
                viewpager.setCurrentItem(1);
                break;
        }
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mfragmentList;

        public MyPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.mfragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return mfragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mfragmentList.size();
        }
    }

}
