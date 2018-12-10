package com.example.com.morecharge.receive.main.goodsdetail.goodsdetailpage;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.main.goodsdetail.GoodsPullUpToLoadMore;
import com.example.com.morecharge.receive.main.goodsdetail.GoodsScrollView;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GoodsDetailFragment extends Fragment {

    @BindView(R.id.goods_detail_large_iv)
    SubsamplingScaleImageView goodsDetailLargeIv;

    @BindView(R.id.goods_detail_iv_container)
    LinearLayout goodsDetailIvContainer;
    @BindView(R.id.oneScrollview)
    GoodsScrollView oneScrollview;
    Unbinder unbinder;
    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_goods_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;

    }

    private void initView() {

        initScrollView();
        initLargeIv();

    }

    private void initLargeIv() {
        Bundle bundle = getArguments();
        if (bundle != null) {

            String picUrl = bundle.getString("picUrl");
            goodsDetailLargeIv.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CUSTOM);
            goodsDetailLargeIv.setMinScale(1.0f);
            goodsDetailLargeIv.setZoomEnabled(false);

//        下载图片保存到本地
            Glide.with(this).load(picUrl).downloadOnly(new SimpleTarget<File>() {
                @Override
                public void onResourceReady(File resource, GlideAnimation<? super File> glideAnimation) {
                    // 将保存的图片地址给SubsamplingScaleImageView,这里注意设置ImageViewState设置初始显示比例
                    goodsDetailLargeIv.setImage(ImageSource.uri(Uri.fromFile(resource)), new ImageViewState(1.5F, new PointF(0, 0), 0));

                }
            });


        }

    }

    private void initScrollView() {

        oneScrollview.setScrollListener(new GoodsScrollView.ScrollListener() {
            @Override
            public void onScrollToBottom() {

            }

            @Override
            public void onScrollToTop() {

            }

            @Override
            public void onScroll(int scrollY) {

                if (scrollY == 0) {
                    GoodsPullUpToLoadMore.isTop = true;
                } else {
                    GoodsPullUpToLoadMore.isTop = false;
                }
            }

            @Override
            public void notBottom() {

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
