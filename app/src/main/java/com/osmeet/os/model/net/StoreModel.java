package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.Store;
import com.osmeet.os.base.model.BaseModel;
import com.osmeet.os.model.net.service.StoreService;
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

public class StoreModel extends BaseModel{

    private StoreService getService() {
        return ReOk.bind().create(StoreService.class);
    }

    public void store(Observer<Box<Store>> observer, String id) {
        Observable<Box<Store>> observable = getService().store(id);
        io2main(observable, observer);
    }

    public void store_getStore(Observer<Box<List<Store>>> observer) {
        Observable<Box<List<Store>>> observable = getService().store_getStore();
        io2main(observable, observer);
    }

    public void store_findByCondition(Observer<Box<ListContent<Store>>> observer, ConditionBody body, int pageNum, int pageSize) {
        Observable<Box<ListContent<Store>>> observable = getService().store_findByCondition(body, pageNum, pageSize);
        io2main(observable, observer);
    }

    public void store_list(Observer<Box<ListContent<Store>>> observer, String categoryId, int pageNum, int pageSize) {
        Observable<Box<ListContent<Store>>> observable = getService().store_list(categoryId, pageNum, pageSize);
        io2main(observable, observer);
    }

    public void store_listByRegion(Observer<Box<ListContent<Store>>> observer, String categoryId, String regionId, int pageNum, int pageSize) {
        Observable<Box<ListContent<Store>>> observable = getService().store_listByRegion(categoryId, regionId, pageNum, pageSize);
        io2main(observable, observer);
    }
}
