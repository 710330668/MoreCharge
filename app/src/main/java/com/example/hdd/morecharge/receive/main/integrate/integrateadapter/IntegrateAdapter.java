package com.example.hdd.morecharge.receive.main.integrate.integrateadapter;

import com.example.hdd.common.adapter.BaseAdapter;
import com.example.hdd.common.adapter.BaseDelegate;
import com.example.hdd.common.adapter.onItemClickListener;
import com.example.hdd.morecharge.receive.main.integrate.entity.IntegrateEntity;

import java.util.List;

public class IntegrateAdapter extends BaseAdapter<IntegrateEntity> {


    public IntegrateAdapter(List<IntegrateEntity> dataList, BaseDelegate delegate) {
        this(dataList, delegate,null);
    }

    public IntegrateAdapter(List<IntegrateEntity> dataList, BaseDelegate delegate, onItemClickListener listener) {
        super(dataList, delegate, listener);
    }
}
