package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.Store;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ConditionBody;
import com.osmeet.os.model.net.utils.box.ListContent;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public interface StoreService {

    @GET(Urls.store)
    Observable<Box<Store>> store(
            @Query("id") String id);

    @GET(Urls.store_getStore)
    Observable<Box<List<Store>>> store_getStore();

    @POST(Urls.store_findByCondition)
    Observable<Box<ListContent<Store>>> store_findByCondition(
            @Body ConditionBody body,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @GET(Urls.store_list)
    Observable<Box<ListContent<Store>>> store_list(
            @Query("categoryId") String categoryId,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @GET(Urls.store_listByRegion)
    Observable<Box<ListContent<Store>>> store_listByRegion(
            @Query("categoryId") String categoryId,
            @Query("regionId") String regionId,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);


}
