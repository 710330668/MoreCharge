package com.example.hdd.morecharge.view;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.hdd.common.util.TimeUtils;
import com.example.hdd.morecharge.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SelectKeepDateDialog extends Dialog {

    private static final String TAG = "SelectKeepDateDialog";


    public SelectKeepDateDialog(@NonNull Context context) {
        super(context);
    }

    public SelectKeepDateDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected SelectKeepDateDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class Builder {
        private View.OnClickListener positionButtonClickListener;
        private View.OnClickListener navigationButtonClickListener;
        private View layout;
        private SelectKeepDateDialog dialog;
        private List<String> yearData = new ArrayList<>();
        private List<String> monthData = new ArrayList<>();
        private List<String> dayData = new ArrayList<>();
        private WheelView yearWheel;
        private WheelView monthWheel;
        private WheelView dayWheel;
        private int selectYear;
        private int selectMonth;
        private TextView mTitle;

        public Builder(Context context) {
            dialog = new SelectKeepDateDialog(context, R.style.AlertDialogCustom);
            layout = LayoutInflater.from(context).inflate(R.layout.dialog_select_date, null);
            dialog.addContentView(layout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            initData();
            initView();
        }

        private void initData() {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy");
            String currentYear = dateSdf.format(calendar.getTime());

            for (int i = 0; i < 6; i++) {
                yearData.add((Integer.parseInt(currentYear) + i) + "年");
            }

            for (int i = 1; i < 13; i++) {
                monthData.add(i + "月");
            }
        }

        private void initView() {

            mTitle = (TextView) layout.findViewById(R.id.tv_title);

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat yearSdf = new SimpleDateFormat("yyyy");
            SimpleDateFormat dateSdf = new SimpleDateFormat("MM");

            yearWheel = (WheelView) layout.findViewById(R.id.year_wheel);
            yearWheel.setOffset(2);
            yearWheel.setItems(yearData);
            yearWheel.setSeletion(0);
            yearWheel.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
                @Override
                public void onSelected(int selectedIndex, String item) {
                    super.onSelected(selectedIndex, item);
                    selectYear = Integer.parseInt(item.replace("年", ""));
                    changeDayData(selectYear, selectMonth);
                }
            });

            monthWheel = (WheelView) layout.findViewById(R.id.month_wheel);
            monthWheel.setOffset(2);
            monthWheel.setItems(monthData);
            int month = Integer.parseInt(dateSdf.format(calendar.getTime()));
            monthWheel.setSeletion(month);
            monthWheel.setSeletion(0);
            monthWheel.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
                @Override
                public void onSelected(int selectedIndex, String item) {
                    selectMonth = Integer.parseInt(item.replace("月", ""));
                    changeDayData(selectYear, selectMonth);
                }
            });


            int year = Integer.parseInt(yearSdf.format(calendar.getTime()));
            dayWheel = (WheelView) layout.findViewById(R.id.day_wheel);
            dayWheel.setOffset(2);
            dayWheel.setSeletion(0);
            changeDayData(year, month);
        }


        public Builder setPositionButton(View.OnClickListener listener) {
            this.positionButtonClickListener = listener;
            return this;
        }

        public Builder setNavigationButton(View.OnClickListener listener) {
            this.navigationButtonClickListener = listener;
            return this;
        }

        public void setTitle(String title) {
            mTitle.setText(title);
        }

        public String getDate() {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, yearWheel.getSeletedIndex());
            calendar.set(Calendar.MONTH, monthWheel.getSeletedIndex());
            calendar.set(Calendar.DAY_OF_MONTH, dayWheel.getSeletedIndex() + 1);
            String format = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
            return format;
        }

        public Calendar getCalendar() {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, yearWheel.getSeletedIndex());
            calendar.set(Calendar.MONTH, monthWheel.getSeletedIndex());
            calendar.set(Calendar.DAY_OF_MONTH, dayWheel.getSeletedIndex() + 1);
            return calendar;
        }

        void changeDayData(int year, int month) {
            dayData.clear();
            for (int i = 0; i < TimeUtils.getDays(year, month); i++) {
                dayData.add((i + 1) + "号");
            }
            dayWheel.setItems(dayData);
            dayWheel.setSeletion(0);
        }

        public SelectKeepDateDialog createDialog() {
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
