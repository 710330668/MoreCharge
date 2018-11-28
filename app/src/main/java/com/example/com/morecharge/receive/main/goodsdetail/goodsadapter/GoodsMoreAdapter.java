package com.example.com.morecharge.receive.main.goodsdetail.goodsadapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.main.integrate.entity.IntegrateEntity;

import java.util.List;

public class GoodsMoreAdapter extends BaseQuickAdapter<IntegrateEntity, BaseViewHolder> {
    public GoodsMoreAdapter(int layoutResId, @Nullable List<IntegrateEntity> data) {
        super(layoutResId, data);
    }

    public GoodsMoreAdapter(@Nullable List<IntegrateEntity> data) {
        super(data);
    }

    public GoodsMoreAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, IntegrateEntity item) {

        helper.setText(R.id.integrade_item_title_tv, item.getTitle());

    }
}
