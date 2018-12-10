package com.example.hdd.morecharge.remote;

import com.example.com.morecharge.release.request.OrderBuildPersonRequest;
import com.example.com.morecharge.release.request.OrderBuildProjectRequest;
import com.example.com.morecharge.release.request.OrderCleanupRequest;
import com.example.com.morecharge.release.request.OrderTimeJobRequest;
import com.example.com.morecharge.release.request.OrderWayBuyRequest;
import com.example.com.morecharge.release.request.OrderWayExpressRequest;
import com.example.com.morecharge.release.response.OrderBuildPersonResponse;
import com.example.com.morecharge.release.response.OrderBuildProjectResponse;
import com.example.com.morecharge.release.response.OrderTimeJobResponse;
import com.example.com.morecharge.release.response.OrderWayBuyResponse;
import com.example.com.morecharge.release.response.OrderWayExpressResponse;
import com.example.hdd.morecharge.main.login.response.LoginResponse;
import com.example.hdd.morecharge.main.login.response.RegisterResponse;
import com.example.hdd.morecharge.main.login.response.VerificationCodeResponse;
import com.example.hdd.morecharge.receive.main.goodsdetail.entry.GoodsDetailResponseEntity;
import com.example.hdd.morecharge.receive.main.integrate.entity.IntegGoodsListResponse;
import com.example.hdd.morecharge.receive.main.integrate.entity.MyIntegrateResponseEntry;
import com.example.hdd.morecharge.receive.main.myskills.entity.SkillResetResponse;
import com.example.hdd.morecharge.receive.main.myskills.entity.SkillsResponseEntry;
import com.example.hdd.morecharge.receive.request.ReceiveOrderDetailRequest;
import com.example.hdd.morecharge.receive.request.ReceiveOrdersRequest;
import com.example.hdd.morecharge.receive.request.RobOrderRequest;
import com.example.hdd.morecharge.receive.response.ReceiveOrderDetailResponse;
import com.example.hdd.morecharge.receive.response.ReceiveOrdersResponse;
import com.example.hdd.morecharge.receive.response.RobOrderResponse;
import com.example.hdd.morecharge.usercenter.request.CancelOrderRequest;
import com.example.hdd.morecharge.usercenter.request.CompleteOrderRequest;
import com.example.hdd.morecharge.usercenter.request.MyReceiveOrdersRequest;
import com.example.hdd.morecharge.usercenter.response.CompleteOrderResponse;
import com.example.hdd.morecharge.usercenter.response.MyReceiveOrdersResponse;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;


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
     * @param
     * @return
     */
    @POST("/order/userSkill/remove")
    Observable<SkillResetResponse> removeSkill(@Header("authorization") String token, @Body RequestBody body);

    //登录
    @GET
    Observable<LoginResponse> login(@Url String url, @Query("username") String userName, @Query("password") String password);

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


    /******************************************发单*************************************************/

    //【顺风腿-代购】-雇主-发布订单
    @POST("order/orderWayBuy/add")
    Observable<OrderWayBuyResponse> orderWayBuy(@Header("authorization") String token, @Body OrderWayBuyRequest request);

    //顺风腿-送件】-雇主-发布订单
    @POST("order/orderWayExpress/add")
    Observable<OrderWayExpressResponse> orderWayExpress(@Header("authorization") String token, @Body OrderWayExpressRequest request);

    //【保洁类-所有】-雇主-发布订单
    @POST("order/orderCleanup/add")
    Observable<String> orderCleanup(@Header("authorization") String token, @Body OrderCleanupRequest request);

    //【兼职类-所有】-雇主-发布订单
    @POST("order/orderTimeJob/add")
    Observable<OrderTimeJobResponse> orderTimeJob(@Header("authorization") String token, @Body OrderTimeJobRequest request);

    //【建筑类-包人】-雇主-发布订单
    @POST("order/orderBuildPerson/add")
    Observable<OrderBuildPersonResponse> orderBuildPerson(@Header("authorization") String token, @Body OrderBuildPersonRequest request);

    //【建筑类-包活】-雇主-发布订单
    @POST("order/orderBuildProject/add")
    Observable<OrderBuildProjectResponse> orderBuildProject(@Header("authorization") String token, @Body OrderBuildProjectRequest request);
    //查询可抢单的订单
    @POST("order/viewOrderWait/orderInfo")
    Observable<ReceiveOrderDetailResponse> getReceiveOrderDetail(@Header("authorization") String token, @Body ReceiveOrderDetailRequest request);

    //抢单
    @POST("order/common/worker/bid")
    Observable<RobOrderResponse> robOrder(@Header("authorization") String token, @Body RobOrderRequest request);


    //我的接单列表
    @POST("order/common/worker/query")
    Observable<MyReceiveOrdersResponse> getMyReceiveOrders(@Header("authorization") String token, @Body MyReceiveOrdersRequest request);

    //完成订单
    @POST("order/common/worker/finish")
    Observable<CompleteOrderResponse> completeOrders(@Header("authorization") String token, @Body CompleteOrderRequest request);

    //取消订单
    @POST("order/common/worker/giveUp")
    Observable<CompleteOrderResponse> cancelOrders(@Header("authorization") String token, @Body CancelOrderRequest request);



    /**
     * 获取 个人积分
     */
    @POST("/pay/score/getSelfScore")
    Observable<MyIntegrateResponseEntry> getSelefScore(@Header("authorization") String token);

    /**
     * 获取商品列表
     */
    @POST("/order/goodsInfo/query")
    Observable<IntegGoodsListResponse> getGoodsList(@Header("authorization") String token, @Query("pageNum") int pageNum, @Query("pageSize") int pageSize, @Body RequestBody body);

    /**
     * 获取 商品详情
     */
    @GET("/order/goodsInfo/info/{id}")
    Observable<GoodsDetailResponseEntity> getGoodsInfo(@Header("authorization") String token, @Path("id") String id);
}
