package com.example.com.morecharge.receive.main.integrate.integrateadapter;

import com.example.com.common.adapter.BaseAdapter;
import com.example.com.common.adapter.BaseDelegate;
import com.example.com.common.adapter.onItemClickListener;
import com.example.com.morecharge.receive.main.integrate.entity.IntegrateEntity;

import java.util.List;

public class IntegrateAdapter extends BaseAdapter<IntegrateEntity> {


    public IntegrateAdapter(List<IntegrateEntity> dataList, BaseDelegate delegate) {
        this(dataList, delegate,null);
    }

    public IntegrateAdapter(List<IntegrateEntity> dataList, BaseDelegate delegate, onItemClickListener listener) {
        super(dataList, delegate, listener);
    }
}
