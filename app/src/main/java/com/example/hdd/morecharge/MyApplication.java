package com.example.hdd.morecharge;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.baidu.aip.FaceEnvironment;
import com.baidu.aip.FaceSDKManager;
import com.baidu.idl.facesdk.FaceTracker;
import com.example.hdd.morecharge.config.APIService;
import com.example.hdd.morecharge.config.C;
import com.example.hdd.morecharge.config.Config;
import com.example.hdd.morecharge.config.Environment;
import com.example.hdd.morecharge.remote.ApiService;
import com.example.hdd.morecharge.utils.FaceError;
import com.example.hdd.morecharge.utils.face.OnResultListener;
import com.example.hdd.morecharge.utils.face.model.AccessToken;
import com.example.hdd.net.HttpClient;
import com.example.hdd.net.config.HttpConfig;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.io.File;

import okhttp3.Cache;

/**
 * Created by 71033 on 2018/11/16.
 */
public class MyApplication extends Application{

    public static MyApplication instance;
    private static Context context;
    @Environment.ENV
    public static int environment = Environment.DEBUG;
    public static ApiService apiService;

    @Override
    public void onCreate() {
        super.onCreate();
        initHttpConfig();
        context = getApplicationContext();
        initImageLoader();
        initLib();
        APIService.getInstance().init(this);
        APIService.getInstance().setGroupId(Config.groupID);
        // 用ak，sk获取token, 调用在线api，如：注册、识别等。为了ak、sk安全，建议放您的服务器，
        APIService.getInstance().initAccessTokenWithAkSk(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken result) {
                Log.i("wtf", "AccessToken->" + result.getAccessToken());

            }

            @Override
            public void onError(FaceError error) {
                Log.e("xx", "AccessTokenError:" + error);
                error.printStackTrace();

            }
        }, this, Config.apiKey, Config.secretKey);
    }


    public static MyApplication getInstance() {
        if (instance == null) {
            synchronized (MyApplication.class) {
                if (instance == null) {
                    instance = new MyApplication();
                }
            }
        }
        return instance;
    }


    /**
     * 初始化SDK
     */
    private void initLib() {
        // 为了android和ios 区分授权，appId=appname_face_android ,其中appname为申请sdk时的应用名
        // 应用上下文
        // 申请License取得的APPID
        // assets目录下License文件名
        FaceSDKManager.getInstance().init(this, Config.licenseID, Config.licenseFileName);
        setFaceConfig();
    }


    private void setFaceConfig() {
        FaceTracker tracker = FaceSDKManager.getInstance().getFaceTracker(this);
        // SDK初始化已经设置完默认参数（推荐参数），您也根据实际需求进行数值调整

        // 模糊度范围 (0-1) 推荐小于0.7
        tracker.set_blur_thr(FaceEnvironment.VALUE_BLURNESS);
        // 光照范围 (0-1) 推荐大于40
        tracker.set_illum_thr(FaceEnvironment.VALUE_BRIGHTNESS);
        // 裁剪人脸大小
        tracker.set_cropFaceSize(FaceEnvironment.VALUE_CROP_FACE_SIZE);
        // 人脸yaw,pitch,row 角度，范围（-45，45），推荐-15-15
        tracker.set_eulur_angle_thr(FaceEnvironment.VALUE_HEAD_PITCH, FaceEnvironment.VALUE_HEAD_ROLL,
                FaceEnvironment.VALUE_HEAD_YAW);

        // 最小检测人脸（在图片人脸能够被检测到最小值）80-200， 越小越耗性能，推荐120-200
        tracker.set_min_face_size(FaceEnvironment.VALUE_MIN_FACE_SIZE);
        //
        tracker.set_notFace_thr(FaceEnvironment.VALUE_NOT_FACE_THRESHOLD);
        // 人脸遮挡范围 （0-1） 推荐小于0.5
        tracker.set_occlu_thr(FaceEnvironment.VALUE_OCCLUSION);
        // 是否进行质量检测
        tracker.set_isCheckQuality(true);
        // 是否进行活体校验
        tracker.set_isVerifyLive(false);
    }

    /**
     * 初始化HTTP设置
     */
    private void initHttpConfig() {
        String baseUrl = "";
        switch (environment) {
            case Environment.DEBUG:
                baseUrl = C.TEST_BASE_URL;
                break;
            case Environment.PRODUCT:
                baseUrl = C.PRODUCT_BASE_URL;
                break;
            default:
                break;
        }
        Cache cache = new Cache(new File(getCacheDir(), "httpCache"), C.httpCacheSize);

        HttpConfig httpConfig = new HttpConfig()
                .setHttpCache(cache)
                .setTimeout(C.httpTimeOut)
                .setBaseUrl(baseUrl);

        apiService = HttpClient
                .getInstance(httpConfig)
                .getRetrofit()
                .create(ApiService.class);
    }

    public static ApiService getApiService() {
        return apiService;
    }

    /**
     * 获取全局上下文
     */
    public static Context getContext() {
        return context;
    }


    public void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext()).threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .writeDebugLogs() // Remove for release app
                .build();
        ImageLoader.getInstance().init(config);
    }

}