package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.model.BaseModel;
import com.osmeet.os.model.net.service.AttentionService;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class AttentionModel extends BaseModel{

    private AttentionService getService() {
        return ReOk.bind().create(AttentionService.class);
    }

    public void block_get(Observer<Box<ListContent<User>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<User>>> observable = getService().block_get(pageNum, pageSize);
        io2main(observable, observer);
    }

    public void block_post(Observer<Box<String>> observer, String userId) {
        Observable<Box<String>> observable = getService().block_post(userId);
        io2main(observable, observer);
    }

    public void block_del(Observer<Box<String>> observer, String userId) {
        Observable<Box<String>> observable = getService().block_del(userId);
        io2main(observable, observer);
    }

    public void block_me(Observer<Box<ListContent<User>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<User>>> observable = getService().block_me(pageNum, pageSize);
        io2main(observable, observer);
    }


    public void like_get(Observer<Box<ListContent<User>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<User>>> observable = getService().like_get(pageNum, pageSize);
        io2main(observable, observer);
    }

    public void like_post(Observer<Box<String>> observer, String userId) {
        Observable<Box<String>> observable = getService().like_post(userId);
        io2main(observable, observer);
    }

    public void like_del(Observer<Box<String>> observer, String userId) {
        Observable<Box<String>> observable = getService().like_del(userId);
        io2main(observable, observer);
    }

    public void like_me(Observer<Box<ListContent<User>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<User>>> observable = getService().like_me(pageNum, pageSize);
        io2main(observable, observer);
    }

    public void like_eachother(Observer<Box<ListContent<User>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<User>>> observable = getService().like_eachother(pageNum, pageSize);
        io2main(observable, observer);
    }
}