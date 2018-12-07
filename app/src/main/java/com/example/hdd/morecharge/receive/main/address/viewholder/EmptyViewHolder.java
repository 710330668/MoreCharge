package com.example.hdd.morecharge.receive.main.address.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hdd.common.adapter.BaseViewHolder;
import com.example.hdd.morecharge.R;

public class EmptyViewHolder extends BaseViewHolder {

    private TextView tvContent;

    /**
     * TODO
     * single view may be direct construction, eg: TextView view = new TextView(context);
     *
     * @param parent current no use, may be future use
     * @param view
     */
    public EmptyViewHolder(ViewGroup parent, View view) {
        super(parent, view);
    }

    @Override
    public void findViews() {

        tvContent = itemView.findViewById(R.id.tv_empty_text);

    }

    @Override
    public void onBindViewHolder(Object data, int position) {

        tvContent.setText("暂无数据");

    }
}
