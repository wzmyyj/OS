package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.Trade;
import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.base.model.BaseModel;
import com.osmeet.os.model.net.service.GoodsService;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class GoodsModel extends BaseModel{

    private GoodsService getService() {
        return ReOk.bind().create(GoodsService.class);
    }

    public void goods_get(Observer<Box<Goods>> observer, String id) {
        Observable<Box<Goods>> observable = getService().goods_get(id);
        io2main(observable, observer);
    }

    public void goods_post(Observer<Box<Goods>> observer, Goods goods) {
        Observable<Box<Goods>> observable = getService().goods_post(goods);
        io2main(observable, observer);
    }

    public void goods_put(Observer<Box<Goods>> observer, Goods goods) {
        Observable<Box<Goods>> observable = getService().goods_put(goods);
        io2main(observable, observer);
    }

    public void goods_buyGoods(Observer<Box<Trade>> observer, String goodsId, int buyAmount) {
        Observable<Box<Trade>> observable = getService().goods_buyGoods(goodsId, buyAmount);
        io2main(observable, observer);
    }

    public void goods_byStoreId(Observer<Box<ListContent<Goods>>> observer, String storeId, int pageNum, int pageSize) {
        Observable<Box<ListContent<Goods>>> observable = getService().goods_byStoreId(storeId, pageNum, pageSize);
        io2main(observable, observer);
    }

    public void goods_getAll(Observer<Box<ListContent<Goods>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<Goods>>> observable = getService().goods_getAll(pageNum, pageSize);
        io2main(observable, observer);
    }

    public void goods_getBE(Observer<Box<ListContent<Goods>>> observer, String id, int pageNum, int pageSize) {
        Observable<Box<ListContent<Goods>>> observable = getService().goods_getBE(id, pageNum, pageSize);
        io2main(observable, observer);
    }

    public void goods_search(Observer<Box<ListContent<Goods>>> observer, String id, String name, int pageNum, int pageSize) {
        Observable<Box<ListContent<Goods>>> observable = getService().goods_search(id, name, pageNum, pageSize);
        io2main(observable, observer);
    }
}
