package com.example.com.morecharge.receive.main.goodsdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.com.common.BaseActivity;
import com.example.com.common.util.LogUtils;
import com.example.com.imageloader.LoaderManager;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.main.address.AddressListActivity;
import com.example.com.morecharge.receive.main.integrate.entity.InteGoodsInfoEntity;
import com.example.com.morecharge.ui.widget.TopBar;
import com.example.com.morecharge.utils.GsonUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

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

    private static String GOODS_INFO = "goodsInfo";
    private InteGoodsInfoEntity goodsInfoEntity;

    public static void actionStart(Context context, InteGoodsInfoEntity goodsInfoEntity) {

        Intent intent = new Intent(context, GoodsToPayActivity.class);
        intent.putExtra(GOODS_INFO, GsonUtil.GsonString(goodsInfoEntity));
        context.startActivity(intent);

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_goods_topay;
    }

    @Override
    public void initParams(Bundle params) {

        Intent intent = getIntent();
        String goodsDetail = intent.getStringExtra(GOODS_INFO);

        goodsInfoEntity = GsonUtil.GsonToBean(goodsDetail, InteGoodsInfoEntity.class);

        if (goodsInfoEntity == null) {
            onBackPressed();
        }
        LogUtils.i("商品详情实体类" + GsonUtil.GsonString(goodsInfoEntity));
    }

    @Override
    public void setView(Bundle savedInstanceState) {

        initView();

    }

    private void initView() {
        LoaderManager.getLoader().loadNet(goodsTopayIv, goodsInfoEntity.getItemFileUrl());
        goodsTopayTitleTv.setText(goodsInfoEntity.getItemTitle());
        goodsTopayJifenNum.setText(goodsInfoEntity.getItemIntege() + "积分");
        goodsTopayJifenCount.setText("×" + goodsInfoEntity.getItemCount());
        goodsTopayBottomNum.setText(goodsInfoEntity.getItemTotalIntege() + "积分");

    }

    @Override
    public void doBusiness(Context mContext) {


    }


    @OnClick({R.id.goods_topay_address_ll, R.id.goods_topay_bottom_sure})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.goods_topay_address_ll:

                if (!EventBus.getDefault().isRegistered(GoodsToPayActivity.this)) {
                    EventBus.getDefault().register(GoodsToPayActivity.this);
                }

                startActivity(AddressListActivity.class);

                break;

            case R.id.goods_topay_bottom_sure:

                startToExchange();

                break;

        }

    }

    private void startToExchange() {


    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void setAddressInfo() {


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(GoodsToPayActivity.this)) {
            EventBus.getDefault().unregister(GoodsToPayActivity.this);
        }
    }
}
