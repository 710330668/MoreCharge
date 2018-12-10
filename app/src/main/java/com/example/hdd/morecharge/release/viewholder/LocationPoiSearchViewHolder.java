package com.example.hdd.morecharge.release.viewholder;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amap.api.services.core.PoiItem;
import com.example.hdd.common.adapter.BaseViewHolder;
import com.example.hdd.common.adapter.ItemData;
import com.example.hdd.morecharge.R;
import com.google.gson.Gson;

public class LocationPoiSearchViewHolder extends BaseViewHolder<ItemData> {


    private TextView mTvTitle1;
    private TextView mTvTitle2;
    private static final String TAG = "LocationPoiSearchViewHo";
    /**
     * TODO
     * single view may be direct construction, eg: TextView view = new TextView(context);
     *
     * @param parent current no use, may be future use
     * @param view
     */
    public LocationPoiSearchViewHolder(ViewGroup parent, View view) {
        super(parent, view);
    }

    @Override
    public void findViews() {
        mTvTitle1 =itemView.findViewById(R.id.tv_position_1);
        mTvTitle2 =itemView.findViewById(R.id.tv_position_2);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ItemData data, int position) {
        //        {"A":"071400","B":"","a":"B0FFHD772H","b":"","c":"370213","d":"0532","e":"生活服务;洗浴推拿场所;洗浴推拿场所","f":127,"g":{"a":36.172695,"b":120.403046},"h":"推拿按摩馆","i":"升平路22-34号楼附近","l":"","m":"","n":"","o":"","p":"山东省","q":"青岛市","r":"李沧区","s":false,"t":{"a":"","b":0,"c":""},"u":"370000","v":"","w":"","x":[],"y":[{"a":"","b":"http://store.is.autonavi.com/showpic/9f3e3b1e81ed153fe750394cc5d02d0b"}],"z":{"a":"","b":""}}
        PoiItem data1 = (PoiItem) data.getData();
        mTvTitle1.setText(data1.getProvinceName() + data1.getCityName() + data1.getAdName() + data1.getBusinessArea());
        mTvTitle2.setText(data1.getTitle());
    }
}
