package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.Balance;
import com.osmeet.os.app.bean.Record;
import com.osmeet.os.app.utils.SubscribeUtil;
import com.osmeet.os.model.net.service.BalanceService;
import com.osmeet.os.model.net.utils.RSA;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import java.text.DecimalFormat;

import io.reactivex.Observable;
import io.reactivex.Observer;
import top.wzmyyj.wzm_sdk.utils.TimeUtil;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class BalanceModel {

    private BalanceService getService() {
        return ReOk.bind().create(BalanceService.class);
    }

    public void balance(Observer<Box<Balance>> observer) {
        Observable<Box<Balance>> observable = getService().balance();
        SubscribeUtil.io2main(observable, observer);
    }

    public void balance_getRecord(Observer<Box<ListContent<Record>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<Record>>> observable = getService().balance_getRecord(pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void balance_tx(Observer<Box<String>> observer, String userId, String account, double amount, int way) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String requestData = userId + "," + account + "," + decimalFormat.format(amount) + "," + way;
        String _requestData = RSA.encrypt(requestData);
        long _timestamp = TimeUtil.getTime();
        Observable<Box<String>> observable = getService().balance_tx(_requestData, _timestamp);
        SubscribeUtil.io2main(observable, observer);
    }
}
