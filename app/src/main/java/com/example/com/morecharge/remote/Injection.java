package com.example.com.morecharge.remote;

import com.example.com.morecharge.MyApplication;

/**
 * Created by 71033 on 2018/11/16.
 */
public class Injection {

    private static ApiService apiService;


    static {
        apiService = MyApplication.getInstance().getApiService();
    }

    public static ApiService provideApiService() {
        return apiService;
    }
}
