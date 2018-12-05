package com.example.hdd.morecharge.main.register;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.hdd.common.BaseActivity;
import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.main.login.LoginActivity;
import com.example.hdd.morecharge.main.login.response.RegisterResponse;
import com.example.hdd.morecharge.main.login.response.VerificationCodeResponse;
import com.example.hdd.morecharge.remote.Injection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 71033 on 2018/11/19.
 */
public class RegisterActivity extends BaseActivity {


    @BindView(R.id.iv_user)
    ImageView ivUser;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.iv_auth_code)
    ImageView ivAuthCode;
    @BindView(R.id.et_verification)
    EditText etVerification;
    @BindView(R.id.btn_get_code)
    Button btnGetCode;
    @BindView(R.id.iv_password)
    ImageView ivPassword;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.lly_content)
    LinearLayout llyContent;
    @BindView(R.id.btn_register)
    Button btnRegister;

    private String smsToken;

    @Override
    public int bindLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void setView(Bundle savedInstanceState) {

    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_get_code, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get_code:
                getAuthCode();
                break;
            case R.id.btn_register:
                register();
                break;
        }
    }

    @SuppressLint("CheckResult")
    private void getAuthCode() {
        Injection.provideApiService().getAuthCode("http://api.huoduoduo360.com:9999/vcc/token",true,etPhone.getText().toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<VerificationCodeResponse>() {
                    @Override
                    public void accept(VerificationCodeResponse response) throws Exception {
                        if(response.isSuccess()){
                            ToastUtils.showShort(RegisterActivity.this,"验证码已发送");
                            smsToken = response.getData();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showShort(RegisterActivity.this,throwable.getMessage());
                    }
                });
    }

    @SuppressLint("CheckResult")
    private void register() {
        Injection.provideApiService().register("http://api.huoduoduo360.com:9999/uc/register/add",etPassword.getText().toString(),
                etPhone.getText().toString(),etVerification.getText().toString(),smsToken,"register")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegisterResponse>() {
                    @Override
                    public void accept(RegisterResponse response) throws Exception {
                        if(response.isSuccess()){
                            ToastUtils.showShort(RegisterActivity.this,"注册成功");
                            startActivity(LoginActivity.class);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showShort(RegisterActivity.this,throwable.getMessage());
                    }
                });
    }
}
