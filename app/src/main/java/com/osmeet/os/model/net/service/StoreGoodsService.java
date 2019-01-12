package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.AliPay;
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

public interface StoreGoodsService {

    @GET(Urls.store_goods_get)
    Observable<Box<Goods>> store_goods_get(
            @Query("id") String id);

    @POST(Urls.store_goods_post)
    Observable<Box<Goods>> store_goods_post(
            @Body Goods goods);

    @PUT(Urls.store_goods_put)
    Observable<Box<Goods>> store_goods_put(
            @Body Goods goods);

    @POST(Urls.store_goods_buyGoods)
    Observable<Box<AliPay>> store_goods_buyGoods(
            @Query("goodsId") String goodsId,
            @Query("buyAmount") String buyAmount);

    @GET(Urls.store_goods_byStoreId)
    Observable<Box<ListContent<Goods>>> store_goods_byStoreId(
            @Query("storeId") String storeId,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @GET(Urls.store_goods_getAll)
    Observable<Box<ListContent<Goods>>> store_goods_getAll(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @GET(Urls.store_goods_getBE)
    Observable<Box<ListContent<Goods>>> store_goods_getBE(
            @Query("id") String id,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @GET(Urls.store_goods_search)
    Observable<Box<ListContent<Goods>>> store_goods_search(
            @Query("id") String id,
            @Query("name") String name,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

}

