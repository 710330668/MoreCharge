package com.example.hdd.morecharge.release.main.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.example.com.morecharge.release.request.OrderBuildProjectRequest;
import com.example.com.morecharge.release.response.OrderBuildProjectResponse;
import com.example.hdd.common.BaseActivity;
import com.example.hdd.common.adapter.BaseAdapter;
import com.example.hdd.common.adapter.ItemData;
import com.example.hdd.common.adapter.onItemClickListener;
import com.example.hdd.common.util.SP;
import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.config.C;
import com.example.hdd.morecharge.remote.Injection;
import com.example.hdd.morecharge.remote.SettingDelegate;
import com.example.hdd.morecharge.view.SelectKeepDateDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.example.hdd.morecharge.MyApplication.getContext;


public class ContractProjectActivity extends BaseActivity {
    private String accessToken = "";


    @BindView(R.id.rcl_type_of_work)
    RecyclerView mRclTypeWork;
    @BindView(R.id.tv_start_date)
    TextView mTvStartDate;
    private List<ItemData> typeList = new ArrayList();

    @Override
    public int bindLayout() {
        return R.layout.activity_contract_work;
    }

    @Override
    public void initParams(Bundle params) {
        accessToken = SP.getInstance(C.USER_DB, this).getString(C.USER_ACCESS_TOKEN, "");
    }

    @Override
    public void setView(Bundle savedInstanceState) {
        initRecycler();
    }

    private void initRecycler() {
        typeList.add(new ItemData(0, SettingDelegate.CONTRACT_PERSON_TYPE, "水"));
        typeList.add(new ItemData(0, SettingDelegate.CONTRACT_PERSON_TYPE, "电"));
        typeList.add(new ItemData(0, SettingDelegate.CONTRACT_PERSON_TYPE, "暖"));
        typeList.add(new ItemData(0, SettingDelegate.CONTRACT_PERSON_TYPE, "土建"));
        typeList.add(new ItemData(0, SettingDelegate.CONTRACT_PERSON_TYPE, "装修"));
        typeList.add(new ItemData(0, SettingDelegate.CONTRACT_PERSON_TYPE, "清理现场"));
        mRclTypeWork.setLayoutManager(new GridLayoutManager(this, 4));
        mRclTypeWork.setAdapter(new BaseAdapter(typeList, new SettingDelegate(), new onItemClickListener() {
            @Override
            public void onClick(View v, Object data) {

            }

            @Override
            public boolean onLongClick(View v, Object data) {
                return false;
            }
        }));
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @OnClick({R.id.tv_order_build_work, R.id.rect_start_date})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_order_build_work:
                buildWorkOrder();
                break;
            case R.id.rect_start_date:
                showSelectDateDialog();
                break;
        }
    }

    @SuppressLint("CheckResult")
    private void buildWorkOrder() {
        OrderBuildProjectRequest request = new OrderBuildProjectRequest();
        request.setProvince("省");
        request.setCity("市");
        request.setArea("区");
        request.setAddress("街道地址");
        request.setHouse("房间号");
        request.setLongitude("经度");
        request.setLatitude("纬度");
        request.setLinkman("联系人");
        request.setSex("B");
        request.setPhone("手机号");
        request.setOrderType("");
        request.setMaterialType("Y");
        request.setNumberOfPeople("5");
        request.setWorkEnd("2018-10-11");
        request.setSalary("122");
        request.setDescribeText("文字描述");
        Injection.provideApiService().orderBuildProject("Bearer " + accessToken, request).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<OrderBuildProjectResponse>() {
                    @Override
                    public void accept(OrderBuildProjectResponse s) throws Exception {
                        ToastUtils.showShort(ContractProjectActivity.this, s.getMsg());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showShort(getContext(), throwable.getMessage());
                    }
                });
    }

    private void showSelectDateDialog() {
        final SelectKeepDateDialog.Builder builder = new SelectKeepDateDialog.Builder(this);
        SelectKeepDateDialog dialog = builder.setNavigationButton(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.dismiss();
            }
        }).setPositionButton(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvStartDate.setText(builder.getDate());
                builder.dismiss();
            }
        }).createDialog();
        builder.setTitle("结束日期");

        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setWindowAnimations(R.style.dialog_animation);
        dialog.show();
    }
}
