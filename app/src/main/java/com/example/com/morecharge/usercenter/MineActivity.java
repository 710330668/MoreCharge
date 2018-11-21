package com.example.com.morecharge.usercenter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.com.common.BaseActivity;
import com.example.com.morecharge.R;
import com.example.com.morecharge.main.login.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的  activity
 */

public class MineActivity extends BaseActivity {

    @BindView(R.id.rb_receive)
    RadioButton mRbReceive;
    @BindView(R.id.rb_release)
    RadioButton mRbRelease;
    @BindView(R.id.tv_go_order)
    TextView mTvGoOrder;
    @BindView(R.id.rg_button_container)
    RadioGroup mRadioGroup;
    @BindView(R.id.cons_root)
    ConstraintLayout mRoot;
    private UserCenterReceiveFragment mReceiveFragment;
    private UserCenterReleaseFragment mReleaseFragment;

    @Override
    public int bindLayout() {
        return R.layout.activity_mine;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void setView(Bundle savedInstanceState) {

    }

    @Override
    public void doBusiness(Context mContext) {
        mReceiveFragment = new UserCenterReceiveFragment();
        mReleaseFragment = new UserCenterReleaseFragment();
        replace(mReleaseFragment, R.id.fm_fragment_container);
    }


    @OnClick({R.id.rb_receive, R.id.rb_release,R.id.iv_user_portrait})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_receive:
                mTvGoOrder.setText("去接单");
                mRadioGroup.setBackgroundColor(Color.parseColor("#787878"));
                replace(mReceiveFragment, R.id.fm_fragment_container);

                mRoot.setBackgroundColor(Color.parseColor("#FFFFFF"));
                break;
            case R.id.rb_release:
                mTvGoOrder.setText("去发单");
                mRadioGroup.setBackgroundColor(Color.parseColor("#FFFFFF"));
                replace(mReleaseFragment, R.id.fm_fragment_container);

                mRoot.setBackgroundColor(Color.parseColor("#F0F0F0"));
                break;
            case R.id.iv_user_portrait:
                startActivity(LoginActivity.class);
                break;
        }
    }

    public void replace(Fragment fragment, int containerId) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        if (fragment.isAdded()) {
            fragmentTransaction.show(fragment);
        } else {
            fragmentTransaction.replace(containerId, fragment);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }
}
