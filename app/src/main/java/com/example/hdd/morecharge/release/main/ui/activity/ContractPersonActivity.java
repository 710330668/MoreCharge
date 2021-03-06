package com.example.hdd.morecharge.release.main.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.example.com.morecharge.release.request.OrderBuildPersonRequest;
import com.example.com.morecharge.release.response.OrderBuildPersonResponse;
import com.example.hdd.common.BaseActivity;
import com.example.hdd.common.adapter.BaseAdapter;
import com.example.hdd.common.adapter.ItemData;
import com.example.hdd.common.adapter.onItemClickListener;
import com.example.hdd.common.util.SP;
import com.example.hdd.common.util.TimeUtils;
import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.config.C;
import com.example.hdd.morecharge.remote.Injection;
import com.example.hdd.morecharge.remote.SettingDelegate;
import com.example.hdd.morecharge.view.SelectKeepDateDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.example.hdd.morecharge.MyApplication.getContext;


public class ContractPersonActivity extends BaseActivity {

    private String accessToken = "";
    private static final String TAG = "ContractPersonActivity";

    @BindView(R.id.rcl_type_of_work)
    RecyclerView mRclTypeWork;
    @BindView(R.id.tv_start_date)
    TextView mTvStartDate;
    @BindView(R.id.tv_end_date)
    TextView mTvEndDate;
    @BindView(R.id.tv_total_days)
    TextView mTvTotals;
    private Calendar mStartCalendar,mEndCalendar;
    private List<ItemData> typeList = new ArrayList<>();

    @Override
    public int bindLayout() {
        return R.layout.activity_contract_person;
    }

    @Override
    public void initParams(Bundle params) {
        accessToken = SP.getInstance(C.USER_DB, this).getString(C.USER_ACCESS_TOKEN, "");
    }

    @Override
    public void setView(Bundle savedInstanceState) {
        initRecycler();
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    private void initRecycler() {
        typeList.add(new ItemData(0, SettingDelegate.CONTRACT_PERSON_TYPE, "木工"));
        typeList.add(new ItemData(0, SettingDelegate.CONTRACT_PERSON_TYPE, "瓦工"));
        typeList.add(new ItemData(0, SettingDelegate.CONTRACT_PERSON_TYPE, "水工"));
        typeList.add(new ItemData(0, SettingDelegate.CONTRACT_PERSON_TYPE, "搬运工"));
        typeList.add(new ItemData(0, SettingDelegate.CONTRACT_PERSON_TYPE, "清理工"));
        typeList.add(new ItemData(0, SettingDelegate.CONTRACT_PERSON_TYPE, "电工"));
        typeList.add(new ItemData(0, SettingDelegate.CONTRACT_PERSON_TYPE, "小工"));
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

    @OnClick({R.id.tv_build_person_order,R.id.rect_start_date,R.id.rect_end_date})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_build_person_order:
                buildPersonOrder();
                break;
            case R.id.rect_start_date:
                showSelectDateDialog(R.id.rect_start_date);
                break;
            case R.id.rect_end_date:
                showSelectDateDialog(R.id.rect_end_date);
                break;
        }
    }

    @SuppressLint("CheckResult")
    private void buildPersonOrder() {
        OrderBuildPersonRequest request = new OrderBuildPersonRequest();
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
        request.setOrderType("BUILD_PERSON_MU");
        request.setSkillGrade("J");
        request.setNumberOfPeople("5");
        request.setWorkBegin("2018-10-11");
        request.setWorkEnd("2018-10-11");
        request.setOneDayBegin("14:18:24");
        request.setOneDayEnd("14:18:24");
        request.setSalary("122");
        request.setDescribeText("文字描述");
        Injection.provideApiService().orderBuildPerson("Bearer " + accessToken, request).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<OrderBuildPersonResponse>() {
                    @Override
                    public void accept(OrderBuildPersonResponse s) throws Exception {
                        ToastUtils.showShort(ContractPersonActivity.this,s.getMsg());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showShort(getContext(), throwable.getMessage());
                    }
                });
    }

    private void showSelectDateDialog(final int id) {
        final SelectKeepDateDialog.Builder builder = new SelectKeepDateDialog.Builder(this);
        SelectKeepDateDialog dialog = builder.setNavigationButton(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.dismiss();
            }
        }).setPositionButton(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (id) {
                    case R.id.rect_start_date:
                        mTvStartDate.setText(builder.getDate());
                        mStartCalendar = builder.getCalendar();
                        calculateDiffDays();
                        break;
                    case R.id.rect_end_date:
                        mTvEndDate.setText(builder.getDate());
                        mEndCalendar = builder.getCalendar();
                        calculateDiffDays();
                        break;
                }
                builder.dismiss();
            }
        }).createDialog();

        switch (id) {
            case R.id.rect_start_date:
                builder.setTitle("开始日期");
                break;
            case R.id.rect_end_date:
                builder.setTitle("结束日期");
                break;
        }

        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setWindowAnimations(R.style.dialog_animation);
        dialog.show();
    }

    private void calculateDiffDays() {
        if (mStartCalendar!=null && mEndCalendar!=null) {
            int i = TimeUtils.differentDays(mStartCalendar, mEndCalendar);
            if (i>0) {
                String source = "共 " + i + " 天";
                SpannableString spannableString = new SpannableString(source);
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")),0,1, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")),source.length()-1,source.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                mTvTotals.setText(spannableString);
            }else {
                mTvTotals.setText("");
            }

        }
    }
}
