package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.Trade;
import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public interface GoodsService {

    @GET(Urls.goods_get)
    Observable<Box<Goods>> goods_get(
            @Query("id") String id);

    @POST(Urls.goods_post)
    Observable<Box<Goods>> goods_post(
            @Body Goods goods);

    @PUT(Urls.goods_put)
    Observable<Box<Goods>> goods_put(
            @Body Goods goods);

    @POST(Urls.goods_buyGoods)
    Observable<Box<Trade>> goods_buyGoods(
            @Query("goodsId") String goodsId,
            @Query("buyAmount") int buyAmount);

    @GET(Urls.goods_byStoreId)
    Observable<Box<ListContent<Goods>>> goods_byStoreId(
            @Query("storeId") String storeId,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @GET(Urls.goods_getAll)
    Observable<Box<ListContent<Goods>>> goods_getAll(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @GET(Urls.goods_getBE)
    Observable<Box<ListContent<Goods>>> goods_getBE(
            @Query("id") String id,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @GET(Urls.goods_search)
    Observable<Box<ListContent<Goods>>> goods_search(
            @Query("id") String id,
            @Query("name") String name,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

}

