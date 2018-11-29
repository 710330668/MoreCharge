package com.example.com.morecharge.usercenter.setting;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.common.BaseActivity;
import com.example.com.common.util.DataCleanManager;
import com.example.com.common.util.SP;
import com.example.com.morecharge.MyApplication;
import com.example.com.morecharge.R;
import com.example.com.morecharge.config.C;
import com.example.com.morecharge.main.login.LoginActivity;
import com.example.com.morecharge.view.AlertDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 71033 on 2018/11/27.
 */
public class SettingActivity extends BaseActivity {

    @BindView(R.id.tv_cache)
    TextView tvCache;
    @BindView(R.id.tv_version)
    TextView tvVersion;
    private AlertDialog myDialog;
    private String cacheNum;

    @Override
    public int bindLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void setView(Bundle savedInstanceState) {

    }

    @Override
    public void doBusiness(Context mContext) {
        myDialog = new AlertDialog(this).builder();
        try {
            cacheNum = DataCleanManager.getTotalCacheSize(MyApplication.getContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        tvCache.setText(cacheNum);
        tvVersion.setText(getVersionName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.rl_change_phone, R.id.rl_change_pw, R.id.iv_clear_cache, R.id.tv_cache, R.id.rl_clear_cache, R.id.rl_version, R.id.btn_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_change_phone:
                startActivity(ChangePhoneActivity.class);
                break;
            case R.id.rl_change_pw:
                startActivity(ChangePwActivity.class);
                break;
            case R.id.tv_cache:
                break;
            case R.id.rl_clear_cache:
                clearCache();
                break;
            case R.id.rl_version:
                break;
            case R.id.btn_exit:
                exit();
                break;
        }
    }

    private void clearCache() {
        myDialog.setGone().setTitle("提示").setMsg("确定要清除当前缓存？").setNegativeButton("取消", null).setPositiveButton("确定", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingActivity.this, "缓存清理中,请耐心等待..", Toast.LENGTH_SHORT).show();
                DataCleanManager.cleanInternalCache(MyApplication.getContext());
                Handler mHandler = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        tvCache.setText("0MB");
                        Toast.makeText(SettingActivity.this, "缓存已清理完毕", Toast.LENGTH_SHORT).show();
                    }
                };


                mHandler.postDelayed(r, 5000);//延时100毫秒
                myDialog.dismiss();
            }
        }).show();
    }

    private void exit() {
        myDialog.setGone().setTitle("提示").setMsg("确定退出？").setNegativeButton("取消", null).setPositiveButton("确定", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SP.getInstance(C.USER_DB, SettingActivity.this).put(C.USER_ACCESS_TOKEN, "");
                SP.getInstance(C.USER_DB, SettingActivity.this).put(C.USER_REFRESH_TOKEN, "");
                startActivity(LoginActivity.class);
                finish();
                myDialog.dismiss();
            }
        }).show();
    }
}
