package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.Coupon;
import com.osmeet.os.app.bean.RedPacket;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public interface CouponService {

    @POST(Urls.coupon_post)
    Observable<Box<Coupon>> coupon_post(
            @Body Coupon coupon);

    @PUT(Urls.coupon_put)
    Observable<Box<Coupon>> coupon_put(
            @Body Coupon coupon);

    @GET(Urls.coupon_byStoreId)
    Observable<Box<ListContent<Coupon>>> coupon_byStoreId(
            @Query("storeId") String storeId,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @POST(Urls.coupon_getRedPacket)
    Observable<Box<RedPacket>> coupon_getRedPacket(
            @Body RedPacket redPacket);

    @GET(Urls.coupon_getUserAllRedPacket)
    Observable<Box<List<RedPacket>>> coupon_getUserAllRedPacket(
            @Query("userId") String userId);

    @GET(Urls.coupon_getUserStoreRedPacket)
    Observable<Box<List<RedPacket>>> coupon_getUserStoreRedPacket(
            @Query("userId") String userId,
            @Query("storeId") String storeId);


}
