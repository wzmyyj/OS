package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.Friend;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.model.BaseModel;
import com.osmeet.os.model.net.service.FriendService;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class FriendModel extends BaseModel {

    private FriendService getService() {
        return ReOk.bind().create(FriendService.class);
    }

    public void friends_get(Observer<Box<ListContent<Friend>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<Friend>>> observable = getService().friends_get(pageNum, pageSize);
        io2main(observable, observer);
    }

    public void friends_add(Observer<Box<String>> observer, String userId, String message) {
        Observable<Box<String>> observable = getService().friends_add(userId, message);
        io2main(observable, observer);
    }

    public void friends_del(Observer<Box<String>> observer, String userId) {
        Observable<Box<String>> observable = getService().friends_del(userId);
        io2main(observable, observer);
    }

    public void friends_agree(Observer<Box<String>> observer, String userId) {
        Observable<Box<String>> observable = getService().friends_agree(userId);
        io2main(observable, observer);
    }

    public void friends_block_get(Observer<Box<ListContent<User>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<User>>> observable = getService().friends_block_get(pageNum, pageSize);
        io2main(observable, observer);
    }

    public void friends_block_post(Observer<Box<String>> observer, String userId) {
        Observable<Box<String>> observable = getService().friends_block_post(userId);
        io2main(observable, observer);
    }

    public void friends_block_del(Observer<Box<String>> observer, String userId) {
        Observable<Box<String>> observable = getService().friends_block_del(userId);
        io2main(observable, observer);
    }

    public void friends_block_me(Observer<Box<ListContent<User>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<User>>> observable = getService().friends_block_me(pageNum, pageSize);
        io2main(observable, observer);
    }

    public void friends_delete(Observer<Box<String>> observer, String userId) {
        Observable<Box<String>> observable = getService().friends_delete(userId);
        io2main(observable, observer);
    }

    public void friends_friendRS(Observer<Box<Friend>> observer, String userId) {
        Observable<Box<Friend>> observable = getService().friends_friendRS(userId);
        io2main(observable, observer);
    }


    public void friends_me(Observer<Box<ListContent<Friend>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<Friend>>> observable = getService().friends_me(pageNum, pageSize);
        io2main(observable, observer);
    }

    public void friends_meNum(Observer<Box<Integer>> observer) {
        Observable<Box<Integer>> observable = getService().friends_meNum();
        io2main(observable, observer);
    }


    public void friends_page(Observer<Box<ListContent<User>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<User>>> observable = getService().friends_page(pageNum, pageSize);
        io2main(observable, observer);
    }

    public void friends_refuse(Observer<Box<String>> observer, String userId) {
        Observable<Box<String>> observable = getService().friends_refuse(userId);
        io2main(observable, observer);
    }

}

