package com.example.com.morecharge.receive.main.goodsdetail;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.com.common.BaseActivity;
import com.example.com.morecharge.R;
import com.example.com.morecharge.ui.widget.TopBar;

import butterknife.BindView;

public class GoodsToPayActivity extends BaseActivity {
    @BindView(R.id.goods_topay_topbar)
    TopBar goodsTopayTopbar;
    @BindView(R.id.goods_topay_userinfo)
    TextView goodsTopayUserinfo;
    @BindView(R.id.goods_topay_useradress)
    TextView goodsTopayUseradress;
    @BindView(R.id.goods_topay_address_ll)
    LinearLayout goodsTopayAddressLl;
    @BindView(R.id.goods_topay_iv)
    ImageView goodsTopayIv;
    @BindView(R.id.goods_topay_title_tv)
    TextView goodsTopayTitleTv;
    @BindView(R.id.goods_topay_jifen_num)
    TextView goodsTopayJifenNum;
    @BindView(R.id.goods_topay_jifen_count)
    TextView goodsTopayJifenCount;
    @BindView(R.id.goods_topay_bottom_title)
    TextView goodsTopayBottomTitle;
    @BindView(R.id.goods_topay_bottom_num)
    TextView goodsTopayBottomNum;
    @BindView(R.id.goods_topay_bottom_sure)
    Button goodsTopayBottomSure;

    @Override
    public int bindLayout() {
        return R.layout.activity_goods_topay;
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
