package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.Friends;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.model.net.service.FriendsService;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.app.utils.SubscribeUtil;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class FriendsModel {

    private FriendsService getService() {
        return ReOk.bind().create(FriendsService.class);
    }

    public void friends_get(Observer<Box<ListContent<Friends>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<Friends>>> observable = getService().friends_get(pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void friends_post(Observer<Box<String>> observer, String userId, String message) {
        Observable<Box<String>> observable = getService().friends_post(userId, message);
        SubscribeUtil.io2main(observable, observer);
    }

    public void friends_del(Observer<Box<String>> observer, String userId) {
        Observable<Box<String>> observable = getService().friends_del(userId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void friends_agree(Observer<Box<String>> observer, String userId) {
        Observable<Box<String>> observable = getService().friends_agree(userId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void friends_block_get(Observer<Box<ListContent<User>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<User>>> observable = getService().friends_block_get(pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void friends_block_post(Observer<Box<String>> observer, String userId) {
        Observable<Box<String>> observable = getService().friends_block_post(userId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void friends_block_del(Observer<Box<String>> observer, String userId) {
        Observable<Box<String>> observable = getService().friends_block_del(userId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void friends_block_me(Observer<Box<ListContent<User>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<User>>> observable = getService().friends_block_me(pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void friends_delete(Observer<Box<String>> observer, String userId) {
        Observable<Box<String>> observable = getService().friends_delete(userId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void friends_friendRS(Observer<Box<Friends>> observer, String userId) {
        Observable<Box<Friends>> observable = getService().friends_friendRS(userId);
        SubscribeUtil.io2main(observable, observer);
    }


    public void friends_me(Observer<Box<ListContent<User>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<User>>> observable = getService().friends_me(pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void friends_meNum(Observer<Box<Integer>> observer) {
        Observable<Box<Integer>> observable = getService().friends_meNum();
        SubscribeUtil.io2main(observable, observer);
    }

    public void friends_meRead(Observer<Box<String>> observer) {
        Observable<Box<String>> observable = getService().friends_meRead();
        SubscribeUtil.io2main(observable, observer);
    }

    public void friends_page(Observer<Box<ListContent<User>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<User>>> observable = getService().friends_page(pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void friends_refuse(Observer<Box<String>> observer, String userId) {
        Observable<Box<String>> observable = getService().friends_refuse(userId);
        SubscribeUtil.io2main(observable, observer);
    }

}

