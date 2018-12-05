package com.example.hdd.morecharge.release.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.hdd.common.adapter.BaseViewHolder;
import com.example.hdd.common.adapter.ItemData;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.receive.model.SortModel;

public class GoodPropertyViewHolder extends BaseViewHolder {
    private RadioButton mRbProperty;
    /**
     * TODO
     * single view may be direct construction, eg: TextView view = new TextView(context);
     *
     * @param parent current no use, may be future use
     * @param view
     */
    public GoodPropertyViewHolder(ViewGroup parent, View view) {
        super(parent, view);
    }

    @Override
    public void findViews() {
        mRbProperty=((RadioButton) itemView.findViewById(R.id.btn_good_property));
    }

    @Override
    public void onBindViewHolder(Object data, int position) {
        String itemDesc = ((ItemData) data).getItemDesc();
        mRbProperty.setText(itemDesc);
    }
}
