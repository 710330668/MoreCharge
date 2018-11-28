package com.example.com.morecharge.receive.main.integrate.entity;

import android.view.ViewGroup;

import com.example.com.common.adapter.BaseDelegate;
import com.example.com.common.adapter.BaseViewHolder;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.main.integrate.viewholder.EmptyViewHolder;
import com.example.com.morecharge.receive.main.integrate.viewholder.IntegrateItemViewholder;

public class IntegrateDelegate extends BaseDelegate<IntegrateEntity> {

    /**
     * 空数据时，显示空布局类型
     */
    public static final int EMPTY_VIEW = 1;

    /**
     * 控制空布局的显隐
     */
    private static int mEmptyType = 0;

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {

            case EMPTY_VIEW:

                return new EmptyViewHolder(parent, getItemView(parent, viewType));
            default:
                return new IntegrateItemViewholder(parent, getItemView(parent, viewType));


        }

    }

    @Override
    public int getItemViewType(IntegrateEntity data) {
        return data.getHolderType();
    }

    @Override
    public int getLayoutId(int viewType) {

        switch (viewType) {

            case EMPTY_VIEW:
                return R.layout.view_stub_empty;
            default:
                return R.layout.view_integrade_item;


        }

    }
}
