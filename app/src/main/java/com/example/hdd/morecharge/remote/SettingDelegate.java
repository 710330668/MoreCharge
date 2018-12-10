package com.example.hdd.morecharge.remote;

import android.view.ViewGroup;

import com.example.hdd.common.adapter.BaseDelegate;
import com.example.hdd.common.adapter.BaseViewHolder;
import com.example.hdd.common.adapter.ItemData;
import com.example.hdd.common.util.RefreshFooterViewHolder;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.release.viewholder.ContractPersonTypeHolder;
import com.example.hdd.morecharge.release.viewholder.LocationPoiSearchViewHolder;
import com.example.hdd.morecharge.usercenter.viewholder.MyReceiveOrdersViewHolder;
import com.example.hdd.morecharge.receive.viewholder.ReceiveOrdersViewHolder;
import com.example.hdd.morecharge.receive.viewholder.SortCommonViewHolder;
import com.example.hdd.morecharge.release.viewholder.GoodPropertyViewHolder;

/**
 * Created by 71033 on 2018/11/16.
 */
public class SettingDelegate extends BaseDelegate<ItemData> {
    private static final String TAG = "SettingDelegate";

    public static final int SORT_COMMON_STATUS = 0;
    public static final int RELEASE_GOOD_PROPERTY = 1;
    public static final int RECEIVE_ORDERS = 2;
    public static final int CONTRACT_PERSON_TYPE = 3;
    public static final int LOCATION_POI_SEARCH_TYPE = 4;
    public static final int MY_RECEIVE_ORDERS = 5;

    public static final int FOOT_TYPE = 99;


    private ReceiveOrdersViewHolder.onMoreListener listener;

    private ReceiveOrdersViewHolder.onDeleteListener deleteListener;

    private ReceiveOrdersViewHolder.onRobOrderListener robOrderListener;

    private MyReceiveOrdersViewHolder.onCompleteOrderListener completeOrderListener;

    private MyReceiveOrdersViewHolder.onCancelOrderListener cancelOrderListener;

    private MyReceiveOrdersViewHolder.onAppraiseOrderListener appraiseOrderListener;


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case SORT_COMMON_STATUS:
                return new SortCommonViewHolder(parent, getItemView(parent, viewType));
            case RELEASE_GOOD_PROPERTY:
                return new GoodPropertyViewHolder(parent, getItemView(parent, viewType));
            case RECEIVE_ORDERS:
                ReceiveOrdersViewHolder viewHolder = new ReceiveOrdersViewHolder(parent, getItemView(parent, viewType));
                viewHolder.setOnMoreListener(listener);
                viewHolder.setOnDeleteListener(deleteListener);
                viewHolder.setOnRobOrderListener(robOrderListener);
                return viewHolder;
            case CONTRACT_PERSON_TYPE:
                return new ContractPersonTypeHolder(parent, getItemView(parent, viewType));
            case LOCATION_POI_SEARCH_TYPE:
                return new LocationPoiSearchViewHolder(parent, getItemView(parent, viewType));
            case MY_RECEIVE_ORDERS:
                MyReceiveOrdersViewHolder myReceiveOrdersViewHolder = new MyReceiveOrdersViewHolder(parent, getItemView(parent, viewType));
                myReceiveOrdersViewHolder.setOnCompleteOrderListener(completeOrderListener);
                myReceiveOrdersViewHolder.setOnCancelOrderListener(cancelOrderListener);
                myReceiveOrdersViewHolder.setOnAppraiseOrderListener(appraiseOrderListener);
                return myReceiveOrdersViewHolder;
            case FOOT_TYPE:
                return new RefreshFooterViewHolder(parent, getItemView(parent, viewType));
            default:
                break;
        }
        return null;
    }

    @Override
    public int getItemViewType(ItemData data) {
        return data.holderType;
    }

    @Override
    public int getLayoutId(int viewType) {
        switch (viewType) {
            case SORT_COMMON_STATUS:
                return R.layout.item_sort_common;
            case RELEASE_GOOD_PROPERTY:
                return R.layout.item_good_property;
            case RECEIVE_ORDERS:
                return R.layout.item_receive_order;
            case MY_RECEIVE_ORDERS:
                return R.layout.item_my_receive_order;
            case FOOT_TYPE:
                return R.layout.layout_refresh_footer;
            case CONTRACT_PERSON_TYPE:
                return R.layout.item_person_type_of_work;
            case LOCATION_POI_SEARCH_TYPE:
                return R.layout.item_location_search_poi;
            default:
        }
        return 0;
    }


    public void setOnMoreListener(ReceiveOrdersViewHolder.onMoreListener listener) {
        this.listener = listener;
    }

    public void setOnDeleteListener(ReceiveOrdersViewHolder.onDeleteListener listener) {
        this.deleteListener = listener;
    }

    public void setOnRobOrderListener(ReceiveOrdersViewHolder.onRobOrderListener listener) {
        this.robOrderListener = listener;
    }

    public void setOnCompleteOrderListener(MyReceiveOrdersViewHolder.onCompleteOrderListener completeOrderListener) {
        this.completeOrderListener = completeOrderListener;
    }

    public void setOnCancelOrderListener(MyReceiveOrdersViewHolder.onCancelOrderListener cancelOrderListener) {
        this.cancelOrderListener = cancelOrderListener;
    }

    public void setOnAppraiseOrderListener(MyReceiveOrdersViewHolder.onAppraiseOrderListener appraiseOrderListener) {
        this.appraiseOrderListener = appraiseOrderListener;
    }
}
