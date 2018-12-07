package com.example.com.morecharge.receive.main.goodsdetail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.com.common.BaseActivity;
import com.example.com.common.util.ToastUtils;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.main.goodsdetail.entry.EmptyRequestEntry;
import com.example.com.morecharge.receive.main.integrate.entity.IntegGoodsListResponse;
import com.example.com.morecharge.receive.main.integrate.integrateadapter.IntegrateAdapter;
import com.example.com.morecharge.receive.main.integrate.listener.EndlessRecyclerOnScrollListener;
import com.example.com.morecharge.receive.main.myskills.TempConstant;
import com.example.com.morecharge.remote.Injection;
import com.example.com.morecharge.ui.widget.TopBar;
import com.example.com.morecharge.utils.GsonUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class GoodsMoreActivity extends BaseActivity {
    @BindView(R.id.goods_more_topbar)
    TopBar goodsMoreTopbar;
    @BindView(R.id.goods_more_recy)
    RecyclerView intgradeRecy;
    @BindView(R.id.goods_more_swipe_refresh)
    SwipeRefreshLayout goodsMoreSwipeRefresh;

    private List<IntegGoodsListResponse.DataBean.RecordsBean> goodsRecordsList;
    private IntegrateAdapter integrateAdapter;

    private int pageNum = 1;
    private int pageSize = 10;

    @Override
    public int bindLayout() {
        return R.layout.activity_goods_more;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void setView(Bundle savedInstanceState) {

        initTopBar();
        initRecycler();
    }


    @Override
    public void doBusiness(Context mContext) {

        getGoodsList(pageNum);

    }

    @SuppressLint("CheckResult")
    private void getGoodsList(int pageNum) {
        Injection.provideApiService().getGoodsList(TempConstant.token, pageNum, pageSize, GsonUtil.getRequestBody(new EmptyRequestEntry()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<IntegGoodsListResponse>() {
                    @Override
                    public void accept(IntegGoodsListResponse goodsListResponse) throws Exception {

                        List<IntegGoodsListResponse.DataBean.RecordsBean> records = goodsListResponse.getData().getRecords();

                        if (goodsMoreSwipeRefresh != null && goodsMoreSwipeRefresh.isRefreshing()) {
                            goodsMoreSwipeRefresh.setRefreshing(false);
                        }
                        
                        if (records != null) {
                            integrateAdapter.addData(records);

                            if (records.size() < pageSize) {
                                integrateAdapter.setLoadState(integrateAdapter.LOADING_END);
                            } else {
                                integrateAdapter.setLoadState(integrateAdapter.LOADING_COMPLETE);

                            }

                        }


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showShort(GoodsMoreActivity.this, throwable.getMessage());
                    }
                });


    }


    private void initRecycler() {

        goodsRecordsList = new ArrayList<>();

        goodsMoreSwipeRefresh.setColorSchemeColors(Color.parseColor("#FD8B07"));
        intgradeRecy.setLayoutManager(new LinearLayoutManager(this));
        intgradeRecy.setHasFixedSize(true);
        integrateAdapter = new IntegrateAdapter(GoodsMoreActivity.this, goodsRecordsList);
        intgradeRecy.setAdapter(integrateAdapter);
        intgradeRecy.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                startLoadNextPage();
            }
        });

        goodsMoreSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                startLoadFirstPage();
            }
        });

    }

    public void startLoadFirstPage() {

        if (goodsRecordsList != null && goodsRecordsList.size() > 0) {
            goodsRecordsList.clear();
        }

        integrateAdapter.setLoadState(integrateAdapter.LOADING);
        pageNum = 1;
        getGoodsList(pageNum);
    }

    public void startLoadNextPage() {

        integrateAdapter.setLoadState(integrateAdapter.LOADING);
        pageNum++;
        getGoodsList(pageNum);

    }

    private void initTopBar() {

        goodsMoreTopbar.setOnTopBarClickListener(new TopBar.OnTopBarClickListener() {
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
