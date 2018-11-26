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
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.com.morecharge.R;

public class SelectInsuranceDialog extends Dialog {


    public SelectInsuranceDialog(@NonNull Context context) {
        super(context);
    }

    public SelectInsuranceDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected SelectInsuranceDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class Builder {
        private View.OnClickListener positionButtonClickListener;
        private View.OnClickListener navigationButtonClickListener;
        private View layout;
        private SelectInsuranceDialog dialog;
        private RadioButton mRb0, mRb1, mRb2, mRb3;
        private String insurance1 = "1元货损险 \n若物品损坏或丢失，最高可赔付300元";
        private String insurance2 = "5元货损险 \n若物品损坏或丢失，最高可赔付1500元";
        private String insurance3 = "10元货损险\n若物品损坏或丢失，最高可赔付3000元，10%免费额";
        private Spannable spannable1, spannable2, spannable3;

        public Builder(Context context) {
            dialog = new SelectInsuranceDialog(context, R.style.AlertDialogCustom);
            layout = LayoutInflater.from(context).inflate(R.layout.dialog_show_insurance, null);
            dialog.addContentView(layout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mRb0 = layout.findViewById(R.id.rb_insurance_0);
            mRb1 = layout.findViewById(R.id.rb_insurance_1);

            spannable1 = new SpannableString(insurance1);
            spannable1.setSpan(new AbsoluteSizeSpan(context.getResources().getDimensionPixelOffset(R.dimen.dimen_14_sp), false), 0, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            spannable1.setSpan(new AbsoluteSizeSpan(context.getResources().getDimensionPixelOffset(R.dimen.dimen_11_sp), false), 6, insurance1.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            spannable1.setSpan(new ForegroundColorSpan(Color.parseColor("#666666")), 0, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            spannable1.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 6, insurance1.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            mRb1.setText(spannable1);
            mRb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        spannable1.setSpan(new ForegroundColorSpan(Color.parseColor("#FD8B06")), 0, insurance1.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        mRb1.setText(spannable1);
                    } else {
                        spannable1.setSpan(new ForegroundColorSpan(Color.parseColor("#666666")), 0, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        spannable1.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 6, insurance1.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        mRb1.setText(spannable1);
                    }
                }
            });

            mRb2 = layout.findViewById(R.id.rb_insurance_2);
            spannable2 = new SpannableString(insurance2);
            spannable2.setSpan(new AbsoluteSizeSpan(context.getResources().getDimensionPixelOffset(R.dimen.dimen_14_sp), false), 0, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            spannable2.setSpan(new AbsoluteSizeSpan(context.getResources().getDimensionPixelOffset(R.dimen.dimen_11_sp), false), 6, insurance2.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            spannable2.setSpan(new ForegroundColorSpan(Color.parseColor("#666666")), 0, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            spannable2.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 6, insurance2.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            mRb2.setText(spannable2);
            mRb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        spannable2.setSpan(new ForegroundColorSpan(Color.parseColor("#FD8B06")), 0, insurance2.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        mRb2.setText(spannable2);
                    } else {
                        spannable2.setSpan(new ForegroundColorSpan(Color.parseColor("#666666")), 0, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        spannable2.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 6, insurance2.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        mRb2.setText(spannable2);
                    }
                }
            });

            mRb3 = layout.findViewById(R.id.rb_insurance_3);
            spannable3 = new SpannableString(insurance3);
            spannable3.setSpan(new AbsoluteSizeSpan(context.getResources().getDimensionPixelOffset(R.dimen.dimen_14_sp), false), 0, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            spannable3.setSpan(new AbsoluteSizeSpan(context.getResources().getDimensionPixelOffset(R.dimen.dimen_11_sp), false), 6, insurance3.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            spannable3.setSpan(new ForegroundColorSpan(Color.parseColor("#666666")), 0, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            spannable3.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 6, insurance3.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            mRb3.setText(spannable3);
            mRb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        spannable3.setSpan(new ForegroundColorSpan(Color.parseColor("#FD8B06")), 0, insurance3.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        mRb3.setText(spannable3);
                    } else {
                        spannable3.setSpan(new ForegroundColorSpan(Color.parseColor("#666666")), 0, 6, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        spannable3.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 6, insurance3.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        mRb3.setText(spannable3);
                    }
                }
            });
        }

        public Builder setPositionButton(View.OnClickListener listener) {
            this.positionButtonClickListener = listener;
            return this;
        }

        public Builder setNavigationButton(View.OnClickListener listener) {
            this.navigationButtonClickListener = listener;
            return this;
        }

        public SelectInsuranceDialog createDialog() {
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
