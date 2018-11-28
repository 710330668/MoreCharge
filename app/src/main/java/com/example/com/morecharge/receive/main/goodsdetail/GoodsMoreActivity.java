package com.example.com.morecharge.receive.main.goodsdetail;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.com.common.BaseActivity;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.main.goodsdetail.goodsadapter.GoodsMoreAdapter;
import com.example.com.morecharge.receive.main.integrate.entity.IntegrateDelegate;
import com.example.com.morecharge.receive.main.integrate.entity.IntegrateEntity;
import com.example.com.morecharge.ui.widget.TopBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GoodsMoreActivity extends BaseActivity {
    @BindView(R.id.goods_more_topbar)
    TopBar goodsMoreTopbar;
    @BindView(R.id.goods_more_recy)
    RecyclerView goodsMoreRecy;

    @Override
    public int bindLayout() {
        return R.layout.activity_goods_more;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void setView(Bundle savedInstanceState) {

        initTopBar();
        initRecycler();
    }

    private void initTopBar() {

        goodsMoreTopbar.setOnTopBarClickListener(new TopBar.OnTopBarClickListener() {
            @Override
            public void onTopBarRightClick(View v) {

            }

            @Override
            public void onTopBarLeftClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    public void doBusiness(Context mContext) {

    }

    private void initRecycler() {

        List<IntegrateEntity> datas = new ArrayList<>();

        for (int i = 0; i < 20; i++) {

            datas.add(new IntegrateEntity("title" + i));

        }

        goodsMoreRecy.setLayoutManager(new LinearLayoutManager(this));

        GoodsMoreAdapter goodsMoreAdapter = new GoodsMoreAdapter(R.layout.view_integrade_item, datas);


        goodsMoreRecy.setAdapter(goodsMoreAdapter);

    }

}
