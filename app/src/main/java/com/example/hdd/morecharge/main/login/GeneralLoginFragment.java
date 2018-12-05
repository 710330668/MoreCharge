package com.example.hdd.morecharge.main.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.hdd.common.BaseFragment;
import com.example.hdd.common.util.SP;
import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.morecharge.R;
import com.example.hdd.morecharge.config.C;
import com.example.hdd.morecharge.main.register.RegisterActivity;
import com.example.hdd.morecharge.main.retrieve.RetrievePwActivity;
import com.example.hdd.morecharge.main.login.response.LoginResponse;
import com.example.hdd.morecharge.remote.Injection;
import com.example.hdd.morecharge.usercenter.MineActivity;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 71033 on 2018/11/20.
 */
public class GeneralLoginFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    Unbinder unbinder1;

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_login_general;
    }

    @Override
    public void setView(View rootView) {


    }

    @Override
    public void initData(Bundle arguments) {

    }

    @Override
    public void onLazyLoad() {

    }

    @Override
    public void unVisible() {

    }

    public static GeneralLoginFragment newInstance() {

        Bundle args = new Bundle();

        GeneralLoginFragment fragment = new GeneralLoginFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_retrieve_pw, R.id.tv_register, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_retrieve_pw:
                startActivity(RetrievePwActivity.class);
                break;
            case R.id.tv_register:
                startActivity(RegisterActivity.class);
                break;
            case R.id.btn_login:
                //登录
                login();
                break;
        }
    }

    @SuppressLint("CheckResult")
    private void login() {
        if (TextUtils.isEmpty(etUsername.getText().toString())||
                TextUtils.isEmpty(etPassword.getText().toString())){
            ToastUtils.showShort(getActivity(),"用户名或密码不能为空");
            return;
        }
        Injection.provideApiService().login("http://api.huoduoduo360.com:9999/auth/oauth/token",
                etUsername.getText().toString(),etPassword.getText().toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse loginResponse) throws Exception {
                        if(!TextUtils.isEmpty(loginResponse.getAccess_token())){
                            ToastUtils.showShort(getActivity(),"登录成功");
                            saveUserInfor(loginResponse);
                            startActivity(MineActivity.class);
                        }else{
                            ToastUtils.showShort(getActivity(),"登录失败");
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showShort(getActivity(),throwable.toString());
                    }
                });
    }

    private void saveUserInfor(LoginResponse loginResponse) {
        SP.getInstance(C.USER_DB,getActivity()).put(C.USER_ACCESS_TOKEN,loginResponse.getAccess_token());
        SP.getInstance(C.USER_DB,getActivity()).put(C.USER_REFRESH_TOKEN,loginResponse.getRefresh_token());
    }

}
