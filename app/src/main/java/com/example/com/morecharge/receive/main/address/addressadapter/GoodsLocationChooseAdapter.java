package com.example.com.morecharge.receive.main.address.addressadapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.main.address.entity.GoodsLocationChoosEntity;

import java.util.List;

public class GoodsLocationChooseAdapter extends BaseQuickAdapter<GoodsLocationChoosEntity,BaseViewHolder> {
    public GoodsLocationChooseAdapter(int layoutResId, @Nullable List<GoodsLocationChoosEntity> data) {
        super(layoutResId, data);
    }

    public GoodsLocationChooseAdapter(@Nullable List<GoodsLocationChoosEntity> data) {
        super(data);
    }

    public GoodsLocationChooseAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsLocationChoosEntity item) {

        helper.setText(R.id.goods_location_zone,item.getLocationZone());
        helper.setText(R.id.goods_location_detail,item.getLocationDetail());

    }
}
