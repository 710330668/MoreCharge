package com.example.hdd.morecharge.usercenter.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.example.hdd.common.BaseFragment;
import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.morecharge.MyApplication;
import com.example.hdd.morecharge.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 71033 on 2018/11/26.
 */
public class PersonalAuthFragment extends BaseFragment {

    Unbinder unbinder;

    private boolean hasGotToken = false;

    private AlertDialog.Builder alertDialog;

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_personal_auth;
    }

    @Override
    public void setView(View rootView) {

    }

    @Override
    public void initData(Bundle arguments) {
        alertDialog = new AlertDialog.Builder(getActivity());
    }

    @Override
    public void onLazyLoad() {
        initAccessTokenWithAkSk();
    }

    @Override
    public void unVisible() {

    }


    private boolean checkTokenStatus() {
        if (!hasGotToken) {
            ToastUtils.showShort(MyApplication.getContext(),"token还未成功获取");
        }
        return hasGotToken;
    }

    /**
     * 用明文ak，sk初始化
     */
    private void initAccessTokenWithAkSk() {
        OCR.getInstance(getActivity()).initAccessTokenWithAkSk(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken result) {
                String token = result.getAccessToken();
                hasGotToken = true;
            }

            @Override
            public void onError(OCRError error) {
                error.printStackTrace();
                alertText("AK，SK方式获取token失败", error.getMessage());
            }
        }, MyApplication.getContext(),  "7T0jcvCejxeOTeA82owxE4BN", "lK46kGHFGw19HKNp8UIYTQXye0DfDCCj");
    }

    private void alertText(final String title, final String message) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                alertDialog.setTitle(title)
                        .setMessage(message)
                        .setPositiveButton("确定", null)
                        .show();
            }
        });
    }

    public static PersonalAuthFragment newInstance() {

        Bundle args = new Bundle();

        PersonalAuthFragment fragment = new PersonalAuthFragment();
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

    @OnClick({R.id.btn_identity_auth, R.id.btn_face_auth})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_identity_auth:
                if (!checkTokenStatus()) {
                    return;
                }
                startActivity(IdentityAuthActivity.class);
                break;
            case R.id.btn_face_auth:
                // TODO 实时人脸检测
                Intent itDetect = new Intent(getActivity(), DetectActivity.class);
                startActivity(itDetect);
                break;
        }
    }



}
