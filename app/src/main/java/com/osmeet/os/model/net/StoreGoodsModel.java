package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.AliPay;
import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.model.net.service.StoreGoodsService;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.app.utils.SubscribeUtil;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class StoreGoodsModel {

    private StoreGoodsService getService() {
        return ReOk.bind().create(StoreGoodsService.class);
    }

    public void store_goods_get(Observer<Box<Goods>> observer, String id) {
        Observable<Box<Goods>> observable = getService().store_goods_get(id);
        SubscribeUtil.io2main(observable, observer);
    }

    public void store_goods_post(Observer<Box<Goods>> observer, Goods goods) {
        Observable<Box<Goods>> observable = getService().store_goods_post(goods);
        SubscribeUtil.io2main(observable, observer);
    }

    public void store_goods_put(Observer<Box<Goods>> observer, Goods goods) {
        Observable<Box<Goods>> observable = getService().store_goods_put(goods);
        SubscribeUtil.io2main(observable, observer);
    }

    public void store_goods_buyGoods(Observer<Box<AliPay>> observer, String goodsId, String buyAmount) {
        Observable<Box<AliPay>> observable = getService().store_goods_buyGoods(goodsId, buyAmount);
        SubscribeUtil.io2main(observable, observer);
    }

    public void store_goods_byStoreId(Observer<Box<ListContent<Goods>>> observer, String storeId, int pageNum, int pageSize) {
        Observable<Box<ListContent<Goods>>> observable = getService().store_goods_byStoreId(storeId, pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void store_goods_getAll(Observer<Box<ListContent<Goods>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<Goods>>> observable = getService().store_goods_getAll(pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void store_goods_getBE(Observer<Box<ListContent<Goods>>> observer, String id, int pageNum, int pageSize) {
        Observable<Box<ListContent<Goods>>> observable = getService().store_goods_getBE(id, pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void store_goods_search(Observer<Box<ListContent<Goods>>> observer, String id, String name, int pageNum, int pageSize) {
        Observable<Box<ListContent<Goods>>> observable = getService().store_goods_search(id, name, pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }
}
