package com.example.hdd.morecharge.receive.main;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hdd.common.BaseActivity;
import com.example.hdd.common.util.LogUtils;
import com.example.hdd.common.util.SP;
import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.config.C;
import com.example.hdd.morecharge.receive.request.ReceiveOrderDetailRequest;
import com.example.hdd.morecharge.receive.response.ReceiveOrderDetailResponse;
import com.example.hdd.morecharge.receive.response.ReceiveOrdersResponse;
import com.example.hdd.morecharge.remote.Injection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 71033 on 2018/11/30.
 */
public class ReceiveOrderDetailActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_time_limit)
    TextView tvTimeLimit;
    @BindView(R.id.tv_salary)
    TextView tvSalary;
    @BindView(R.id.tv_des)
    TextView tvDes;
    @BindView(R.id.rl_video_img)
    RecyclerView rlVideoImg;
    @BindView(R.id.rl_send_msg)
    RelativeLayout rlSendMsg;
    @BindView(R.id.rl_phone)
    RelativeLayout rlPhone;
    @BindView(R.id.cardview)
    CardView cardview;
    private ReceiveOrdersResponse.DataBean bean;

    private String accessToken = "";

    private String phoneNum;

    @Override
    public int bindLayout() {
        return R.layout.activity_receive_detail;
    }

    @Override
    public void initParams(Bundle params) {
        bean = (ReceiveOrdersResponse.DataBean) getIntent().getSerializableExtra("order");
        accessToken = SP.getInstance(C.USER_DB, this).getString(C.USER_ACCESS_TOKEN, "");
    }

    @Override
    public void setView(Bundle savedInstanceState) {

    }

    @Override
    public void doBusiness(Context mContext) {
        getOrderDetail();
    }

    @SuppressLint("CheckResult")
    private void getOrderDetail() {
        ReceiveOrderDetailRequest request = new ReceiveOrderDetailRequest();
        request.setOrderId(bean.getOrderId());
        request.setOrderType(bean.getOrderType());
        Injection.provideApiService().getReceiveOrderDetail("Bearer" + accessToken, request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ReceiveOrderDetailResponse>() {
                    @Override
                    public void accept(ReceiveOrderDetailResponse response) throws Exception {
                        if (response.isSuccess()) {
                            LogUtils.e("成功" + response.getData().toString());
                            tvTitle.setText(response.getData().getOrderInfo().getOrderTypeName());
//                            tvLocation.setText(response.getData().getOrderInfo().getCity());
                            tvTime.setText(response.getData().getOrderInfo().getCreateTime());
                            tvSalary.setText(response.getData().getOrderInfo().getSalary()+"元");
                            tvDes.setText(response.getData().getOrderInfo().getDescribeText());
                            phoneNum = response.getData().getOrderInfo().getPhone();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogUtils.e("失败" + throwable.getMessage());
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rl_send_msg, R.id.rl_phone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_send_msg:
                break;
            case R.id.rl_phone:
                //拨打电话
                call();
                break;
        }
    }

    private void call() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ToastUtils.showShort(this, "请先打开电话权限");
            return;
        }
        startActivity(intent);
    }
}
