package com.example.hdd.morecharge.config;

/**
 * Created by 71033 on 2018/11/16.
 */
public interface C {

    //正式
    String PRODUCT_BASE_URL = "";


    //测试
    String TEST_BASE_URL = "https://api.huoduoduo360.com";

    //http缓存大小
    int httpCacheSize = 10 * 1024 * 1024;

    //http超时时间
    long httpTimeOut = 50000L;

    //用户信息
    String USER_DB = "user_db";

    String USER_ACCESS_TOKEN = "access_token";

    String USER_REFRESH_TOKEN = "refresh_token";


    //
    String CHOOSE_ADDRESS = "choose_address";




}
