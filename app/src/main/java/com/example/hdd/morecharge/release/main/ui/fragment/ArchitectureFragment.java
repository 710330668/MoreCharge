package com.example.hdd.morecharge.release.main.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.services.core.PoiItem;
import com.example.hdd.common.BaseFragment;
import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.config.C;
import com.example.hdd.morecharge.release.main.ui.activity.ChooseAddressActivity;
import com.example.hdd.morecharge.release.main.ui.activity.ContractPersonActivity;
import com.example.hdd.morecharge.release.main.ui.activity.ContractProjectActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ArchitectureFragment extends BaseFragment implements AMapLocationListener, LocationSource {

    private static final int REQUEST_CODE_PERSON = 0x1010;
    private static final int REQUEST_CODE_PROJECT = 0x1020;
    @BindView(R.id.a_map)
    MapView mMapView;
    private AMap aMap;
    private LocationSource.OnLocationChangedListener mListener;
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;

    @BindView(R.id.rb_pack_person)
    RadioButton mRbPakcPerson;
    @BindView(R.id.rb_pack_work)
    RadioButton mRbPackWork;
    @BindView(R.id.cos_pack_person_root)
    ConstraintLayout mCosPackPerson;
    @BindView(R.id.cos_pack_work_root)
    ConstraintLayout mCosPackWork;
    @BindView(R.id.et_person_choose_address)
    EditText mEtPersonChooseAddress;
    @BindView(R.id.et_project_choose_address)
    EditText mEtProjectChooseAddress;
    private PoiItem personPosition;
    private PoiItem projectPosition;

    private static final String TAG = "ArchitectureFragment";

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_architecture;
    }

    @Override
    public void setView(View rootView) {

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

    @OnClick({R.id.rb_pack_person, R.id.rb_pack_work, R.id.tv_type_of_work_edit, R.id.iv_type_of_work_arrow, R.id.tv_work_order, R.id.tv_person_order
            , R.id.et_person_choose_address, R.id.tv_type_of_project_edit, R.id.iv_type_of_project_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_pack_person:
                mRbPackWork.setChecked(false);
                mCosPackPerson.setVisibility(View.VISIBLE);
                mCosPackWork.setVisibility(View.GONE);
                break;
            case R.id.rb_pack_work:
                mRbPakcPerson.setChecked(false);
                mCosPackPerson.setVisibility(View.GONE);
                mCosPackWork.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_person_order:
            case R.id.tv_type_of_work_edit:
            case R.id.iv_type_of_work_arrow:
                if (personPosition == null) {
                    ToastUtils.showShort(getContext(), "请完善位置信息");
                    return;
                }
                startActivity(ContractPersonActivity.class);
                break;
            case R.id.tv_work_order:
            case R.id.tv_type_of_project_edit:
            case R.id.iv_type_of_project_edit:
                if (projectPosition == null) {
                    ToastUtils.showShort(getContext(), "请完善位置信息");
                    return;
                }
                startActivity(ContractProjectActivity.class);
                break;
            case R.id.et_person_choose_address:
                startActivityForResult(new Intent(getContext(), ChooseAddressActivity.class), REQUEST_CODE_PERSON);
                break;
        }
    }


    //    定位监听----------------
    @Override
    public void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_PERSON:
                    personPosition = (PoiItem) data.getParcelableExtra(C.CHOOSE_ADDRESS);
                    mEtPersonChooseAddress.setText(personPosition.getProvinceName() + personPosition.getCityName() + personPosition.getAdName() + personPosition.getBusinessArea() + personPosition.getTitle());
                    break;
                case REQUEST_CODE_PROJECT:
                    projectPosition = (PoiItem) data.getParcelableExtra(C.CHOOSE_ADDRESS);
                    mEtProjectChooseAddress.setText(projectPosition.getProvinceName() + projectPosition.getCityName() + projectPosition.getAdName() + projectPosition.getBusinessArea() + projectPosition.getTitle());
                    break;
            }
        }
    }

}
