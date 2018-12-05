package com.example.hdd.morecharge.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.utils.DisplayUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 顶部 titleBar
 * <p>
 * TopTitleBar
 */
public class TopBar extends RelativeLayout implements View.OnClickListener {


    // 左边的图片
    @BindView(R.id.iv_top_bar_left)
    ImageView mLeftIv;

    // 标题
    @BindView(R.id.tv_top_bar_title)
    TextView mTitleTv;

    // 标题
    @BindView(R.id.tv_top_bar_right)
    TextView mRightTitleTv;

    // 右边的图片
    @BindView(R.id.iv_top_bar_right)
    ImageView mRightIv;

    // 如果有提醒小圆点 , 显示
    @BindView(R.id.iv_top_bar_warn)
    ImageView mWarn;

    private Context mContext;

    private int leftSrc;
    private String centerText;
    private int rightSrc;
    private int warnSrc;
    private boolean isShowWarn;
    private boolean isShowLeft;
    private boolean isShowRight;
    private boolean isBack;

    private int centerTextColor;

    private View mView;

    private OnTopBarClickListener listener;
    private boolean isShowRightText;
    private int rightTextColor;
    private String rightText;


    public TopBar(Context context) {
        this(context, null);
    }

    public TopBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        this.mContext = context;

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);

        leftSrc = ta.getResourceId(R.styleable.TopBar_leftSrc, R.mipmap.ic_launcher);
        centerText = ta.getString(R.styleable.TopBar_centerText);
        rightSrc = ta.getResourceId(R.styleable.TopBar_rightSrc, R.mipmap.ic_launcher);
        warnSrc = ta.getResourceId(R.styleable.TopBar_warnSrc, R.mipmap.topbar_warn_dot);
        isShowWarn = ta.getBoolean(R.styleable.TopBar_isShowWarn, false);
        isShowLeft = ta.getBoolean(R.styleable.TopBar_isShowLeft, false);
        isShowRight = ta.getBoolean(R.styleable.TopBar_isShowRight, false);
        isBack = ta.getBoolean(R.styleable.TopBar_isBack, false);

//        <attr name="isShowRightText" format="boolean"></attr>
//        <attr name="rightTextColor" format="color"></attr>
//        rightText

        centerTextColor = ta.getColor(R.styleable.TopBar_centerTextColor, getResources().getColor(android.R.color.white));

        isShowRightText = ta.getBoolean(R.styleable.TopBar_isShowRightText, false);
        rightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, getResources().getColor(android.R.color.white));
        rightText = ta.getString(R.styleable.TopBar_rightText);

        ta.recycle();

        initContentView();
        initView();
        initListener();
    }

    private void initContentView() {
        mView = View.inflate(mContext, R.layout.view_top_bar, this);
        ButterKnife.bind(this);
    }

    // 初始化页面，根据设置项显示
    private void initView() {

        mTitleTv.setTextColor(centerTextColor);
        mTitleTv.setText(centerText);

        if (isShowRightText) {
            mRightTitleTv.setVisibility(VISIBLE);
            mRightTitleTv.setTextColor(rightTextColor);
            if (!TextUtils.isEmpty(rightText)) {
                mRightTitleTv.setText(rightText);
            }
        } else {
            mRightTitleTv.setVisibility(GONE);
        }

        if (isShowLeft) {
            mLeftIv.setVisibility(View.VISIBLE);
            mLeftIv.setImageResource(leftSrc);
        } else {
            mLeftIv.setVisibility(View.INVISIBLE);
        }

        if (isShowRight) {
            mRightIv.setVisibility(View.VISIBLE);
            mRightIv.setImageResource(rightSrc);
        } else {
            mRightIv.setVisibility(View.INVISIBLE);
        }

        showWarn();
    }

    //是否显示提醒
    private void showWarn() {
        if (isShowWarn) {
            mWarn.setImageResource(warnSrc);
            mWarn.setVisibility(View.VISIBLE);
        } else {
            mWarn.setVisibility(View.INVISIBLE);
        }
    }

    private void initListener() {
        mLeftIv.setOnClickListener(this);
        mRightIv.setOnClickListener(this);
        mRightTitleTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_top_bar_left:
                if (listener != null) {
                    listener.onTopBarLeftClick(v);
                }
                break;

            case R.id.iv_top_bar_right:
                if (listener != null) {
                    listener.onTopBarRightClick(v);
                }
                break;
            case R.id.tv_top_bar_right:

                Log.i("------", "onClick:00000000000000000000000000 ");
                if (tvClickListener != null) {
                    tvClickListener.onRightTvClickListener(v);
                }
                break;
        }
    }

    public void setRightTitleVisible(String title) {

        mRightTitleTv.setVisibility(VISIBLE);
        mRightIv.setVisibility(INVISIBLE);
        if (!TextUtils.isEmpty(title)) {
            mRightTitleTv.setText(title);
        }
    }


    public void setOnTopBarClickListener(OnTopBarClickListener listener) {
        this.listener = listener;
    }

    public interface OnTopBarClickListener {
        void onTopBarRightClick(View v);

        void onTopBarLeftClick(View v);
    }


    OnRightTvClickListener tvClickListener;

    public void setOnRightTvClickListener(OnRightTvClickListener tvClickListener) {

        this.tvClickListener = tvClickListener;
    }

    public interface OnRightTvClickListener {

        void onRightTvClickListener(View v);
    }

    public boolean isShowWarn() {
        return isShowWarn;
    }

    //设置是否显示提醒圆点
    public void setShowWarn(boolean isShowWarn) {
        this.isShowWarn = isShowWarn;
        showWarn();
    }


}
