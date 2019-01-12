package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.bean.MatchUnit;
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
 * Created by yyj on 2019/01/02. email: 2209011667@qq.com
 */

public interface MatchService {

    @GET(Urls.matchUnit)
    Observable<Box<ListContent<MatchUnit>>> matchUnit(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize
    );

    @GET(Urls.matchUnit_changeMeetTime)
    Observable<Box<MatchUnit>> matchUnit_changeMeetTime(
            @Query("unitId") String unitId,
            @Query("wantTime") long wantTime);

    @POST(Urls.matchUnit_getMatchsInAllStore)
    Observable<Box<List<MatchUnit>>> matchUnit_getMatchsInAllStore(
            @Body ConditionBody condition);

    @POST(Urls.matchUnit_getMatchsInStore)
    Observable<Box<List<MatchUnit>>> matchUnit_getMatchsInStore(
            @Query("storeId") String storeId,
            @Body ConditionBody condition);

    @GET(Urls.matchUnit_goToMatchInStore)
    Observable<Box<MatchUnit>> matchUnit_goToMatchInStore(
            @Query("storeId") String storeId);


    @GET(Urls.matchUnit_quitMatchInStore)
    Observable<Box<MatchUnit>> matchUnit_quitMatchInStore(
            @Query("unitId") String unitId);


    //  Team

    @GET(Urls.matchTeam)
    Observable<Box<ListContent<MatchTeam>>> matchTeam(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize
    );

    @GET(Urls.matchTeam_going)
    Observable<Box<ListContent<MatchTeam>>> matchTeam_going(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize
    );


    @GET(Urls.matchTeam_acceptTime)
    Observable<Box<MatchTeam>> matchTeam_acceptTime(
            @Query("matchTeamId") String matchTeamId);


    @GET(Urls.matchTeam_changeTime)
    Observable<Box<MatchTeam>> matchTeam_changeTime(
            @Query("matchTeamId") String matchTeamId,
            @Query("wantTime") long wantTime);


    @GET(Urls.matchTeam_quitTeam)
    Observable<Box<MatchTeam>> matchTeam_quitTeam(
            @Query("matchTeamId") String matchTeamId);

    @GET(Urls.matchTeam_refuseTime)
    Observable<Box<MatchTeam>> matchTeam_refuseTime(
            @Query("matchTeamId") String matchTeamId);

    @GET(Urls.matchTeam_detail)
    Observable<Box<MatchTeam>> matchTeam_detail(
            @Query("matchTeamId") String matchTeamId);


    // Invite
    @GET(Urls.matchInvite)
    Observable<Box<MatchInvite>> matchInvite(
            @Query("storeId") String storeId,
            @Query("invitedUnitId") String invitedUnitId);


    @GET(Urls.matchInvite_accept)
    Observable<Box<MatchInvite>> matchInvite_accept(
            @Query("matchInviteId") String matchInviteId);


    @GET(Urls.matchInvite_cancel)
    Observable<Box<MatchInvite>> matchInvite_cancel(
            @Query("matchInviteId") String matchInviteId);

    @GET(Urls.matchInvite_getBeInvited)
    Observable<Box<ListContent<MatchInvite>>> matchInvite_getBeInvited(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize
    );

    @GET(Urls.matchInvite_getBeInvitedByStore)
    Observable<Box<ListContent<MatchInvite>>> matchInvite_getBeInvitedByStore(
            @Query("storeId") String storeId,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @GET(Urls.matchInvite_getInviteByStore)
    Observable<Box<ListContent<MatchInvite>>> matchInvite_getInviteByStore(
            @Query("storeId") String storeId,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);
}
