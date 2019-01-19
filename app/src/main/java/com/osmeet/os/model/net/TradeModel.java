package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.Trade;
import com.osmeet.os.app.java.RSAUtil;
import com.osmeet.os.app.utils.SubscribeUtil;
import com.osmeet.os.app.java.base64.Base64Util;
import com.osmeet.os.model.net.service.TradeService;
import com.osmeet.os.model.net.utils.RSA;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.model.net.utils.box.Box;

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
        String _requestData = null;
        try {
            byte[] bytes = RSAUtil.encryptByRSA(Base64Util.decode(RSA.PUBLIC_KEY), requestData.getBytes());
            _requestData = Base64Util.encode(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long _timestamp = TimeUtil.getTime();
        Observable<Box<String>> observable = getService().trade_pay(_requestData, _timestamp);
        SubscribeUtil.io2main(observable, observer);
    }


    public void trade_refund(Observer<Box<Trade>> observer, String _requestData, long _timestamp) {
        Observable<Box<Trade>> observable = getService().trade_refund(_requestData, _timestamp);
        SubscribeUtil.io2main(observable, observer);
    }
}
