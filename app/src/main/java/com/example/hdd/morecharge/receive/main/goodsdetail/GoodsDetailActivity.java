package com.example.hdd.morecharge.receive.main.goodsdetail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hdd.common.BaseActivity;
import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.receive.main.goodsdetail.widget.AmountView;
import com.example.hdd.morecharge.ui.widget.TopBar;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.com.common.BaseActivity;
import com.example.com.common.util.LogUtils;
import com.example.com.common.util.ToastUtils;
import com.example.com.imageloader.LoaderManager;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.main.goodsdetail.entry.GoodsDetailResponseEntity;
import com.example.com.morecharge.receive.main.goodsdetail.goodsadapter.GoodsSimpleBottomAdapter;
import com.example.com.morecharge.receive.main.goodsdetail.goodsdetailpage.GoodsDetailFragment;
import com.example.com.morecharge.receive.main.goodsdetail.goodsdetailpage.GoodsDetailInfoFragment;
import com.example.com.morecharge.receive.main.goodsdetail.widget.AmountView;
import com.example.com.morecharge.receive.main.myskills.TempConstant;
import com.example.com.morecharge.remote.Injection;
import com.example.com.morecharge.ui.widget.TopBar;
import com.example.com.morecharge.utils.GsonUtil;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class GoodsDetailActivity extends BaseActivity {

    @BindView(R.id.goods_detail_banner)
    Banner goodsDetailBanner;
    @BindView(R.id.goods_detail_title)
    TextView goodsDetailTitle;
    @BindView(R.id.goods_detail_ptlm)
    GoodsPullUpToLoadMore goodsDetailPtlm;
    @BindView(R.id.goods_detail_change_btn)
    Button goodsDetailChangeBtn;
    @BindView(R.id.goods_detail_topbar)
    TopBar goodsDetailTopbar;

    private static String mGoodsId;
    @BindView(R.id.goods_detail_integate)
    TextView goodsDetailIntegate;
    @BindView(R.id.goods_detail_price)
    TextView goodsDetailPrice;
    @BindView(R.id.goods_detail_sliding_tabs)
    TabLayout goodsDetailSlidingTabs;
    @BindView(R.id.goods_detail_viewpager)
    ViewPager goodsDetailViewpager;

    private GoodsSimpleBottomAdapter goodsSimpleBottomAdapter;


    public static void actionStart(Context context, String id) {

        mGoodsId = id;
        context.startActivity(new Intent(context, GoodsDetailActivity.class));
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_goods_detail;
    }

    @Override
    public void initParams(Bundle params) {

        if (TextUtils.isEmpty(mGoodsId)) {
            onBackPressed();
        }

    }

    BottomSheetDialog bottomSheetDialog;
    BottomSheetDialog bottomPayDialog;

    @Override
    public void setView(Bundle savedInstanceState) {
        initTopBar();
        initBottomSheetDialog();


        goodsDetailChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.show();
            }
        });

    }


    private void initBottomSheetDialog() {
        bottomSheetDialog = new BottomSheetDialog(this);

        View view = View.inflate(this, R.layout.view_goods_bottom, null);
        Button goodsChageBtn = view.findViewById(R.id.goods_bottom_sure_btn);
        AmountView amountView = view.findViewById(R.id.goods_bottom_amount_view);
        amountView.setGoods_storage(100);
        amountView.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {

                Log.i("amount====amount", "onAmountChange: " + amount);


            }
        });
        goodsChageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.hide();
                initBottomPayDialog();
            }
        });
        bottomSheetDialog.setContentView(view);


    }


    private void initBottomPayDialog() {
        bottomPayDialog = new BottomSheetDialog(this);

        View view = View.inflate(this, R.layout.view_goods_pay_bottom, null);
        Button goodsPayBtn = view.findViewById(R.id.goods_bottom_pay_btn);
        goodsPayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomPayDialog.hide();
//                TODO 向后 传递数据
                startActivity(GoodsToPayActivity.class);
            }
        });
        bottomPayDialog.setContentView(view);
        bottomPayDialog.show();

    }

    private void initTopBar() {
        goodsDetailTopbar.setOnTopBarClickListener(new TopBar.OnTopBarClickListener() {
            @Override
            public void onTopBarRightClick(View v) {

            }

            @Override
            public void onTopBarLeftClick(View v) {
                onBackPressed();
            }
        });

    }


    @Override
    public void doBusiness(Context mContext) {

        getGoodsInfo();

    }

    @SuppressLint("CheckResult")
    private void getGoodsInfo() {
        Injection.provideApiService().getGoodsInfo(TempConstant.token, mGoodsId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GoodsDetailResponseEntity>() {
                    @Override
                    public void accept(GoodsDetailResponseEntity goodsDetailResponseEntity) throws Exception {
                        if (goodsDetailResponseEntity != null && goodsDetailResponseEntity.isSuccess()) {

                            initContentData(goodsDetailResponseEntity);
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
//                        ToastUtils.showShort(GoodsDetailActivity.this, throwable.getMessage());
                        LogUtils.i(throwable.getMessage());

                    }
                });


    }

    private void initContentData(GoodsDetailResponseEntity responseEntity) {

        GoodsDetailResponseEntity.DataBean data = responseEntity.getData();

        initBanner(data);

        initGoodsDetail(data);

        initBottomDetailInfo(data);
    }

    private void initBanner(GoodsDetailResponseEntity.DataBean data) {

        List<String> urls = new ArrayList<>();

        List<GoodsDetailResponseEntity.DataBean.BannersBean> banners = data.getBanners();

        for (int i = 0; i < banners.size(); i++) {

            urls.add(banners.get(i).getFileUrl());
        }

        goodsDetailBanner.setImages(urls)
                .setImageLoader(new GlideImageLoader())
                .start();

    }

    private void initGoodsDetail(GoodsDetailResponseEntity.DataBean data) {

        LogUtils.i(GsonUtil.GsonString(data));

        goodsDetailTitle.setText(data.getName());
        goodsDetailIntegate.setText(new BigDecimal(data.getIntegral()).toPlainString());
        goodsDetailPrice.setText("市场价" + data.getPrice() + "元");


    }

    private void initBottomDetailInfo(GoodsDetailResponseEntity.DataBean data) {

        List<GoodsDetailResponseEntity.DataBean.InformationBean> information = data.getInformation();

        if (information != null && information.size() > 0) {

            GoodsDetailResponseEntity.DataBean.InformationBean informationBean = information.get(0);

            List<Fragment> fragments = new ArrayList<>();

            GoodsDetailFragment detailFragment = new GoodsDetailFragment();

            Bundle bundle = new Bundle();
            bundle.putString("picUrl", informationBean.getFileUrl());
            detailFragment.setArguments(bundle);

            fragments.add(detailFragment);

            GoodsDetailInfoFragment infoFragment = new GoodsDetailInfoFragment();

            Bundle bundleInfo = new Bundle();
//            bundleInfo.putString("goodsInfo", informationBean.getFileName());
            bundleInfo.putString("goodsInfo", data.getExplainText());
            infoFragment.setArguments(bundleInfo);
            fragments.add(infoFragment);

            List<String> titles = new ArrayList<>();

            titles.add("详情");
            titles.add("介绍");

            goodsSimpleBottomAdapter = new GoodsSimpleBottomAdapter(getSupportFragmentManager(), this, fragments, titles);

            goodsDetailViewpager.setAdapter(goodsSimpleBottomAdapter);

            goodsDetailSlidingTabs.setupWithViewPager(goodsDetailViewpager);
            goodsDetailSlidingTabs.setTabMode(TabLayout.MODE_FIXED);

        }


    }


    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext())
                    .load(path)
                    .into(imageView);
        }


    }

}
