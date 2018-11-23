package com.example.com.morecharge.remote;

import com.example.com.morecharge.receive.response.LoginResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by 71033 on 2018/11/16.
 */
public interface ApiService {

    //登录
    @GET
    Observable<LoginResponse> login(@Url String url, @Query("username") String userName,@Query("password") String password);

}
