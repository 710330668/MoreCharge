package com.example.hdd.morecharge.receive.main.goodsdetail;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hdd.common.BaseActivity;
import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.receive.main.goodsdetail.widget.AmountView;
import com.example.hdd.morecharge.ui.widget.TopBar;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

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
//    @BindView(R.id.btn)
//    Button btn;

    @Override
    public int bindLayout() {
        return R.layout.activity_goods_detail;
    }

    @Override
    public void initParams(Bundle params) {

    }

    BottomSheetDialog bottomSheetDialog;
    BottomSheetDialog bottomPayDialog;

    @Override
    public void setView(Bundle savedInstanceState) {
        initTopBar();
        initBanner();
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
                ToastUtils.showLong(GoodsDetailActivity.this, "点击");
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

    private void initBanner() {
        List<String> urls = new ArrayList<>();

        urls.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic1xjab4j30ci08cjrv.jpg");
        urls.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        urls.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
        urls.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2b16zuj30ci08cwf4.jpg");
        urls.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");

        goodsDetailBanner.setImages(urls)
                .setImageLoader(new GlideImageLoader())
                .start();

    }

    @Override
    public void doBusiness(Context mContext) {

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
