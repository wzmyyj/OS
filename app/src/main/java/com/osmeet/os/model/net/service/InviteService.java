package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.Invite;
import com.osmeet.os.app.bean.Operate;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public interface InviteService {

    @GET(Urls.invite_get)
    Observable<Box<ListContent<Invite>>> invite_get(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @POST(Urls.invite_post)
    Observable<Box<Invite>> invite_post(
            @Query("storeId") String storeId,
            @Query("invitedUserId") String invitedUserId);

    @PUT(Urls.invite_accept)
    Observable<Box<String>> invite_accept(
            @Query("inviteId") String inviteId);

    @PUT(Urls.invite_accept_friends)
    Observable<Box<String>> invite_accept_friends(
            @Query("inviteId") String inviteId);

    @PUT(Urls.invite_acceptTime)
    Observable<Box<String>> invite_acceptTime(
            @Query("inviteId") String inviteId);

    @GET(Urls.invite_allInviteList)
    Observable<Box<ListContent<Invite>>> invite_allInviteList(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @PUT(Urls.invite_cancel)
    Observable<Box<String>> invite_cancel(
            @Query("inviteId") String inviteId);

    @PUT(Urls.invite_cancelByUserId)
    Observable<Box<String>> invite_cancelByUserId(
            @Query("userId") String userId,
            @Query("storeId") String storeId,
            @Query("mode") String mode);

    @GET(Urls.invite_detail)
    Observable<Box<Invite>> invite_detail(
            @Query("inviteId") String inviteId);

    @PUT(Urls.invite_expectTime)
    Observable<Box<String>> invite_expectTime(
            @Query("inviteId") String inviteId,
            @Query("datetime") String datetime);

    @PUT(Urls.invite_finish)
    Observable<Box<String>> invite_finish(
            @Query("inviteId") String inviteId);

    @GET(Urls.invite_finishedList)
    Observable<Box<ListContent<Invite>>> invite_finishedList(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @POST(Urls.invite_friends)
    Observable<Box<List<String>>> invite_friends(
            @Query("storeId") String storeId,
            @Query("friendsId") String friendsId);

    @GET(Urls.invite_getInvite_friends)
    Observable<Box<ListContent<Invite>>> invite_getInvite_friends(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @GET(Urls.invite_getInviteByStore)
    Observable<Box<ListContent<Invite>>> invite_getInviteByStore(
            @Query("storeId") String storeId);

    @GET(Urls.invite_getInviteFromMe_friends)
    Observable<Box<ListContent<Invite>>> invite_getInviteFromMe_friends(
            @Query("storeId") String storeId,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @GET(Urls.invite_getOperate)
    Observable<Box<List<Operate>>> invite_getOperate(
            @Query("inviteId") String inviteId);

    @GET(Urls.invite_unfinishedList)
    Observable<Box<ListContent<Invite>>> invite_unfinishedList(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);


}
