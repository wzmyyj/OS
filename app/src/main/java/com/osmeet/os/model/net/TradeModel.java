package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.Trade;
import com.osmeet.os.app.utils.SubscribeUtil;
import com.osmeet.os.model.net.service.TradeService;
import com.osmeet.os.model.net.utils.RSA;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import io.reactivex.Observable;
import io.reactivex.Observer;
import top.wzmyyj.wzm_sdk.utils.TimeUtil;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class TradeModel {

    private TradeService getService() {
        return ReOk.bind().create(TradeService.class);
    }

    public void trade_fundToAccount(Observer<Box<String>> observer, String _requestData, long _timestamp) {
        Observable<Box<String>> observable = getService().trade_fundToAccount(_requestData, _timestamp);
        SubscribeUtil.io2main(observable, observer);
    }

    public void trade_pay(Observer<Box<String>> observer, String userId, String tradeId) {
        String requestData = userId + "," + tradeId;
        String _requestData = RSA.encrypt(requestData);
        long _timestamp = TimeUtil.getTime();
        Observable<Box<String>> observable = getService().trade_pay(_requestData, _timestamp);
        SubscribeUtil.io2main(observable, observer);
    }


    public void trade_refund(Observer<Box<Trade>> observer, String _requestData, long _timestamp) {
        Observable<Box<Trade>> observable = getService().trade_refund(_requestData, _timestamp);
        SubscribeUtil.io2main(observable, observer);
    }

    public void trade_getTradePage(Observer<Box<ListContent<Trade>>> observer,
                                   String userId, long time, String state,
                                   int pageNum, int pageSize) {
        String requestData = userId + "," + time + "," + state;
        String _requestData = RSA.encrypt(requestData);
        long _timestamp = TimeUtil.getTime();
        Observable<Box<ListContent<Trade>>> observable = getService().trade_getTradePage(_requestData, _timestamp, pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void trade_exchange(Observer<Box<Trade>> observer) {
        String requestData = "";
        String _requestData = RSA.encrypt(requestData);
        long _timestamp = TimeUtil.getTime();
        Observable<Box<Trade>> observable = getService().trade_exchange(_requestData, _timestamp);
        SubscribeUtil.io2main(observable, observer);
    }

}
