package com.example.com.morecharge.receive.main;

import android.content.Context;
import android.os.Bundle;

import com.example.com.common.BaseActivity;
import com.example.com.morecharge.R;
import com.example.com.morecharge.view.MyRatingBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 71033 on 2018/11/21.
 */
public class ScoreActivity extends BaseActivity {

    @BindView(R.id.ratingBar)
    MyRatingBar ratingBar;
    @BindView(R.id.ratingBar_quality)
    MyRatingBar ratingBarQuality;
    @BindView(R.id.ratingBar_attitude)
    MyRatingBar ratingBarAttitude;
    @BindView(R.id.ratingBar_progress)
    MyRatingBar ratingBarProgress;

    @Override
    public int bindLayout() {
        return R.layout.activity_score;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void setView(Bundle savedInstanceState) {

    }

    @Override
    public void doBusiness(Context mContext) {
        ratingBar.setMark(4.85f);
        ratingBarQuality.setMark(4.85f);
        ratingBarAttitude.setMark(4.85f);
        ratingBarProgress.setMark(4.85f);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
