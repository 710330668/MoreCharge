package com.example.hdd.morecharge.receive.main.address.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hdd.common.adapter.BaseViewHolder;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.receive.main.address.entity.AddressEntity;

public class AddressListViewHolder extends BaseViewHolder<AddressEntity> {

    private TextView tvContent;

    /**
     * TODO
     * single view may be direct construction, eg: TextView view = new TextView(context);
     *
     * @param parent current no use, may be future use
     * @param view
     */
    public AddressListViewHolder(ViewGroup parent, View view) {
        super(parent, view);
    }

    @Override
    public void findViews() {
        tvContent = itemView.findViewById(R.id.address_address_item_tv);
    }

    @Override
    public void onBindViewHolder(AddressEntity data, int position) {
        tvContent.setText(data.getTitle());
    }
}
