package com.example.com.morecharge.usercenter;

import android.content.Context;
import android.os.Bundle;
import android.widget.RadioButton;

import com.example.com.common.BaseActivity;
import com.example.com.morecharge.R;

import butterknife.BindView;

/**
 * 我的  activity
 */

public class MineActivity extends BaseActivity {

    @BindView(R.id.rb_receive)
    RadioButton mRbReceive;
    @BindView(R.id.rb_release)
    RadioButton mRbRelease;

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

    }
}
