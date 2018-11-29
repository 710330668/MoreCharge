package com.example.com.morecharge.remote;

import android.view.ViewGroup;

import com.example.com.common.adapter.BaseDelegate;
import com.example.com.common.adapter.BaseViewHolder;
import com.example.com.common.adapter.ItemData;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.viewholder.SortCommonViewHolder;

/**
 * Created by 71033 on 2018/11/16.
 */
public class SettingDelegate extends BaseDelegate<ItemData> {

    public static final int SORT_COMMON_STATUS = 0;


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case SORT_COMMON_STATUS:
                return new SortCommonViewHolder(parent,getItemView(parent,viewType));
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
                default:
        }
        return 0;
    }
}
