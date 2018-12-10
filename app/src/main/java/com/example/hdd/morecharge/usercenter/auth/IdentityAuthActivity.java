package com.example.hdd.morecharge.usercenter.auth;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.IDCardParams;
import com.baidu.ocr.sdk.model.IDCardResult;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.baidu.ocr.ui.camera.CameraNativeHelper;
import com.baidu.ocr.ui.camera.CameraView;
import com.baidu.ocr.ui.util.FileUtil;
import com.example.hdd.common.BaseActivity;
import com.example.hdd.common.util.ToastUtils;
import com.example.hdd.imageloader.LoaderManager;
import com.example.hdd.morecharge.R;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 71033 on 2018/11/27.
 */
public class IdentityAuthActivity extends BaseActivity {

    private static final int REQUEST_CODE_PICK_IMAGE_FRONT = 201;
    private static final int REQUEST_CODE_PICK_IMAGE_BACK = 202;
    private static final int REQUEST_CODE_CAMERA = 102;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_number)
    EditText etNumber;
    @BindView(R.id.iv_idcard_front)
    ImageView ivIdcardFront;
    @BindView(R.id.iv_idcard_back)
    ImageView ivIdcardBack;

    private AlertDialog.Builder alertDialog;

    private boolean checkGalleryPermission() {
        int ret = ActivityCompat.checkSelfPermission(IdentityAuthActivity.this, Manifest.permission
                .READ_EXTERNAL_STORAGE);
        if (ret != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(IdentityAuthActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    1000);
            return false;
        }
        return true;
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_identity_auth;
    }

    @Override
    public void initParams(Bundle params) {
        alertDialog = new AlertDialog.Builder(this);
    }

    @Override
    public void setView(Bundle savedInstanceState) {

    }

    @Override
    public void doBusiness(Context mContext) {
//  初始化本地质量控制模型,释放代码在onDestory中
        //  调用身份证扫描必须加上 intent.putExtra(CameraActivity.KEY_NATIVE_MANUAL, true); 关闭自动初始化和释放本地模型
        CameraNativeHelper.init(this, OCR.getInstance(this).getLicense(),
                new CameraNativeHelper.CameraNativeInitCallback() {
                    @Override
                    public void onError(int errorCode, Throwable e) {
                        String msg;
                        switch (errorCode) {
                            case CameraView.NATIVE_SOLOAD_FAIL:
                                msg = "加载so失败，请确保apk中存在ui部分的so";
                                break;
                            case CameraView.NATIVE_AUTH_FAIL:
                                msg = "授权本地质量控制token获取失败";
                                break;
                            case CameraView.NATIVE_INIT_FAIL:
                                msg = "本地质量控制";
                                break;
                            default:
                                msg = String.valueOf(errorCode);
                        }
                        ToastUtils.showShort(IdentityAuthActivity.this, "本地质量控制初始化错误，错误原因： " + msg);
                    }
                });
    }


    private void recIDCard(String idCardSide, String filePath) {
        IDCardParams param = new IDCardParams();
        param.setImageFile(new File(filePath));
        // 设置身份证正反面
        param.setIdCardSide(idCardSide);
        // 设置方向检测
        param.setDetectDirection(true);
        // 设置图像参数压缩质量0-100, 越大图像质量越好但是请求时间越长。 不设置则默认值为20
        param.setImageQuality(20);

        OCR.getInstance(this).recognizeIDCard(param, new OnResultListener<IDCardResult>() {
            @Override
            public void onResult(IDCardResult result) {
                if (result != null) {
                    if (result.getIdCardSide().equals("front")) {
                        etName.setText(result.getName() + "");
                        etNumber.setText(result.getIdNumber() + "");
                        alertText("", result.toString());
                        ivIdcardFront.setVisibility(View.VISIBLE);
                        LoaderManager.getLoader().loadFile(ivIdcardFront,new File(FileUtil.getSaveFrontFile(getApplicationContext()).getAbsolutePath()),null);
                    }else{
                        ivIdcardBack.setVisibility(View.VISIBLE);
                        LoaderManager.getLoader().loadFile(ivIdcardBack,new File(FileUtil.getSaveBackFile(getApplicationContext()).getAbsolutePath()),null);
                    }
                }
            }

            @Override
            public void onError(OCRError error) {
                alertText("", error.getMessage());
            }
        });
    }


    private void alertText(final String title, final String message) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                alertDialog.setTitle(title)
                        .setMessage(message)
                        .setPositiveButton("确定", null)
                        .show();
            }
        });
    }


    private String getRealPathFromURI(Uri contentURI) {
        String result;
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PICK_IMAGE_FRONT && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            String filePath = getRealPathFromURI(uri);
            recIDCard(IDCardParams.ID_CARD_SIDE_FRONT, filePath);
        }

        if (requestCode == REQUEST_CODE_PICK_IMAGE_BACK && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            String filePath = getRealPathFromURI(uri);
            recIDCard(IDCardParams.ID_CARD_SIDE_BACK, filePath);
        }

        if (requestCode == REQUEST_CODE_CAMERA && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String contentType = data.getStringExtra(CameraActivity.KEY_CONTENT_TYPE);
                if (CameraActivity.CONTENT_TYPE_ID_CARD_FRONT.equals(contentType)) {
                    String filePath = FileUtil.getSaveFrontFile(getApplicationContext()).getAbsolutePath();
                    recIDCard(IDCardParams.ID_CARD_SIDE_FRONT, filePath);
                }else{
                    String filePath = FileUtil.getSaveFrontFile(getApplicationContext()).getAbsolutePath();
                    recIDCard(IDCardParams.ID_CARD_SIDE_BACK, filePath);
                }
            }
        }
    }


    @Override
    protected void onDestroy() {
        // 释放本地质量控制模型
        CameraNativeHelper.release();
        super.onDestroy();
    }

    @OnClick({R.id.iv_back, R.id.lly_idcard_front, R.id.lly_idcard_back, R.id.btn_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                break;
            case R.id.lly_idcard_front:
                Intent intent = new Intent(IdentityAuthActivity.this, CameraActivity.class);
                intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                        FileUtil.getSaveFrontFile(getApplication()).getAbsolutePath());
                intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_FRONT);
                startActivityForResult(intent, REQUEST_CODE_CAMERA);
                break;
            case R.id.lly_idcard_back:
                Intent intent1 = new Intent(IdentityAuthActivity.this, CameraActivity.class);
                intent1.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                        FileUtil.getSaveBackFile(getApplication()).getAbsolutePath());
                intent1.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_BACK);
                startActivityForResult(intent1, REQUEST_CODE_CAMERA);
                break;
            case R.id.btn_commit:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
