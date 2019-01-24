package com.osmeet.os.model.net.service;


import com.osmeet.os.app.bean.Friend;
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

public interface FriendService {

    @GET(Urls.friends_get)
    Observable<Box<ListContent<Friend>>> friends_get(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @POST(Urls.friends_add)
    Observable<Box<String>> friends_add(
            @Query("userId") String userId,
            @Query("message") String message);

    @DELETE(Urls.friends_del)
    Observable<Box<String>> friends_del(
            @Query("userId") String userId);

    @POST(Urls.friends_agree)
    Observable<Box<String>> friends_agree(
            @Query("userId") String userId);

    @GET(Urls.friends_block_get)
    Observable<Box<ListContent<User>>> friends_block_get(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @POST(Urls.friends_block_post)
    Observable<Box<String>> friends_block_post(
            @Query("userId") String userId);

    @DELETE(Urls.friends_block_del)
    Observable<Box<String>> friends_block_del(
            @Query("userId") String userId);

    @GET(Urls.friends_block_me)
    Observable<Box<ListContent<User>>> friends_block_me(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @DELETE(Urls.friends_delete)
    Observable<Box<String>> friends_delete(
            @Query("userId") String userId);

    @GET(Urls.friends_friendRS)
    Observable<Box<Friend>> friends_friendRS(
            @Query("userId") String userId);

    @GET(Urls.friends_me)
    Observable<Box<ListContent<Friend>>> friends_me(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @GET(Urls.friends_meNum)
    Observable<Box<Integer>> friends_meNum();

    @GET(Urls.friends_meRead)
    Observable<Box<String>> friends_meRead();

    @GET(Urls.friends_page)
    Observable<Box<ListContent<User>>> friends_page(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @POST(Urls.friends_refuse)
    Observable<Box<String>> friends_refuse(
            @Query("userId") String userId);

}
