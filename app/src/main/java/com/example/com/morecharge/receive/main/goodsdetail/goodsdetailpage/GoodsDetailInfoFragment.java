package com.example.com.morecharge.receive.main.goodsdetail.goodsdetailpage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.com.morecharge.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GoodsDetailInfoFragment extends Fragment {

    @BindView(R.id.goods_info_intro)
    TextView goodsInfoIntro;
    Unbinder unbinder;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.view_goods_detail_info_bottom, container, false);

        unbinder = ButterKnife.bind(this, view);
        initInfo();
        return view;
    }

    private void initInfo() {

        Bundle bundle = getArguments();
        if (bundle != null) {
            String goodsInfo = bundle.getString("goodsInfo");

            goodsInfoIntro.setText(goodsInfo);
        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
