package com.example.hdd.morecharge.receive.main.address;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hdd.common.BaseActivity;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.ui.widget.TopBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 新增地址
 */
public class AddAddressActivity extends BaseActivity {
    @BindView(R.id.add_address_topbar)
    TopBar addAddressTopbar;
    @BindView(R.id.add_address_username_et)
    EditText addAddressUsernameEt;
    @BindView(R.id.add_address_phone_tv)
    EditText addAddressPhoneTv;
    @BindView(R.id.add_address_select_tv)
    TextView addAddressSelectTv;
    @BindView(R.id.add_address_detail_et)
    EditText addAddressDetailEt;
    @BindView(R.id.address_add_btn)
    Button addressAddBtn;

    @Override
    public int bindLayout() {
        return R.layout.activity_add_address;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void setView(Bundle savedInstanceState) {

        initTopBar();

    }

    private void initTopBar() {

        addAddressTopbar.setOnTopBarClickListener(new TopBar.OnTopBarClickListener() {
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


    @OnClick({R.id.add_address_select_tv, R.id.address_add_btn})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.add_address_select_tv:
                startActivity(GoodsLacationFromMapActivity.class);
                break;
            case R.id.address_add_btn:


                break;

            default:
                break;

        }

    }

}
