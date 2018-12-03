package com.example.com.morecharge.release.main.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.example.com.common.BaseFragment;
import com.example.com.morecharge.R;
import com.example.com.morecharge.release.main.ui.activity.BuySubBillingRuleActivity;
import com.example.com.morecharge.view.GoodPropertyDiaolog;
import com.example.com.morecharge.view.SelectInsuranceDialog;
import com.example.com.morecharge.view.SelectPickTimeDialog;

import butterknife.BindView;
import butterknife.OnClick;

public class DownWindFragment extends BaseFragment implements LocationSource, AMapLocationListener {

    @BindView(R.id.a_map)
    MapView mMapView;
    private AMap aMap;
    private OnLocationChangedListener mListener;
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;

    @BindView(R.id.rb_buy_on_sub)
    RadioButton mRbSubBuy;
    @BindView(R.id.rb_take_delivery)
    RadioButton mRbDelivery;
    @BindView(R.id.cos_sub_buy_root)
    ConstraintLayout mCosSubBuy;
    @BindView(R.id.cos_pick_root)
    ConstraintLayout mCosPick;
    @BindView(R.id.tv_appoint_address)
    TextView mTvAppointAddress;
    @BindView(R.id.tv_near_buy)
    TextView mTvNearBuy;


    private static final String TAG = "DownWindFragment";


    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_down_wind;
    }

    @Override
    public void setView(View rootView) {
        SpannableString spannableString1 = new SpannableString("指定地址 更精确");
        spannableString1.setSpan(new ForegroundColorSpan(Color.parseColor("#FD8B06")), 4, spannableString1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvAppointAddress.setText(spannableString1);

        SpannableString spannableString2 = new SpannableString("就近购买 3公里内");
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 4, spannableString2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvAppointAddress.setText(spannableString2);
    }

    @Override
    public void initData(Bundle arguments) {
        initMap(arguments);
    }


    @Override
    public void onLazyLoad() {

    }

    @Override
    public void unVisible() {

    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }


    @OnClick({R.id.rb_buy_on_sub, R.id.rb_take_delivery, R.id.tv_cost, R.id.tv_recommend_cost, R.id.tv_good_insurance, R.id.tv_good_insurance_2, R.id.tv_pick_time, R.id.tv_immediately_pick
    ,R.id.tv_good_property,R.id.tv_good_property_weightt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_buy_on_sub:
                mRbDelivery.setChecked(false);
                mCosSubBuy.setVisibility(View.VISIBLE);
                mCosPick.setVisibility(View.GONE);
                break;
            case R.id.rb_take_delivery:
                mRbSubBuy.setChecked(false);
                mCosSubBuy.setVisibility(View.GONE);
                mCosPick.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_recommend_cost:
            case R.id.tv_cost:
                startActivity(BuySubBillingRuleActivity.class);
                break;
            case R.id.tv_good_insurance_2:
            case R.id.tv_good_insurance:
                showInsuranceDialog();
                break;
            case R.id.tv_pick_time:
            case R.id.tv_immediately_pick:
                showSelectTimeDialog();
                break;
            case R.id.tv_good_property_weightt:
            case R.id.tv_good_property:
                showGoodPropertyDialog();
                break;
        }
    }

    private void showGoodPropertyDialog() {
        final GoodPropertyDiaolog.Builder builder = new GoodPropertyDiaolog.Builder(getContext());
        GoodPropertyDiaolog dialog = builder.setNavigationButton(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.dismiss();
            }
        }).setPositionButton(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.dismiss();
            }
        }).createDialog();

        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setWindowAnimations(R.style.dialog_animation);
        dialog.show();
    }

    private void showSelectTimeDialog() {
        final SelectPickTimeDialog.Builder builder = new SelectPickTimeDialog.Builder(getContext());
        SelectPickTimeDialog dialog = builder.setNavigationButton(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.dismiss();
            }
        }).setPositionButton(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.dismiss();
            }
        }).createDialog();

        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setWindowAnimations(R.style.dialog_animation);
        dialog.show();
    }

    private void showInsuranceDialog() {
        final SelectInsuranceDialog.Builder builder = new SelectInsuranceDialog.Builder(getContext());
        SelectInsuranceDialog dialog = builder.setNavigationButton(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.dismiss();
            }
        }).setPositionButton(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.dismiss();
            }
        }).createDialog();

        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setWindowAnimations(R.style.dialog_animation);
        dialog.show();
    }


    //    定位监听----------------
    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
        if (mlocationClient == null) {
            mlocationClient = new AMapLocationClient(getContext());
            mLocationOption = new AMapLocationClientOption();
            mlocationClient.setLocationListener(this);
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            mlocationClient.setLocationOption(mLocationOption);
            mlocationClient.startLocation();
        }
    }

    @Override
    public void deactivate() {
        mListener = null;
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
            mlocationClient.onDestroy();
        }
        mlocationClient = null;
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (mListener != null && aMapLocation != null) {
            if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
                mListener.onLocationChanged(aMapLocation);// 显示系统小蓝点
            } else {
                String errText = "定位失败," + aMapLocation.getErrorCode() + ": " + aMapLocation.getErrorInfo();
                Log.e(TAG, errText);
            }
        }
    }

    /**
     * 初始化 地图 定位
     *
     * @param arguments
     */
    private void initMap(Bundle arguments) {
        mMapView.onCreate(arguments);
        if (aMap == null) {
            aMap = mMapView.getMap();
        }
        // 自定义系统定位小蓝点
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.strokeColor(Color.BLACK);// 设置圆形的边框颜色
        myLocationStyle.radiusFillColor(Color.argb(100, 0, 0, 180));// 设置圆形的填充颜色
        myLocationStyle.strokeWidth(1.0f);// 设置圆形的边框粗细
        aMap.setMyLocationStyle(myLocationStyle);
        aMap.setLocationSource(this);// 设置定位监听
        aMap.getUiSettings().setMyLocationButtonEnabled(true);// 设置默认定位按钮是否显示
        aMap.setMyLocationEnabled(true);// 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
    }
}
