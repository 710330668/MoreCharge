package com.example.hdd.morecharge.release.main.ui.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.hdd.common.BaseFragment;
import com.example.com.morecharge.release.request.OrderTimeJobRequest;
import com.example.com.morecharge.release.response.OrderTimeJobResponse;
import com.example.hdd.common.util.SP;
import com.example.hdd.common.util.TimeUtils;
import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.common.BaseFragment  ;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.config.C;
import com.example.hdd.morecharge.remote.Injection;
import com.example.hdd.morecharge.view.SelectKeepDateDialog;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PartTimeJobFragment extends BaseFragment {

    @BindView(R.id.rb_perfomace)
    RadioButton mRbPerfomace;
    @BindView(R.id.rb_waiter)
    RadioButton mRbWaiter;
    @BindView(R.id.rb_lealfet)
    RadioButton mRbLealfet;
    @BindView(R.id.tv_start_date)
    TextView mTvStartDate;
    @BindView(R.id.tv_end_date)
    TextView mTvEndDate;
    @BindView(R.id.tv_total_days)
    TextView mTvTotals;
    private Calendar mStartCalendar, mEndCalendar;

    private String accessToken = "";
    private static final String TAG = "PartTimeJobFragment";

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_parttime_job;
    }

    @Override
    public void setView(View rootView) {

    }

    @Override
    public void initData(Bundle arguments) {
        accessToken = SP.getInstance(C.USER_DB, getContext()).getString(C.USER_ACCESS_TOKEN, "");
    }

    @Override
    public void onLazyLoad() {

    }

    @Override
    public void unVisible() {

    }

    @OnClick({R.id.rb_lealfet, R.id.rb_waiter, R.id.rb_perfomace, R.id.tv_person_order, R.id.rect_start_date, R.id.rect_end_date})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_lealfet:
                mRbPerfomace.setChecked(false);
                mRbWaiter.setChecked(false);
                break;
            case R.id.rb_waiter:
                mRbPerfomace.setChecked(false);
                mRbLealfet.setChecked(false);
                break;
            case R.id.rb_perfomace:
                mRbLealfet.setChecked(false);
                mRbWaiter.setChecked(false);
                break;
            case R.id.tv_person_order:
                orderTimeJob();
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
    private void orderTimeJob() {
        OrderTimeJobRequest request = new OrderTimeJobRequest();
        request.setProvince("省");
        request.setOrderType("TIME_JOB_SHOW");
        request.setCity("市");
        request.setArea("区");
        request.setAddress("街道地址");
        request.setHouse("房间号");
        request.setLongitude("经度");
        request.setLatitude("纬度");
        request.setLinkman("联系人");
        request.setSex("性别");
        request.setPhone("手机号");
        request.setWorkBegin("2018-10-11");
        request.setWorkEnd("2018-10-11");
        request.setOneDayBegin("14:18:24");
        request.setOneDayEnd("14:18:41");
        request.setSalary("122");
        request.setDescribeText("文字描述");
        Injection.provideApiService().orderTimeJob("Bearer " + accessToken, request).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<OrderTimeJobResponse>() {
                    @Override
                    public void accept(OrderTimeJobResponse s) throws Exception {
                        ToastUtils.showShort(getContext(), s.getMsg());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showShort(getContext(), throwable.getMessage());
                    }
                });
    }

    private void showSelectDateDialog(final int id) {
        final SelectKeepDateDialog.Builder builder = new SelectKeepDateDialog.Builder(getContext());
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
        if (mStartCalendar != null && mEndCalendar != null) {
            int i = TimeUtils.differentDays(mStartCalendar, mEndCalendar);
            if (i > 0) {
                String source = "共 " + i + " 天";
                SpannableString spannableString = new SpannableString(source);
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 0, 1, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), source.length() - 1, source.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                mTvTotals.setText(spannableString);
            } else {
                mTvTotals.setText("");
            }

        }
    }
}
