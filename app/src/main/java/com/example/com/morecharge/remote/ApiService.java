package com.example.com.morecharge.remote;

import com.example.com.morecharge.main.login.response.LoginResponse;
import com.example.com.morecharge.main.login.response.RegisterResponse;
import com.example.com.morecharge.main.login.response.VerificationCodeResponse;
import com.example.com.morecharge.receive.request.ReceiveOrderDetailRequest;
import com.example.com.morecharge.receive.request.ReceiveOrdersRequest;
import com.example.com.morecharge.receive.request.RobOrderRequest;
import com.example.com.morecharge.receive.response.ReceiveOrderDetailResponse;
import com.example.com.morecharge.receive.response.ReceiveOrdersResponse;
import com.example.com.morecharge.receive.response.RobOrderResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;


import com.example.com.morecharge.receive.main.myskills.entity.SkillResetResponse;
import com.example.com.morecharge.receive.main.myskills.entity.SkillsResponseEntry;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 71033 on 2018/11/16.
 */
public interface ApiService {


    //【技能】-获取系统所有技能
    @GET("/order/orderTypeCode/role")
    Observable<SkillsResponseEntry> getAllSkills(@Header("authorization") String token);

    /**
     * 添加 技能
     *
     * @param token
     * @param body
     * @return
     */
    @POST("/order/userSkill/reset")
    Observable<SkillResetResponse> AddSkills(@Header("authorization") String token, @Body RequestBody body);

    /**
     * 移除 用户技能
     *
     * @param token
     * @param skillCode
     * @return
     */
    @POST("/order/userSkill/remove")
    Observable<SkillResetResponse> removeSkill(@Header("authorization") String token, @Body RequestBody body);

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
    @POST("order/viewOrderWait/query")
    Observable<ReceiveOrdersResponse> getClientList(@Header("authorization") String token, @Body ReceiveOrdersRequest request);


    //查询可抢单的订单
    @POST("order/viewOrderWait/orderInfo")
    Observable<ReceiveOrderDetailResponse> getReceiveOrderDetail(@Header("authorization") String token, @Body ReceiveOrderDetailRequest request);

    //抢单
    @POST("order/common/worker/bid")
    Observable<RobOrderResponse> robOrder(@Header("authorization") String token, @Body RobOrderRequest request);

}
