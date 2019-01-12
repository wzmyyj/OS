package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.Destination;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ConditionBody;
import com.osmeet.os.model.net.utils.box.ListContent;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public interface DestinationService {

    @GET(Urls.destination_get)
    Observable<Box<ListContent<Destination>>> destination_get(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @POST(Urls.destination_post)
    Observable<Box<Destination>> destination_post(
            @Query("storeId") String storeId,
            @Query("mode") int mode);

    @DELETE(Urls.destination_del)
    Observable<Box<String>> destination_del(
            @Query("storeId") String storeId);

    @GET(Urls.destination_findById)
    Observable<Box<Destination>> destination_findById(
            @Query("id") String id);

    @POST(Urls.destination_mode)
    Observable<Box<String>> destination_mode(
            @Query("storeId") String storeId,
            @Query("mode") int mode);

    @POST(Urls.destination_users)
    Observable<Box<List<User>>> destination_users(
            @Query("storeId") String storeId,
            @Body ConditionBody body,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @POST(Urls.destination_usersPage)
    Observable<Box<ListContent<User>>> destination_usersPage(
            @Query("storeId") String storeId,
            @Body ConditionBody body,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);
}
