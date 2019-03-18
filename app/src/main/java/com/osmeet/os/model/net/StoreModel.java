package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.java.StringUtil;
import com.osmeet.os.base.model.BaseModel;
import com.osmeet.os.model.net.service.StoreService;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class StoreModel extends BaseModel {

    private StoreService getService() {
        return ReOk.bind().create(StoreService.class);
    }

    public void store(Observer<Box<Store>> observer, String id) {
        Observable<Box<Store>> observable = getService().store(id);
        io2main(observable, observer);
    }

    public void store_boss(Observer<Box<List<Store>>> observer) {
        Observable<Box<List<Store>>> observable = getService().store_boss();
        io2main(observable, observer);
    }

    public void store_searchStore(Observer<Box<ListContent<Store>>> observer, String word, int pageNum, int pageSize) {
        Observable<Box<ListContent<Store>>> observable = getService().store_findByCondition(word, pageNum, pageSize);
        io2main(observable, observer);
    }

    public void store_category(Observer<Box<ListContent<Store>>> observer, String categoryId, int pageNum, int pageSize) {
        Observable<Box<ListContent<Store>>> observable = getService().store_category(categoryId, pageNum, pageSize);
        io2main(observable, observer);
    }

    public void store_poi(Observer<Box<List<Store>>> observer, List<String> poiIdList) {
        String poiIds = StringUtil.str(poiIdList, ",");
        Observable<Box<List<Store>>> observable = getService().store_poi(poiIds);
        io2main(observable, observer);
    }

    public void store_region(Observer<Box<ListContent<Store>>> observer, StoreService.Body1 body, int pageNum, int pageSize) {
        Observable<Box<ListContent<Store>>> observable = getService().store_region(body, pageNum, pageSize);
        io2main(observable, observer);
    }
}
