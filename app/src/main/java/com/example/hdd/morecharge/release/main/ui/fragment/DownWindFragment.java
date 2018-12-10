package com.example.hdd.morecharge.release.main.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.services.core.PoiItem;
import com.example.com.morecharge.release.request.OrderWayBuyRequest;
import com.example.com.morecharge.release.request.OrderWayExpressRequest;
import com.example.com.morecharge.release.response.OrderWayBuyResponse;
import com.example.com.morecharge.release.response.OrderWayExpressResponse;
import com.example.hdd.common.BaseFragment;
import com.example.hdd.common.util.SP;
import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.config.C;
import com.example.hdd.morecharge.release.main.ui.activity.BuySubBillingRuleActivity;
import com.example.hdd.morecharge.release.main.ui.activity.ChooseAddressActivity;
import com.example.hdd.morecharge.remote.Injection;
import com.example.hdd.morecharge.view.GoodPropertyDiaolog;
import com.example.hdd.morecharge.view.SelectInsuranceDialog;
import com.example.hdd.morecharge.view.SelectPickTimeDialog;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DownWindFragment extends BaseFragment implements LocationSource, AMapLocationListener {

    @BindView(R.id.a_map)
    MapView mMapView;
    private AMap aMap;
    private OnLocationChangedListener mListener;
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;
    private String accessToken = "";

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
    @BindView(R.id.tv_recommend_cost)
    EditText mEtRecommendCost;
    @BindView(R.id.et_want_buy)
    EditText mEtWantBuy;
    @BindView(R.id.tv_immediately_distribution)
    TextView mTvReceiveTime;
    @BindView(R.id.tv_immediately_pick)
    TextView mTvGetGoodsTime;
    @BindView(R.id.et_buy_address)
    EditText mEtBuyReceiveAddress;
    @BindView(R.id.tv_where_buy)
    EditText mEtBuyAddress;
    @BindView(R.id.et_pick_address)
    EditText mEtPickAddress;
    @BindView(R.id.et_take_address)
    EditText mEtPickReceiveAddress;
    @BindView(R.id.et_recommend_cost)
    EditText mEtExpressCost;
    @BindView(R.id.et_remark)
    EditText mEtExpressMark;

    private  PoiItem buyPosition;
    private  PoiItem buyReceivePosition;

    private  PoiItem expressPosition;
    private  PoiItem expressReceivePosition;


    private static final String TAG = "DownWindFragment";

    private static final int REQUEST_CODE_CHOOSE_ADDRESS_EXPRESS = 0x1010;
    private static final int REQUEST_CODE_CHOOSE_ADDRESS_EXPRESS_RECEIVE = 0x1040;
    private static final int REQUEST_CODE_CHOOSE_ADDRESS_BUY = 0x1020;
    private static final int REQUEST_CODE_CHOOSE_ADDRESS_BUY_RECEIVE = 0x1030;


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
        mTvNearBuy.setText(spannableString2);
    }

    @Override
    public void initData(Bundle arguments) {
        initMap(arguments);
        accessToken = SP.getInstance(C.USER_DB, getContext()).getString(C.USER_ACCESS_TOKEN, "");
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
            , R.id.tv_good_property, R.id.tv_good_property_weightt, R.id.tv_recommend_order, R.id.tv_pick_recommend_order, R.id.tv_immediately_distribution, R.id.tv_receive_address,R.id.tv_buy
    ,R.id.tv_pick_address,R.id.tv_take_address})
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
//            case R.id.tv_recommend_cost:
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
            case R.id.tv_recommend_order:
                orderWayBuy();
                break;
            case R.id.tv_pick_recommend_order:
                orderWayExpress();
                break;
            case R.id.tv_immediately_distribution:
                showSelectTimeDialog();
                break;
            case R.id.tv_receive_address:
                startActivityForResult( new Intent(getContext(), ChooseAddressActivity.class), REQUEST_CODE_CHOOSE_ADDRESS_BUY_RECEIVE);
                break;
            case R.id.tv_buy:
                startActivityForResult(new Intent(getContext(), ChooseAddressActivity.class), REQUEST_CODE_CHOOSE_ADDRESS_BUY);
                break;
            case R.id.tv_pick_address:
                startActivityForResult(new Intent(getContext(), ChooseAddressActivity.class), REQUEST_CODE_CHOOSE_ADDRESS_EXPRESS);
                break;
            case R.id.tv_take_address:
                startActivityForResult(new Intent(getContext(), ChooseAddressActivity.class), REQUEST_CODE_CHOOSE_ADDRESS_EXPRESS_RECEIVE);
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
                if (mRbSubBuy.isChecked()) {
                    mTvReceiveTime.setText(builder.getSelectTime());
                } else {
                    mTvGetGoodsTime.setText(builder.getSelectTime());
                }
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


    /**
     * 取送件
     */
    @SuppressLint("CheckResult")
    private void orderWayExpress() {
        if (expressReceivePosition==null || expressPosition ==null){
            ToastUtils.showShort(getContext(),"请完善地址信息");
            return;
        }
        OrderWayExpressRequest orderWayExpressRequest = new OrderWayExpressRequest();
        orderWayExpressRequest.setFromProvince(expressPosition.getProvinceName());
        orderWayExpressRequest.setFromCity(expressPosition.getCityName());
        orderWayExpressRequest.setFromArea(expressPosition.getAdName());
        orderWayExpressRequest.setFromAddress(mEtBuyAddress.getText().toString());
        orderWayExpressRequest.setFromHouse(mEtBuyAddress.getText().toString());
        orderWayExpressRequest.setFromLongitude(expressPosition.getLatLonPoint().getLongitude() + "");
        orderWayExpressRequest.setFromLatitude(expressPosition.getLatLonPoint().getLatitude() + "");
        orderWayExpressRequest.setFromLinkman("取件联系人");
        orderWayExpressRequest.setFromSex("取件人性别");
        orderWayExpressRequest.setFromPhone("取件人电话");
        orderWayExpressRequest.setToProvince(expressReceivePosition.getProvinceName());
        orderWayExpressRequest.setToCity(expressReceivePosition.getCityName());
        orderWayExpressRequest.setToArea(expressReceivePosition.getAdName());
        orderWayExpressRequest.setToAddress(mEtBuyReceiveAddress.getText().toString());
        orderWayExpressRequest.setToHouse(mEtBuyReceiveAddress.getText().toString());
        orderWayExpressRequest.setToLongitude(expressReceivePosition.getLatLonPoint().getLongitude()+"");
        orderWayExpressRequest.setToLatitude(expressReceivePosition.getLatLonPoint().getLatitude()+"");
        orderWayExpressRequest.setToLinkman("收件件联系人");
        orderWayExpressRequest.setToSex("收件人性别");
        orderWayExpressRequest.setToPhone("收件人电话");
        orderWayExpressRequest.setGetGoodsTime(mTvGetGoodsTime.getText().toString());
        orderWayExpressRequest.setSalary(mEtExpressCost.getText().toString());
        orderWayExpressRequest.setGoodsType("物品类型");
        orderWayExpressRequest.setGoodsWeight("15");
        orderWayExpressRequest.setInsuranceType("保险类型");
        orderWayExpressRequest.setDescribeText(mEtExpressMark.getText().toString());
        Injection.provideApiService().orderWayExpress("Bearer " + accessToken, orderWayExpressRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<OrderWayExpressResponse>() {
                    @Override
                    public void accept(OrderWayExpressResponse response) throws Exception {
                        ToastUtils.showShort(getContext(), response.getMsg());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showShort(getContext(), throwable.getMessage());
                    }
                });
    }

    /**
     * 代购发单
     */
    @SuppressLint("CheckResult")
    private void orderWayBuy() {
        if (buyPosition==null || buyReceivePosition==null) {
            ToastUtils.showShort(getContext(),"请完善地址");
            return;
        }
        final OrderWayBuyRequest request = new OrderWayBuyRequest();
        request.setLongitude(buyReceivePosition.getLatLonPoint().getLongitude()+"");
        request.setLatitude(buyReceivePosition.getLatLonPoint().getLatitude()+"");
        request.setProvince(buyReceivePosition.getProvinceName());
        request.setCity(buyReceivePosition.getCityName());
        request.setArea(buyReceivePosition.getAdName());
        request.setAddress(buyReceivePosition.getTitle());
        request.setHouse(mEtBuyReceiveAddress.getText().toString().replace(request.getProvince(),"").replace(request.getCity(),"").replace(request.getArea(),""));
        request.setSex("B");
        request.setLinkman("李四");
        request.setPhone("17688889999");
        request.setReceivingTime(mTvReceiveTime.getText().toString());
        request.setGoodsName(mEtWantBuy.getText().toString());
        request.setBuyType("APOINT,ARBITRARY");
        request.setBuyAddress(mEtBuyAddress.getText().toString());
        request.setSalary(mEtRecommendCost.getText().toString());
        request.setDescribeText(mEtRecommendCost.getText().toString());
        Injection.provideApiService().orderWayBuy("Bearer " + accessToken, request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<OrderWayBuyResponse>() {
                    @Override
                    public void accept(OrderWayBuyResponse response) throws Exception {
                        ToastUtils.showShort(getContext(), "发单成功");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showShort(getContext(), throwable.getMessage());
                    }
                });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode== Activity.RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_CHOOSE_ADDRESS_EXPRESS:
                    expressPosition=(PoiItem) data.getParcelableExtra(C.CHOOSE_ADDRESS);
                    mEtPickAddress.setText(expressPosition.getProvinceName() + expressPosition.getCityName() + expressPosition.getAdName() + expressPosition.getBusinessArea() + expressPosition.getTitle());
                    break;
                case REQUEST_CODE_CHOOSE_ADDRESS_EXPRESS_RECEIVE:
                    expressReceivePosition=(PoiItem) data.getParcelableExtra(C.CHOOSE_ADDRESS);
                    mEtPickReceiveAddress.setText(expressReceivePosition.getProvinceName() + expressReceivePosition.getCityName() + expressReceivePosition.getAdName() + expressReceivePosition.getBusinessArea() + expressReceivePosition.getTitle());
                    break;
                case REQUEST_CODE_CHOOSE_ADDRESS_BUY_RECEIVE:
                    buyReceivePosition=(PoiItem) data.getParcelableExtra(C.CHOOSE_ADDRESS);
                    mEtBuyReceiveAddress.setText(buyReceivePosition.getProvinceName() + buyReceivePosition.getCityName() + buyReceivePosition.getAdName() + buyReceivePosition.getBusinessArea() + buyReceivePosition.getTitle());
                    break;
                case REQUEST_CODE_CHOOSE_ADDRESS_BUY:
                    buyPosition=(PoiItem) data.getParcelableExtra(C.CHOOSE_ADDRESS);
                    mEtBuyAddress.setText(buyPosition.getProvinceName() + buyPosition.getCityName() + buyPosition.getAdName() + buyPosition.getBusinessArea() + buyPosition.getTitle());
                    break;
            }
        }
    }
}
