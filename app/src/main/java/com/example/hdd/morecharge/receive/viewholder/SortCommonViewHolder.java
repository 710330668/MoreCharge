package com.example.hdd.morecharge.receive.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hdd.common.adapter.BaseViewHolder;
import com.example.hdd.common.adapter.ItemData;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.receive.model.SortModel;

/**
 * Created by 71033 on 2018/11/21.
 */
public class SortCommonViewHolder extends BaseViewHolder {

    private TextView tvContent;

    /**
     * TODO
     * single view may be direct construction, eg: TextView view = new TextView(context);
     *
     * @param parent current no use, may be future use
     * @param view
     */
    public SortCommonViewHolder(ViewGroup parent, View view) {
        super(parent, view);
    }

    @Override
    public void findViews() {
        tvContent = itemView.findViewById(R.id.tv_content);
    }

    @Override
    public void onBindViewHolder(Object data, int position) {
        SortModel sortModel = (SortModel) ((ItemData)data).data;
        tvContent.setText(sortModel.getStatusName());
    }
}
