package com.example.hdd.morecharge.receive.main.address.viewholder;

import android.view.ViewGroup;

import com.example.hdd.common.adapter.BaseDelegate;
import com.example.hdd.common.adapter.BaseViewHolder;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.receive.main.address.entity.AddressEntity;
import com.example.hdd.morecharge.receive.main.integrate.viewholder.EmptyViewHolder;

public class AddressListDelgate extends BaseDelegate<AddressEntity> {

    /**
     * 空数据时，显示空布局类型
     */
    public static final int EMPTY_VIEW = 1;

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {

            case EMPTY_VIEW:

                return new EmptyViewHolder(parent, getItemView(parent, viewType));
            default:
                return new AddressListViewHolder(parent, getItemView(parent, viewType));


        }
    }

    @Override
    public int getItemViewType(AddressEntity data) {
        return data.getHolderType();
    }

    @Override
    public int getLayoutId(int viewType) {
        switch (viewType) {

            case EMPTY_VIEW:
                return R.layout.view_stub_empty;
            default:
                return R.layout.view_address_list_item;


        }
    }
}
