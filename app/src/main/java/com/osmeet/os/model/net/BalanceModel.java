package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.Balance;
import com.osmeet.os.app.bean.Record;
import com.osmeet.os.base.model.BaseModel;
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

public class BalanceModel extends BaseModel {

    private BalanceService getService() {
        return ReOk.bind().create(BalanceService.class);
    }

    public void user_balance(Observer<Box<Balance>> observer) {
        Observable<Box<Balance>> observable = getService().user_balance();
        io2main(observable, observer);
    }

    public void user_balance_getRecord(Observer<Box<ListContent<Record>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<Record>>> observable = getService().user_balance_getRecord(pageNum, pageSize);
        io2main(observable, observer);
    }

    public void user_balance_tx(Observer<Box<String>> observer, String userId, String account, double amount, int way) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String requestData = userId + "," + account + "," + decimalFormat.format(amount) + "," + way;
        String _requestData = RSA.encrypt(requestData);
        long _timestamp = TimeUtil.getTime();
        Observable<Box<String>> observable = getService().trade_tx(_requestData, _timestamp);
        io2main(observable, observer);
    }
}
