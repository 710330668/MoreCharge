package com.example.com.morecharge.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.example.com.morecharge.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SelectPickTimeDialog extends Dialog {


    public SelectPickTimeDialog(@NonNull Context context) {
        super(context);
    }

    public SelectPickTimeDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected SelectPickTimeDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class Builder {
        private View.OnClickListener positionButtonClickListener;
        private View.OnClickListener navigationButtonClickListener;
        private View layout;
        private SelectPickTimeDialog dialog;
        private List<String> dateData = new ArrayList<>();
        private List<String> weekData = new ArrayList<>();
        private List<String> hourData = new ArrayList<>();
        private List<String> minuteData = new ArrayList<>();
        private WheelView dateWheel;
        private WheelView weekWheel;
        private WheelView hourWheel;
        private WheelView minuteWheel;

        public Builder(Context context) {
            dialog = new SelectPickTimeDialog(context, R.style.AlertDialogCustom);
            layout = LayoutInflater.from(context).inflate(R.layout.dialog_show_pick_time, null);
            dialog.addContentView(layout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            initData();
            initView();
        }

        private void initView() {

            dateWheel = (WheelView) layout.findViewById(R.id.date_wheel);
            dateWheel.setOffset(2);
            dateWheel.setItems(dateData);
            dateWheel.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
                @Override
                public void onSelected(int selectedIndex, String item) {
                    weekWheel.setSeletion(selectedIndex - 2);
                }
            });

            weekWheel = (WheelView) layout.findViewById(R.id.week_wheel);
            weekWheel.setOffset(2);
            weekWheel.setItems(weekData);
            weekWheel.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
                @Override
                public void onSelected(int selectedIndex, String item) {
                    dateWheel.setSeletion(selectedIndex - 2);
                }
            });

            hourWheel = (WheelView) layout.findViewById(R.id.hour_wheel);
            hourWheel.setOffset(2);
            hourWheel.setItems(hourData);

            minuteWheel = (WheelView) layout.findViewById(R.id.minute_wheel);
            minuteWheel.setOffset(2);
            minuteWheel.setItems(minuteData);

            layout.findViewById(R.id.tv_pick_immediately).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dateWheel.setSeletion(0);
                    weekWheel.setSeletion(0);
                    Calendar calendar = Calendar.getInstance();
                    hourWheel.setSeletion(Integer.parseInt(new SimpleDateFormat("hh").format(calendar.getTime())));
                    minuteWheel.setSeletion(Integer.parseInt(new SimpleDateFormat("mm").format(calendar.getTime())));
                }
            });
        }

        private void initData() {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateSdf = new SimpleDateFormat("M月d号");
            SimpleDateFormat weekSdf = new SimpleDateFormat("EEE");
            dateData.add(dateSdf.format(calendar.getTime()));
            weekData.add(weekSdf.format(calendar.getTime()));

            for (int i = 0; i < 6; i++) {
                calendar.add(Calendar.DATE, 1);
                dateData.add(dateSdf.format(calendar.getTime()));
                weekData.add(weekSdf.format(calendar.getTime()));
            }

            for (int i = 0; i < 24; i++) {
                hourData.add(i + "点");
            }
            for (int i = 0; i < 60; i++) {
                minuteData.add(i + "分");
            }
        }

        public Builder setPositionButton(View.OnClickListener listener) {
            this.positionButtonClickListener = listener;
            return this;
        }

        public Builder setNavigationButton(View.OnClickListener listener) {
            this.navigationButtonClickListener = listener;
            return this;
        }

        public SelectPickTimeDialog createDialog() {
            layout.findViewById(R.id.tv_sure).setOnClickListener(positionButtonClickListener);
            layout.findViewById(R.id.tv_cancel).setOnClickListener(navigationButtonClickListener);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(false);
            return dialog;
        }

        public void dismiss() {
            dialog.dismiss();
        }
    }
}
