package com.example.com.morecharge.remote;

import com.example.com.morecharge.receive.response.LoginResponse;
import com.example.com.morecharge.receive.response.RegisterResponse;
import com.example.com.morecharge.receive.response.VerificationCodeResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by 71033 on 2018/11/16.
 */
public interface ApiService {

    //登录
    @GET
    Observable<LoginResponse> login(@Url String url, @Query("username") String userName,@Query("password") String password);

    //获取验证码
    @GET
    Observable<VerificationCodeResponse> getAuthCode(@Url String url, @Query("sendSms") boolean sendSms, @Query("subject") String subject);

    //注册
    @FormUrlEncoded
    @POST
    Observable<RegisterResponse> register(@Url String url, @Field("password") String password, @Field("phoneNumber") String phoneNumber, @Field("smsCode") String smsCode
            , @Field("smsToken") String smsToken, @Field("type") String type);




    /*******************************************接单*************************************************/
    //查询可抢单的订单
    @FormUrlEncoded
    @POST("viewOrderWait/query")
    Observable<LoginResponse> getClientList(@Header("authorization") String token,@Field("longitude") String longitude, @Field("latitude") String latitude, @Field("orderBy") String orderBy, @Field("deacOrAsc") String deacOrAsc);


}
