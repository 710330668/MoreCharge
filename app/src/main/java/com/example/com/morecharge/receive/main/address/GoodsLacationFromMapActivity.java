package com.example.com.morecharge.receive.main.address;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.com.common.BaseActivity;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.main.address.addressadapter.GoodsLocationChooseAdapter;
import com.example.com.morecharge.receive.main.address.entity.GoodsLocationChoosEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsLacationFromMapActivity extends BaseActivity {
    @BindView(R.id.lacation_choose_city_tv)
    TextView lacationChooseCityTv;
    @BindView(R.id.lacation_choose_city_ll)
    LinearLayout lacationChooseCityLl;
    @BindView(R.id.lacation_choose_input_et)
    EditText lacationChooseInputEt;
    @BindView(R.id.lacation_choose_cancle)
    TextView lacationChooseCancle;
    @BindView(R.id.lacation_choose_ll)
    LinearLayout lacationChooseLl;
    @BindView(R.id.lacation_choose_recy)
    RecyclerView lacationChooseRecy;

    @Override
    public int bindLayout() {
        return R.layout.activity_goods_location_choose;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void setView(Bundle savedInstanceState) {

        initRecycler();

    }

    private void initRecycler() {
        List<GoodsLocationChoosEntity> choosEntityList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            choosEntityList.add(new GoodsLocationChoosEntity("山东省济南市" + i, "舜泰广场" + i));

        }
        lacationChooseRecy.setLayoutManager(new LinearLayoutManager(this));
        GoodsLocationChooseAdapter chooseAdapter = new GoodsLocationChooseAdapter(R.layout.view_goods_location_choose, choosEntityList);

        lacationChooseRecy.setAdapter(chooseAdapter);

    }

    @Override
    public void doBusiness(Context mContext) {

    }


    @OnClick({R.id.lacation_choose_city_ll, R.id.lacation_choose_cancle})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.lacation_choose_city_ll:

                break;
            case R.id.lacation_choose_cancle:

                onBackPressed();

                break;

        }

    }

}
