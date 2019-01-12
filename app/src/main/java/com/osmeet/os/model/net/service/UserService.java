package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.RyToken;
import com.osmeet.os.app.bean.Token;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.bean.WechatInfo;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ConditionBody;
import com.osmeet.os.model.net.utils.box.ListContent;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * Created by yyj on 2018/08/02. email: 2209011667@qq.com
 */

public interface UserService {

    @GET(Urls.user)
    Observable<Box<User>> user();

    @POST(Urls.user_bindWechat)
    Observable<Box<User>> user_bindWechat(
            @Body WechatInfo info);

    @POST(Urls.user_consummateInfo)
    Observable<Box<User>> user_consummateInfo(
            @Body User user);//不用了。

    @POST(Urls.user_consummateInfoNoPass)
    Observable<Box<User>> user_consummateInfoNoPass(
            @Body User user);

    @GET(Urls.user_existsByPhone)
    Observable<Box<Boolean>> user_existsByPhone(
            @Query("zoneCode") String zoneCode,
            @Query("phone") String phone);

    @POST(Urls.user_findByCondition)
    Observable<Box<User>> user_findByCondition(
            @Body User user);

    @POST(Urls.user_getRyToken)
    Observable<Box<RyToken>> user_getRyToken();

    @POST(Urls.user_getUserList)
    Observable<Box<List<User>>> user_getUserList(
            @Body ConditionBody body);

    @GET(Urls.user_info)
    Observable<Box<User>> user_info(
            @Query("userId") String userId);

    @POST(Urls.user_login)
    Observable<Box<Token>> user_login(
            @Query("zoneCode") String zoneCode,
            @Query("account") String account,
            @Query("password") String password);

    @POST(Urls.user_loginByPhone)
    Observable<Box<Token>> user_loginByPhone(
            @Query("zoneCode") String zoneCode,
            @Query("phone") String phone,
            @Query("code") String code);

    @POST(Urls.user_loginByThirdParty)
    Observable<Box<Token>> user_loginByThirdParty(
            @Query("id") String id,
            @Query("platform") int platform);

    @POST(Urls.user_refreshToken)
    Observable<Box<Token>> user_refreshToken(
            @Query("refreshToken") String refreshToken);

    @POST(Urls.user_refreshToken)
    Call<Box<Token>> refreshToken(
            @Query("refreshToken") String refreshToken);

    @POST(Urls.user_registerByPhone)
    Observable<Box<Token>> user_registerByPhone(
            @Query("zoneCode") String zoneCode,
            @Query("phone") String phone,
            @Query("code") String code);

    @POST(Urls.user_registerByPhoneAndPass)
    Observable<Box<Token>> user_registerByPhoneAndPass(
            @Query("zoneCode") String zoneCode,
            @Query("phone") String phone,
            @Query("code") String code,
            @Query("password") String password);

    @POST(Urls.user_registerByWechat)
    Observable<Box<Token>> user_registerByWechat(
            @Query("zoneCode") String zoneCode,
            @Query("phone") String phone,
            @Query("code") String code,
            @Body WechatInfo info);

    @POST(Urls.user_searchUser)
    Observable<Box<ListContent<User>>> user_searchUser(
            @Query("searchInfo") String searchInfo,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @POST(Urls.user_sendCode)
    Observable<Box<String>> user_sendCode(
            @Query("zoneCode") String zoneCode,
            @Query("phone") String phone);

    @POST(Urls.user_sendCode0000)
    Observable<Box<String>> user_sendCode0000(
            @Query("zoneCode") String zoneCode,
            @Query("phone") String phone);

    @POST(Urls.user_unbindWechat)
    Observable<Box<User>> user_unbindWechat();

    @POST(Urls.user_update)
    Observable<Box<String>> user_update(
            @Body User user);

    @POST(Urls.user_updateAddress)
    Observable<Box<String>> user_updateAddress(
            @Query("lng") String lng,
            @Query("lat") String lat);

    @POST(Urls.user_updateAvatar)
    Observable<Box<String>> user_updateAvatar(
            @Query("fileId") String fileId);

    @POST(Urls.user_updateDisplayImages)
    Observable<Box<String>> user_updateDisplayImages(
            @Query("fileIds") String fileIds);

    @POST(Urls.user_updatePassword)
    Observable<Box<String>> user_updatePassword(
            @Query("password") String password);

    @POST(Urls.user_updatePhone)
    Observable<Box<String>> user_updatePhone(
            @Query("zoneCode") String zoneCode,
            @Query("phone") String phone);

    @POST(Urls.user_validatePhoneAndCode)
    Observable<Box<String>> user_validatePhoneAndCode(
            @Query("zoneCode") String zoneCode,
            @Query("phone") String phone,
            @Query("code") String code);

}