package com.example.com.morecharge.remote;


import com.example.com.morecharge.receive.main.goodsdetail.entry.GoodsDetailResponseEntity;
import com.example.com.morecharge.receive.main.integrate.entity.IntegGoodsListResponse;
import com.example.com.morecharge.receive.main.integrate.entity.MyIntegrateResponseEntry;
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
import retrofit2.http.Path;
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
     */
    @POST("/order/userSkill/reset")
    Observable<SkillResetResponse> AddSkills(@Header("authorization") String token, @Body RequestBody body);

    /**
     * 移除 用户技能
     */
    @POST("/order/userSkill/remove")
    Observable<SkillResetResponse> removeSkill(@Header("authorization") String token, @Body RequestBody body);


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

//    @POST("/common/address/listAddress")
//    Observable<>
}
