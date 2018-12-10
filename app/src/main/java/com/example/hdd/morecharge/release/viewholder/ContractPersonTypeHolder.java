package com.example.hdd.morecharge.release.viewholder;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.hdd.common.adapter.BaseViewHolder;
import com.example.hdd.common.adapter.ItemData;
import com.example.hdd.morecharge.R;

import java.util.ArrayList;
import java.util.List;

public class ContractPersonTypeHolder extends BaseViewHolder {

    private CheckBox mTvTypeWork;
    private static final String TAG = "ContractPersonTypeHolde";

    /**
     * TODO
     * single view may be direct construction, eg: TextView view = new TextView(context);
     *
     * @param parent current no use, may be future use
     * @param view
     */
    public ContractPersonTypeHolder(ViewGroup parent, View view) {
        super(parent, view);
    }

    @Override
    public void findViews() {
        mTvTypeWork =  itemView.findViewById(R.id.rb_type_of_work);
    }

    @Override
    public void onBindViewHolder(Object data, int position) {
        String itemDesc = ((ItemData) data).getItemDesc();
        mTvTypeWork.setText(itemDesc);
    }
}
