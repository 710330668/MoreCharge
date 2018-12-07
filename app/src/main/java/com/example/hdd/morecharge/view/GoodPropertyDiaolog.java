package com.example.hdd.morecharge.view;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.hdd.common.adapter.BaseAdapter;
import com.example.hdd.common.adapter.ItemData;
import com.example.hdd.common.adapter.onItemClickListener;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.remote.SettingDelegate;

import java.util.ArrayList;
import java.util.List;

public class GoodPropertyDiaolog extends Dialog {


    public GoodPropertyDiaolog(@NonNull Context context) {
        super(context);
    }

    public GoodPropertyDiaolog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected GoodPropertyDiaolog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class Builder {
        private  TextView mTvResult;
        private  RecyclerView mRclGoodProperty;
        private SeekBar weightSeek;
        private View.OnClickListener positionButtonClickListener;
        private View.OnClickListener navigationButtonClickListener;
        private View layout;
        private static final String TAG = "Builder";
        private GoodPropertyDiaolog dialog;
        private List<ItemData> propertyList = new ArrayList<>();

        public Builder(Context context) {
            dialog = new GoodPropertyDiaolog(context, R.style.AlertDialogCustom);
            layout = LayoutInflater.from(context).inflate(R.layout.dialog_show_good_property, null);
            dialog.addContentView(layout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            weightSeek = ((SeekBar) layout.findViewById(R.id.seek_weight));
            mTvResult = ((TextView) layout.findViewById(R.id.tv_weight_measure));
            weightSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    switch (i) {
                        case 0:
                            mTvResult.setText("小于5公斤");
                            break;
                        case 17:
                            mTvResult.setText("大于20公斤");
                            break;
                            default:
                            mTvResult.setText((i+4) + "公斤");
                                break;
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
            initGoodProperty(context);
        }

        private void initGoodProperty(Context context) {
            mRclGoodProperty = ((RecyclerView) dialog.findViewById(R.id.rvy_good_property));
            propertyList.add(new ItemData(0, SettingDelegate.RELEASE_GOOD_PROPERTY,"餐饮"));
            propertyList.add(new ItemData(0, SettingDelegate.RELEASE_GOOD_PROPERTY,"文件"));
            propertyList.add(new ItemData(0, SettingDelegate.RELEASE_GOOD_PROPERTY,"生鲜"));
            propertyList.add(new ItemData(0, SettingDelegate.RELEASE_GOOD_PROPERTY,"蛋糕"));
            propertyList.add(new ItemData(0, SettingDelegate.RELEASE_GOOD_PROPERTY,"鲜花"));
            propertyList.add(new ItemData(0, SettingDelegate.RELEASE_GOOD_PROPERTY,"钥匙"));
            propertyList.add(new ItemData(0, SettingDelegate.RELEASE_GOOD_PROPERTY,"数码"));
            propertyList.add(new ItemData(0, SettingDelegate.RELEASE_GOOD_PROPERTY,"服饰"));
            propertyList.add(new ItemData(0, SettingDelegate.RELEASE_GOOD_PROPERTY,"其他"));
            mRclGoodProperty.setLayoutManager(new GridLayoutManager(context,3));
            mRclGoodProperty.setAdapter(new BaseAdapter(propertyList, new SettingDelegate(), new onItemClickListener() {
                @Override
                public void onClick(View v, Object data) {

                }

                @Override
                public boolean onLongClick(View v, Object data) {
                    return false;
                }
            }));
        }

        public Builder setPositionButton(View.OnClickListener listener) {
            this.positionButtonClickListener = listener;
            return this;
        }

        public Builder setNavigationButton(View.OnClickListener listener) {
            this.navigationButtonClickListener = listener;
            return this;
        }

        public GoodPropertyDiaolog createDialog() {
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
