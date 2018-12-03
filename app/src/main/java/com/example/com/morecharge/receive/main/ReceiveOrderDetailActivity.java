package com.example.com.morecharge.receive.main;

import android.content.Context;
import android.os.Bundle;

import com.example.com.common.BaseActivity;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.response.ReceiveOrdersResponse;

/**
 * Created by 71033 on 2018/11/30.
 */
public class ReceiveOrderDetailActivity extends BaseActivity {

    private ReceiveOrdersResponse.DataBean bean;

    @Override
    public int bindLayout() {
        return R.layout.activity_receive_detail;
    }

    @Override
    public void initParams(Bundle params) {
        bean = (ReceiveOrdersResponse.DataBean) getIntent().getSerializableExtra("order");
    }

    @Override
    public void setView(Bundle savedInstanceState) {

    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
