package com.example.com.morecharge.usercenter.auth;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.RadioButton;

import com.example.com.common.BaseActivity;
import com.example.com.morecharge.R;
import com.example.com.morecharge.view.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 71033 on 2018/11/26.
 */
public class MyAuthActivity extends BaseActivity {

    @BindView(R.id.viewpager)
    CustomViewPager viewpager;
    @BindView(R.id.btn_personal_auth)
    RadioButton btnPersonalAuth;
    @BindView(R.id.btn_enterprise_auth)
    RadioButton btnEnterpriseAuth;

    private List<Fragment> fragmentList = new ArrayList<>();
    private PersonalAuthFragment pAuthFragment;
    private EnterpriseAuthFragment eAuthFragment;
    private MyPagerAdapter adapter;

    @Override
    public int bindLayout() {
        return R.layout.activity_my_certification;
    }

    @Override
    public void initParams(Bundle params) {
        pAuthFragment = PersonalAuthFragment.newInstance();
        eAuthFragment = EnterpriseAuthFragment.newInstance();
        fragmentList.add(pAuthFragment);
        fragmentList.add(eAuthFragment);
    }

    @Override
    public void setView(Bundle savedInstanceState) {
        adapter = new MyPagerAdapter(getSupportFragmentManager(), fragmentList);
    }

    @Override
    public void doBusiness(Context mContext) {
        viewpager.setAdapter(adapter);
        viewpager.setScanScroll(false);
        btnPersonalAuth.setChecked(true);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_personal_auth, R.id.btn_enterprise_auth})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_personal_auth:
                btnPersonalAuth.setChecked(true);
                btnEnterpriseAuth.setChecked(false);
                viewpager.setCurrentItem(0);
                break;
            case R.id.btn_enterprise_auth:
                btnPersonalAuth.setChecked(false);
                btnEnterpriseAuth.setChecked(true);
                viewpager.setCurrentItem(1);
                break;
        }
    }
}
