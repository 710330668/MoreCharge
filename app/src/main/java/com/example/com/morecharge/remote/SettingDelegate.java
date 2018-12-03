package com.example.com.morecharge.remote;

import android.view.ViewGroup;

import com.example.com.common.adapter.BaseDelegate;
import com.example.com.common.adapter.BaseViewHolder;
import com.example.com.common.adapter.ItemData;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.viewholder.ReceiveOrdersViewHolder;
import com.example.com.morecharge.receive.viewholder.SortCommonViewHolder;
import com.example.com.morecharge.release.viewholder.GoodPropertyViewHolder;

/**
 * Created by 71033 on 2018/11/16.
 */
public class SettingDelegate extends BaseDelegate<ItemData> {

    public static final int SORT_COMMON_STATUS = 0;
    public static final int RELEASE_GOOD_PROPERTY = 1;
    public static final int RECEIVE_ORDERS = 2;

    private ReceiveOrdersViewHolder.onMoreListener listener;


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case SORT_COMMON_STATUS:
                return new SortCommonViewHolder(parent,getItemView(parent,viewType));
            case RELEASE_GOOD_PROPERTY:
                return new GoodPropertyViewHolder(parent,getItemView(parent,viewType));
            case RECEIVE_ORDERS:
                ReceiveOrdersViewHolder viewHolder = new ReceiveOrdersViewHolder(parent,getItemView(parent,viewType));
                viewHolder.setOnMoreListener(listener);
                return viewHolder;
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
        switch (viewType){
            case SORT_COMMON_STATUS:
                return R.layout.item_sort_common;
            case RELEASE_GOOD_PROPERTY:
                return R.layout.item_good_property;
            case RECEIVE_ORDERS:
                return R.layout.item_receive_order;
                default:
        }
        return 0;
    }


    public void setOnMoreListener(ReceiveOrdersViewHolder.onMoreListener listener){
        this.listener = listener;
    }
}
