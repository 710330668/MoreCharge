package com.example.hdd.morecharge.usercenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioGroup;

import com.example.hdd.common.BaseActivity;
import com.example.hdd.common.adapter.BaseAdapter;
import com.example.hdd.common.adapter.ItemData;
import com.example.hdd.common.adapter.onItemClickListener;
import com.example.hdd.common.util.LogUtils;
import com.example.hdd.common.util.SP;
import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.config.C;
import com.example.hdd.morecharge.receive.main.ReceiveAppraiseActivity;
import com.example.hdd.morecharge.remote.Injection;
import com.example.hdd.morecharge.remote.SettingDelegate;
import com.example.hdd.morecharge.usercenter.request.CancelOrderRequest;
import com.example.hdd.morecharge.usercenter.request.CompleteOrderRequest;
import com.example.hdd.morecharge.usercenter.request.MyReceiveOrdersRequest;
import com.example.hdd.morecharge.usercenter.response.CompleteOrderResponse;
import com.example.hdd.morecharge.usercenter.response.MyReceiveOrdersResponse;
import com.example.hdd.morecharge.usercenter.viewholder.MyReceiveOrdersViewHolder;
import com.example.hdd.morecharge.utils.EndlessRecyclerOnScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 71033 on 2018/12/4.
 */
public class MyReceiveOrdersActivity extends BaseActivity {

    @BindView(R.id.ll_tab)
    RadioGroup llTab;
    @BindView(R.id.rlv_receive)
    RecyclerView rlvReceive;

    private String orderState = "";

    private String accessToken = "";

    private   int CURRENT_PAGE = 1;
    private   int PAGE_SIZE = 10;

    private BaseAdapter baseAdapter;

    private int count;

    private List<ItemData> myOrders = new ArrayList<>();

    @Override
    public int bindLayout() {
        return R.layout.activity_my_receive_orders;
    }

    @Override
    public void initParams(Bundle params) {
        accessToken = SP.getInstance(C.USER_DB, this).getString(C.USER_ACCESS_TOKEN, "");
    }

