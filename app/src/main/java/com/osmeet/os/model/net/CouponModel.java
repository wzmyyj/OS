package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.Coupon;
import com.osmeet.os.app.bean.RedPacket;
import com.osmeet.os.base.model.BaseModel;
import com.osmeet.os.model.net.service.CouponService;
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

public class CouponModel extends BaseModel {

    private CouponService getService() {
        return ReOk.bind().create(CouponService.class);
    }

    public void coupon_post(Observer<Box<Coupon>> observer, Coupon coupon) {
        Observable<Box<Coupon>> observable = getService().coupon_post(coupon);
        io2main(observable, observer);
    }

    public void coupon_put(Observer<Box<Coupon>> observer, Coupon coupon) {
        Observable<Box<Coupon>> observable = getService().coupon_put(coupon);
        io2main(observable, observer);
    }

    public void coupon_byStoreId(Observer<Box<ListContent<Coupon>>> observer, String storeId, int pageNum, int pageSize) {
        Observable<Box<ListContent<Coupon>>> observable = getService().coupon_byStoreId(storeId, pageNum, pageSize);
        io2main(observable, observer);
    }


    public void coupon_getRedPacket(Observer<Box<RedPacket>> observer, RedPacket redPacket) {
        Observable<Box<RedPacket>> observable = getService().coupon_getRedPacket(redPacket);
        io2main(observable, observer);
    }

    public void coupon_getUserAllRedPacket(Observer<Box<List<RedPacket>>> observer, String userId) {
        Observable<Box<List<RedPacket>>> observable = getService().coupon_getUserAllRedPacket(userId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void coupon_getUserStoreRedPacket(Observer<Box<List<RedPacket>>> observer, String userId, String storeId) {
        Observable<Box<List<RedPacket>>> observable = getService().coupon_getUserStoreRedPacket(userId, storeId);
        io2main(observable, observer);
    }
}
