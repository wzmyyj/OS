package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public interface AttentionService {

    @GET(Urls.block_get)
    Observable<Box<ListContent<User>>> block_get(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @POST(Urls.block_post)
    Observable<Box<String>> block_post(
            @Query("userId") String userId);

    @DELETE(Urls.block_del)
    Observable<Box<String>> block_del(
            @Query("userId") String userId);

    @GET(Urls.block_me)
    Observable<Box<ListContent<User>>> block_me(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @GET(Urls.like_get)
    Observable<Box<ListContent<User>>> like_get(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @POST(Urls.like_post)
    Observable<Box<String>> like_post(
            @Query("userId") String userId);

    @DELETE(Urls.like_del)
    Observable<Box<String>> like_del(
            @Query("userId") String userId);

    @GET(Urls.like_me)
    Observable<Box<ListContent<User>>> like_me(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @GET(Urls.like_eachother)
    Observable<Box<ListContent<User>>> like_eachother(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

}