    @Override
    public void setView(Bundle savedInstanceState) {
        rlvReceive.setLayoutManager(new LinearLayoutManager(this));
        rlvReceive.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                baseAdapter.setLoadState(baseAdapter.LOADING);
                if(myOrders.size() < count){
                    ++CURRENT_PAGE;
                    getMyReceiveOrders();
                }else{
                    baseAdapter.setLoadState(baseAdapter.LOADING_END);
                }
            }
        });
    }

    @Override
    public void doBusiness(Context mContext) {
        SettingDelegate delegate = new SettingDelegate();
        delegate.setOnCompleteOrderListener(new MyReceiveOrdersViewHolder.onCompleteOrderListener() {
            @Override
            public void completeOrder(MyReceiveOrdersResponse.DataBean.RecordsBean recordsBean) {
                orderComplete(recordsBean);
            }
        });
        delegate.setOnCancelOrderListener(new MyReceiveOrdersViewHolder.onCancelOrderListener() {
            @Override
            public void cancelOrder(MyReceiveOrdersResponse.DataBean.RecordsBean recordsBean) {
                orderCancel(recordsBean);
            }
        });
        delegate.setOnAppraiseOrderListener(new MyReceiveOrdersViewHolder.onAppraiseOrderListener() {
            @Override
            public void appraiseOrder(MyReceiveOrdersResponse.DataBean.RecordsBean recordsBean) {
                //评价
                startActivity(ReceiveAppraiseActivity.class);
            }
        });
        baseAdapter = new BaseAdapter(myOrders, delegate, new onItemClickListener() {
            @Override
            public void onClick(View v, Object data) {
            }

            @Override
            public boolean onLongClick(View v, Object data) {
                return false;
            }
        });
        rlvReceive.setAdapter(baseAdapter);

    }

    @SuppressLint("CheckResult")
    private void orderCancel(MyReceiveOrdersResponse.DataBean.RecordsBean recordsBean) {
        CancelOrderRequest request = new CancelOrderRequest();
        request.setOrderId(recordsBean.getOrderInfo().getId());
        request.setOrderType(recordsBean.getOrderInfo().getOrderType());
        Injection.provideApiService().cancelOrders("Bearer" + accessToken, request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CompleteOrderResponse>() {
                    @Override
                    public void accept(CompleteOrderResponse response) throws Exception {
                        if(response.isSuccess()){
                            ToastUtils.showShort(MyReceiveOrdersActivity.this,response.getMsg());
                            CURRENT_PAGE = 1;
                            myOrders.clear();
                            getMyReceiveOrders();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogUtils.e(throwable.getMessage());
                    }
                });
    }

    @SuppressLint("CheckResult")
    private void orderComplete(MyReceiveOrdersResponse.DataBean.RecordsBean recordsBean) {
        CompleteOrderRequest request = new CompleteOrderRequest();
        request.setOrderId(recordsBean.getOrderInfo().getId());
        request.setOrderType(recordsBean.getOrderInfo().getOrderType());
        Injection.provideApiService().completeOrders("Bearer" + accessToken, request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CompleteOrderResponse>() {
                    @Override
                    public void accept(CompleteOrderResponse response) throws Exception {
                        if(response.isSuccess()){
                            ToastUtils.showShort(MyReceiveOrdersActivity.this,response.getMsg());
                            CURRENT_PAGE = 1;
                            myOrders.clear();
                            getMyReceiveOrders();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogUtils.e(throwable.getMessage());
                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        CURRENT_PAGE = 1;
        myOrders.clear();
        getMyReceiveOrders();
    }

    @SuppressLint("CheckResult")
    private void getMyReceiveOrders() {
        MyReceiveOrdersRequest request = new MyReceiveOrdersRequest();
        request.setOrderState(orderState);
        request.setPageNum(CURRENT_PAGE+"");
        request.setPageSize(PAGE_SIZE+"");
        if(myOrders.size()>0){
            myOrders.remove(myOrders.size()-1);
        }
        Injection.provideApiService().getMyReceiveOrders("Bearer" + accessToken,request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MyReceiveOrdersResponse>() {
                    @Override
                    public void accept(MyReceiveOrdersResponse response) throws Exception {
                        if(response.isSuccess()){
                            count = Integer.valueOf(response.getData().getSize());
                            if(response.getData().getRecords().size() == 0){
                                baseAdapter.setLoadState(baseAdapter.LOADING_END);
                                return;
                            }
                            for(int i = 0 ;i < response.getData().getRecords().size() ; i ++){
                                myOrders.add(new ItemData(0, SettingDelegate.MY_RECEIVE_ORDERS,response.getData().getRecords().get(i)));
                            }
                            ItemData e = new ItemData(0, SettingDelegate.FOOT_TYPE, "");
                            myOrders.add(e);
                            baseAdapter.notifyDataSetChanged();
                            baseAdapter.setLoadState(baseAdapter.LOADING_COMPLETE);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogUtils.e(throwable.getMessage());
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rb_all, R.id.rb_ongoing, R.id.rb_complete, R.id.rb_evaluate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_all:
                orderState = "";
                CURRENT_PAGE = 1;
                myOrders.clear();
                getMyReceiveOrders();
                break;
            case R.id.rb_ongoing:
                orderState = "ING";
                CURRENT_PAGE = 1;
                myOrders.clear();
                getMyReceiveOrders();
                break;
            case R.id.rb_complete:
                orderState = "FINISH";
                CURRENT_PAGE = 1;
                myOrders.clear();
                getMyReceiveOrders();
                break;
            case R.id.rb_evaluate:
                orderState = "COMMENT";
                CURRENT_PAGE = 1;
                myOrders.clear();
                getMyReceiveOrders();
                break;
        }

    }
}
