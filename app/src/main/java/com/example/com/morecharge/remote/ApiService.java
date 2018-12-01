package com.example.com.morecharge.remote;


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

}
