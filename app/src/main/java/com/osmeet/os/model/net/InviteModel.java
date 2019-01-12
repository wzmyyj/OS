package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.Invite;
import com.osmeet.os.app.bean.Operate;
import com.osmeet.os.model.net.service.InviteService;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.app.utils.SubscribeUtil;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class InviteModel {

    private InviteService getService() {
        return ReOk.bind().create(InviteService.class);
    }

    public void invite_get(Observer<Box<ListContent<Invite>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<Invite>>> observable = getService().invite_get(pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void invite_post(Observer<Box<Invite>> observer, String storeId, String invitedUserId) {
        Observable<Box<Invite>> observable = getService().invite_post(storeId, invitedUserId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void invite_accept(Observer<Box<String>> observer, String inviteId) {
        Observable<Box<String>> observable = getService().invite_accept(inviteId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void invite_accept_friends(Observer<Box<String>> observer, String inviteId) {
        Observable<Box<String>> observable = getService().invite_accept_friends(inviteId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void invite_acceptTime(Observer<Box<String>> observer, String inviteId) {
        Observable<Box<String>> observable = getService().invite_acceptTime(inviteId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void invite_allInviteList(Observer<Box<ListContent<Invite>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<Invite>>> observable = getService().invite_allInviteList(pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void invite_cancel(Observer<Box<String>> observer, String inviteId) {
        Observable<Box<String>> observable = getService().invite_cancel(inviteId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void invite_cancelByUserId(Observer<Box<String>> observer, String userId, String storeId, String mode) {
        Observable<Box<String>> observable = getService().invite_cancelByUserId(userId, storeId, mode);
        SubscribeUtil.io2main(observable, observer);
    }

    public void invite_detail(Observer<Box<Invite>> observer, String inviteId) {
        Observable<Box<Invite>> observable = getService().invite_detail(inviteId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void invite_expectTime(Observer<Box<String>> observer, String inviteId, String datetime) {
        Observable<Box<String>> observable = getService().invite_expectTime(inviteId, datetime);
        SubscribeUtil.io2main(observable, observer);
    }

    public void invite_finish(Observer<Box<String>> observer, String inviteId) {
        Observable<Box<String>> observable = getService().invite_finish(inviteId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void invite_finishedList(Observer<Box<ListContent<Invite>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<Invite>>> observable = getService().invite_finishedList(pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void invite_friends(Observer<Box<List<String>>> observer, String storeId, String friendsId) {
        Observable<Box<List<String>>> observable = getService().invite_friends(storeId, friendsId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void invite_getInvite_friends(Observer<Box<ListContent<Invite>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<Invite>>> observable = getService().invite_getInvite_friends(pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void invite_getInviteByStore(Observer<Box<ListContent<Invite>>> observer, String storeId) {
        Observable<Box<ListContent<Invite>>> observable = getService().invite_getInviteByStore(storeId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void invite_getInviteFromMe_friends(Observer<Box<ListContent<Invite>>> observer, String storeId, int pageNum, int pageSize) {
        Observable<Box<ListContent<Invite>>> observable = getService().invite_getInviteFromMe_friends(storeId, pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void invite_getOperate(Observer<Box<List<Operate>>> observer, String inviteId) {
        Observable<Box<List<Operate>>> observable = getService().invite_getOperate(inviteId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void invite_unfinishedList(Observer<Box<ListContent<Invite>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<Invite>>> observable = getService().invite_unfinishedList(pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }
}
