package com.example.com.morecharge.main.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.com.common.BaseFragment;
import com.example.com.common.util.ToastUtils;
import com.example.com.morecharge.R;
import com.example.com.morecharge.receive.response.VerificationCodeResponse;
import com.example.com.morecharge.remote.Injection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 71033 on 2018/11/20.
 */
public class QuickLoginFragment extends BaseFragment {

    @BindView(R.id.iv_user)
    ImageView ivUser;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.iv_auth_code)
    ImageView ivAuthCode;
    @BindView(R.id.et_auth_code)
    EditText etAuthCode;
    @BindView(R.id.btn_get_code)
    Button btnGetCode;
    @BindView(R.id.lly_content)
    LinearLayout llyContent;
    @BindView(R.id.btn_login)
    Button btnLogin;
    Unbinder unbinder;

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_login_quick;
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

    public static QuickLoginFragment newInstance() {

        Bundle args = new Bundle();

        QuickLoginFragment fragment = new QuickLoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_get_code, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get_code:
                getAuthCode();
                break;
            case R.id.btn_login:
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
                            ToastUtils.showShort(getActivity(),"验证码已发送");
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showShort(getActivity(),throwable.getMessage());
                    }
                });
    }
}
