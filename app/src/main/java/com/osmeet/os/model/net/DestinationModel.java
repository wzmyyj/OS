package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.Destination;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.utils.SubscribeUtil;
import com.osmeet.os.model.net.service.DestinationService;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ConditionBody;
import com.osmeet.os.model.net.utils.box.ListContent;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class DestinationModel {

    private DestinationService getService() {
        return ReOk.bind().create(DestinationService.class);
    }

    public void destination_get(Observer<Box<ListContent<Destination>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<Destination>>> observable = getService().destination_get(pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void destination_post(Observer<Box<Destination>> observer, String storeId, int mode) {
        Observable<Box<Destination>> observable = getService().destination_post(storeId, mode);
        SubscribeUtil.io2main(observable, observer);
    }

    public void destination_del(Observer<Box<String>> observer, String storeId) {
        Observable<Box<String>> observable = getService().destination_del(storeId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void destination_findById(Observer<Box<Destination>> observer, String id) {
        Observable<Box<Destination>> observable = getService().destination_findById(id);
        SubscribeUtil.io2main(observable, observer);
    }

    public void destination_mode(Observer<Box<String>> observer, String storeId, int mode) {
        Observable<Box<String>> observable = getService().destination_mode(storeId, mode);
        SubscribeUtil.io2main(observable, observer);
    }

    public void destination_users(Observer<Box<List<User>>> observer, String storeId, ConditionBody body, int pageNum, int pageSize) {
        Observable<Box<List<User>>> observable = getService().destination_users(storeId, body, pageNum, pageNum);
        SubscribeUtil.io2main(observable, observer);
    }

    public void destination_usersPage(Observer<Box<ListContent<User>>> observer, String storeId, ConditionBody body, int pageNum, int pageSize) {
        Observable<Box<ListContent<User>>> observable = getService().destination_usersPage(storeId, body, pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

}
