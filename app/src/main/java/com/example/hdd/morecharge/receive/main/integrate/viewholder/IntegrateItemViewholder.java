package com.example.hdd.morecharge.receive.main.integrate.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hdd.common.adapter.BaseViewHolder;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.receive.main.integrate.entity.IntegrateEntity;

public class IntegrateItemViewholder extends BaseViewHolder<IntegrateEntity> {

    private TextView tvContent;

    /**
     * TODO
     * single view may be direct construction, eg: TextView view = new TextView(context);
     *
     * @param parent current no use, may be future use
     * @param view
     */
    public IntegrateItemViewholder(ViewGroup parent, View view) {
        super(parent, view);
    }

    @Override
    public void findViews() {
        tvContent = itemView.findViewById(R.id.integrade_item_title_tv);
    }

    @Override
    public void onBindViewHolder(IntegrateEntity data, int position) {

        tvContent.setText(data.getTitle());

    }
}
