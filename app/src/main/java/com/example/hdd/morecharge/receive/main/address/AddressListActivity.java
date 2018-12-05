package com.example.hdd.morecharge.receive.main.address;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.hdd.common.BaseActivity;
import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.receive.main.address.addressadapter.AddressListAdapter;
import com.example.hdd.morecharge.receive.main.address.entity.AddressEntity;
import com.example.hdd.morecharge.receive.main.address.viewholder.AddressListDelgate;
import com.example.hdd.morecharge.ui.widget.TopBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 地址列表
 */
public class AddressListActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.address_list_topbar)
    TopBar addressListTopbar;
    @BindView(R.id.address_list_recy)
    RecyclerView addressListRecy;
    @BindView(R.id.address_add_btn)
    Button addressAddBtn;


    @Override
    public int bindLayout() {
        return R.layout.activity_address_list;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void setView(Bundle savedInstanceState) {
        topbarOnClick();
        initRecycler();
        addressAddBtn.setOnClickListener(this);
    }

    private void topbarOnClick() {

        addressListTopbar.setOnTopBarClickListener(new TopBar.OnTopBarClickListener() {
            @Override
            public void onTopBarRightClick(View v) {

            }

            @Override
            public void onTopBarLeftClick(View v) {
                onBackPressed();
            }
        });

        addressListTopbar.setOnRightTvClickListener(new TopBar.OnRightTvClickListener() {
            @Override
            public void onRightTvClickListener(View v) {

                ToastUtils.showLong(AddressListActivity.this, "文字点击");

            }
        });

    }

    private AddressListAdapter addressListAdapter;

    private void initRecycler() {

        List<AddressEntity> datas = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            AddressEntity entity = new AddressEntity();
            entity.setTitle("地址" + i);
            datas.add(entity);

        }

        addressListAdapter = new AddressListAdapter(datas, new AddressListDelgate());
        addressListRecy.setLayoutManager(new LinearLayoutManager(this));
        addressListRecy.setAdapter(addressListAdapter);

    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void onClick(View v) {

        startActivity(AddAddressActivity.class);

    }
}
