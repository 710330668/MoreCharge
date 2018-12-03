package com.example.com.morecharge.receive.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;

import com.example.com.common.BaseActivity;
import com.example.com.common.adapter.BaseAdapter;
import com.example.com.common.adapter.ItemData;
import com.example.com.common.adapter.onItemClickListener;
import com.example.com.common.util.SP;
import com.example.com.common.util.ToastUtils;
import com.example.com.morecharge.R;
import com.example.com.morecharge.config.C;
import com.example.com.morecharge.receive.model.SortModel;
import com.example.com.morecharge.receive.request.ReceiveOrdersRequest;
import com.example.com.morecharge.receive.response.ReceiveOrdersResponse;
import com.example.com.morecharge.receive.viewholder.ReceiveOrdersViewHolder;
import com.example.com.morecharge.remote.Injection;
import com.example.com.morecharge.remote.SettingDelegate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 71033 on 2018/11/19.
 */
public class ReceiveOrderListActivity extends BaseActivity {

    @BindView(R.id.ll_tab)
    RadioGroup mRadioGroup;
    @BindView(R.id.rlv_receive)
    RecyclerView rlvReceive;

    private List<ItemData> timeDates, priceDates, distanceDates;

    private List<ItemData> rlOrders;

    private PopupWindow mPopupWindow;

    private BaseAdapter adapter ;

    private String accessToken = "";

    @Override
    public int bindLayout() {
        return R.layout.activity_receive_orders;
    }

    @Override
    public void initParams(Bundle params) {
        timeDates = new ArrayList<>();
        timeDates.add(new ItemData(0, SettingDelegate.SORT_COMMON_STATUS, new SortModel("时间由早到晚", "")));
        timeDates.add(new ItemData(0, SettingDelegate.SORT_COMMON_STATUS, new SortModel("时间由晚到早", "")));
        priceDates = new ArrayList<>();
        priceDates.add(new ItemData(0, SettingDelegate.SORT_COMMON_STATUS, new SortModel("价格由低到高", "")));
        priceDates.add(new ItemData(0, SettingDelegate.SORT_COMMON_STATUS, new SortModel("价格由高到低", "")));
        distanceDates = new ArrayList<>();
        distanceDates.add(new ItemData(0, SettingDelegate.SORT_COMMON_STATUS, new SortModel("距离由近到远", "")));
        distanceDates.add(new ItemData(0, SettingDelegate.SORT_COMMON_STATUS, new SortModel("距离由远到近", "")));
        accessToken = SP.getInstance(C.USER_DB, this).getString(C.USER_ACCESS_TOKEN, "");
        rlOrders = new ArrayList<>();
    }

    @Override
    public void setView(Bundle savedInstanceState) {
        rlvReceive.setLayoutManager(new LinearLayoutManager(this));
        SettingDelegate delegate = new SettingDelegate();
        delegate.setOnMoreListener(new ReceiveOrdersViewHolder.onMoreListener() {
            @Override
            public void gotoOrderDetail(int position) {
                Intent intent = new Intent(ReceiveOrderListActivity.this,ReceiveOrderDetailActivity.class);
                intent.putExtra("order",rlOrders.get(position));
                startActivity(intent);
            }
        });
        rlvReceive.setAdapter(adapter = new BaseAdapter(rlOrders, delegate, new onItemClickListener() {
            @Override
            public void onClick(View v, Object data) {

            }

            @Override
            public boolean onLongClick(View v, Object data) {
                return false;
            }
        }));
    }

    @Override
    public void doBusiness(Context mContext) {
        getOrders();
    }

    @SuppressLint("CheckResult")
    private void getOrders() {
        ReceiveOrdersRequest request = new ReceiveOrdersRequest();
        request.setLongitude("117.070803");
        request.setLatitude("36.666502");
        request.setOrderBy("distance");
        request.setDescOrAsc("asc");
        Injection.provideApiService().getClientList( "Bearer " + accessToken, request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ReceiveOrdersResponse>() {
                    @Override
                    public void accept(ReceiveOrdersResponse response) throws Exception {
                        ToastUtils.showShort(ReceiveOrderListActivity.this, "成功");
                        if (response.isSuccess()) {
                            for(int i = 0; i < response.getData().size();i++){
                                rlOrders.add(new ItemData(0,SettingDelegate.RECEIVE_ORDERS,response.getData().get(i))) ;
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showShort(ReceiveOrderListActivity.this, throwable.getMessage());
                    }
                });
    }

    @OnClick({R.id.rb_all, R.id.rb_time, R.id.rb_car_price, R.id.rb_distance, R.id.ll_tab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_all:
                break;
            case R.id.rb_time:
                showPopupWindow(timeDates);
                break;
            case R.id.rb_car_price:
                showPopupWindow(priceDates);
                break;
            case R.id.rb_distance:
                showPopupWindow(distanceDates);
                break;
            case R.id.ll_tab:
                break;
        }
    }


    private void showPopupWindow(List<ItemData> dataList) {
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        LinearLayout convertFrame = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.layout_pop_receive_order_status, null);
        RecyclerView stateRecycler = (RecyclerView) convertFrame.findViewById(R.id.rlv_status);
        initStateRecycler(stateRecycler, dataList);
        mPopupWindow = new PopupWindow(convertFrame, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setBackgroundDrawable(dw);
        mPopupWindow.showAsDropDown(mRadioGroup, 0, 0);
    }


    /**
     * 初始化 状态recycler
     *
     * @param stateRecycler
     */
    private void initStateRecycler(RecyclerView stateRecycler, List<ItemData> dataList) {
        stateRecycler.setLayoutManager(new LinearLayoutManager(this));
        stateRecycler.setAdapter(new BaseAdapter(dataList, new SettingDelegate(), new onItemClickListener() {
            @Override
            public void onClick(View v, Object data) {

            }

            @Override
            public boolean onLongClick(View v, Object data) {
                return false;
            }
        }));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
