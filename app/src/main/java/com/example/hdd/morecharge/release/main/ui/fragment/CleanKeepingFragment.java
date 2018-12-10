package com.example.hdd.morecharge.release.main.ui.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
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

import com.example.com.morecharge.release.request.OrderCleanupRequest;
import com.example.hdd.common.BaseFragment;
import com.example.hdd.common.util.SP;
import com.example.hdd.common.util.TimeUtils;
import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.config.C;
import com.example.hdd.morecharge.remote.Injection;
import com.example.hdd.morecharge.view.SelectKeepDateDialog;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CleanKeepingFragment extends BaseFragment {


    @BindView(R.id.rb_pack_person)
    RadioButton mRbPakcPerson;
    @BindView(R.id.rb_pack_work)
    RadioButton mRbPackWork;
    @BindView(R.id.et_work_position)
    EditText mEtWorkPosition;
    @BindView(R.id.tv_start_date)
    TextView mTvStartDate;
    @BindView(R.id.tv_end_date)
    TextView mTvEndDate;
    @BindView(R.id.tv_total_days)
    TextView mTvTotalDays;
    @BindView(R.id.tv_start_hour)
    TextView mTvStartHour;
    @BindView(R.id.tv_end_hour)
    TextView mTvEndHour;
    @BindView(R.id.tv_total_hours)
    TextView mTvTotalHours;
    @BindView(R.id.et_day_salary)
    EditText mEtDaySalary;
    @BindView(R.id.et_work_description)
    EditText mEtDescription;
    @BindView(R.id.tv_person_order)
    TextView mTvOrder;
    private Calendar mStartCalendar,mEndCalendar;

    private static final String TAG = "CleanKeepingFragment";
    private String accessToken = "";

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_clean_keeping;
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

    @OnClick({R.id.rb_pack_person, R.id.rb_pack_work, R.id.rect_start_date, R.id.rect_end_date, R.id.tv_person_order})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_pack_person:
                mRbPackWork.setChecked(false);
                break;
            case R.id.rb_pack_work:
                mRbPakcPerson.setChecked(false);
                break;
            case R.id.rect_start_date:
                showSelectDateDialog(R.id.rect_start_date);
                break;
            case R.id.rect_end_date:
                showSelectDateDialog(R.id.rect_end_date);
                break;
            case R.id.tv_person_order:
                orderCleanupAdd();
                break;
        }
    }

    @SuppressLint("CheckResult")
    private void orderCleanupAdd() {
        OrderCleanupRequest request = new OrderCleanupRequest();
        request.setProvince("省");
        request.setCity("市");
        request.setArea("区");
        request.setAddress("街道地址");
        request.setHouse("房间号");
        request.setLongitude("经度");
        request.setLatitude("纬度");
        request.setLinkman("联系人");
        request.setSex("性别");
        request.setPhone("手机号");
        request.setOrderType("CLEANUP_APPARATUS");
        request.setNumberOfPeople("人数");
        request.setWorkEnd("2018-10-11");
        request.setSalary("122");
        request.setDescribeText("文字描述");
        Injection.provideApiService().orderCleanup("Bearer " + accessToken, request).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e(TAG, "accept: " + s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showShort(getContext(),throwable.getMessage());
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

    @OnCheckedChanged({R.id.rb_pack_person, R.id.rb_pack_work})
    public void onCheckedChange(RadioButton view) {
        clearOrderMessage();
    }


    public void clearOrderMessage() {
        mEtWorkPosition.setText("");
        mTvStartDate.setText("");
        mTvEndDate.setText("");
        mTvTotalDays.setText("");
        mTvStartHour.setText("");
        mTvEndHour.setText("");
        mTvTotalHours.setText("");
        mEtDaySalary.setText("");
        mEtDescription.setText("");
    }
    private void calculateDiffDays() {
        if (mStartCalendar!=null && mEndCalendar!=null) {
            int i = TimeUtils.differentDays(mStartCalendar, mEndCalendar);
            if (i>0) {
                String source = "共 " + i + " 天";
                SpannableString spannableString = new SpannableString(source);
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")),0,1, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")),source.length()-1,source.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                mTvTotalDays.setText(spannableString);
            }else {
                mTvTotalDays.setText("");
            }
        }
    }
}
