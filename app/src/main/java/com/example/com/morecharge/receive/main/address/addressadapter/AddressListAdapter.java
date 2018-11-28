package com.example.com.morecharge.receive.main.address.addressadapter;

import com.example.com.common.adapter.BaseAdapter;
import com.example.com.common.adapter.BaseDelegate;
import com.example.com.common.adapter.onItemClickListener;
import com.example.com.morecharge.receive.main.address.entity.AddressEntity;

import java.util.List;

public class AddressListAdapter extends BaseAdapter<AddressEntity> {
    public AddressListAdapter(List<AddressEntity> dataList, BaseDelegate delegate) {
        this(dataList, delegate, null);
    }

    public AddressListAdapter(List<AddressEntity> dataList, BaseDelegate delegate, onItemClickListener listener) {
        super(dataList, delegate, listener);
    }
}
