package com.example.com.morecharge;

import android.app.Application;
import android.content.Context;

import com.example.com.morecharge.config.C;
import com.example.com.morecharge.config.Environment;
import com.example.com.morecharge.remote.ApiService;
import com.example.com.net.HttpClient;
import com.example.com.net.config.HttpConfig;
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