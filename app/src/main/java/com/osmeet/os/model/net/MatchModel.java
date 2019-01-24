package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.app.bean.MatchInvite2;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.bean.MatchUnit;
import com.osmeet.os.app.java.StringUtil;
import com.osmeet.os.app.utils.SubscribeUtil;
import com.osmeet.os.model.net.service.MatchService;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ConditionBody;
import com.osmeet.os.model.net.utils.box.ListContent;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2019/01/02. email: 2209011667@qq.com
 */

public class MatchModel {

    private MatchService getService() {
        return ReOk.bind().create(MatchService.class);
    }

    public void matchUnit(Observer<Box<ListContent<MatchUnit>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<MatchUnit>>> observable = getService().matchUnit(pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void matchUnit_changeMeetTime(Observer<Box<MatchUnit>> observer, String unitId, long wantTime) {
        Observable<Box<MatchUnit>> observable = getService().matchUnit_changeMeetTime(unitId, wantTime);
        SubscribeUtil.io2main(observable, observer);
    }

    public void matchUnit_getMatchsInAllStore(Observer<Box<List<MatchUnit>>> observer, ConditionBody condition) {
        Observable<Box<List<MatchUnit>>> observable = getService().matchUnit_getMatchsInAllStore(condition);
        SubscribeUtil.io2main(observable, observer);
    }

    public void matchUnit_getMatchsInStore(Observer<Box<List<MatchUnit>>> observer, String storeId, ConditionBody condition) {
        Observable<Box<List<MatchUnit>>> observable = getService().matchUnit_getMatchsInStore(storeId, condition);
        SubscribeUtil.io2main(observable, observer);
    }


    public void matchUnit_goToMatchInStore(Observer<Box<MatchUnit>> observer, String storeId) {
        Observable<Box<MatchUnit>> observable = getService().matchUnit_goToMatchInStore(storeId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void matchUnit_quitMatchInStore(Observer<Box<MatchUnit>> observer, String unitId) {
        Observable<Box<MatchUnit>> observable = getService().matchUnit_quitMatchInStore(unitId);
        SubscribeUtil.io2main(observable, observer);
    }

    ////////////////////////////////

    public void matchTeam(Observer<Box<ListContent<MatchTeam>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<MatchTeam>>> observable = getService().matchTeam(pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void matchTeam_going(Observer<Box<ListContent<MatchTeam>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<MatchTeam>>> observable = getService().matchTeam_going(pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void matchTeam_acceptTime(Observer<Box<MatchTeam>> observer, String matchTeamId) {
        Observable<Box<MatchTeam>> observable = getService().matchTeam_acceptTime(matchTeamId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void matchTeam_changeTime(Observer<Box<MatchTeam>> observer, String matchTeamId, long wantTime) {
        Observable<Box<MatchTeam>> observable = getService().matchTeam_changeTime(matchTeamId, wantTime);
        SubscribeUtil.io2main(observable, observer);
    }

    public void matchTeam_quitTeam(Observer<Box<MatchTeam>> observer, String matchTeamId) {
        Observable<Box<MatchTeam>> observable = getService().matchTeam_quitTeam(matchTeamId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void matchTeam_refuseTime(Observer<Box<MatchTeam>> observer, String matchTeamId) {
        Observable<Box<MatchTeam>> observable = getService().matchTeam_refuseTime(matchTeamId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void matchTeam_detail(Observer<Box<MatchTeam>> observer, String matchTeamId) {
        Observable<Box<MatchTeam>> observable = getService().matchTeam_detail(matchTeamId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void matchTeam_finish(Observer<Box<MatchTeam>> observer, String matchTeamId) {
        Observable<Box<MatchTeam>> observable = getService().matchTeam_finish(matchTeamId);
        SubscribeUtil.io2main(observable, observer);
    }

    /////////////////////////////

    public void matchInvite(Observer<Box<MatchInvite>> observer, String storeId, String invitedUnitId) {
        Observable<Box<MatchInvite>> observable = getService().matchInvite(storeId, invitedUnitId);
        SubscribeUtil.io2main(observable, observer);
    }


    public void matchInvite_getBeInvited(Observer<Box<ListContent<MatchInvite>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<MatchInvite>>> observable = getService().matchInvite_getBeInvited(pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void matchInvite_accept(Observer<Box<MatchTeam>> observer, String matchInviteId) {
        Observable<Box<MatchTeam>> observable = getService().matchInvite_accept(matchInviteId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void matchInvite_cancel(Observer<Box<MatchInvite>> observer, String matchInviteId) {
        Observable<Box<MatchInvite>> observable = getService().matchInvite_cancel(matchInviteId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void matchInvite_geBeInvitedByStore(Observer<Box<ListContent<MatchInvite>>> observer, String storeId, int pageNum, int pageSize) {
        Observable<Box<ListContent<MatchInvite>>> observable = getService().matchInvite_getBeInvitedByStore(storeId, pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void matchInvite_getInviteByStore(Observer<Box<ListContent<MatchInvite>>> observer, String storeId, int pageNum, int pageSize) {
        Observable<Box<ListContent<MatchInvite>>> observable = getService().matchInvite_getInviteByStore(storeId, pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void matchInvite_friends(Observer<Box<List<MatchInvite2>>> observer, String storeId, List<String> userIdList) {
        String str = StringUtil.str(userIdList, ",");
        Observable<Box<List<MatchInvite2>>> observable = getService().matchInvite_friends(storeId, str);
        SubscribeUtil.io2main(observable, observer);
    }

    public void matchInvite_friends_accept(Observer<Box<MatchTeam>> observer, String matchInviteId) {
        Observable<Box<MatchTeam>> observable = getService().matchInvite_friends_accept(matchInviteId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void matchInvite_friends_cancel(Observer<Box<MatchInvite2>> observer, String matchInviteId) {
        Observable<Box<MatchInvite2>> observable = getService().matchInvite_friends_cancel(matchInviteId);
        SubscribeUtil.io2main(observable, observer);
    }
}
