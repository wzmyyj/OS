package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.Balance;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.model.net.utils.box.Box;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public interface BalanceService {

    @GET(Urls.balance)
    Observable<Box<Balance>> balance(
    );

    @GET(Urls.balance_getRecord)
    Observable<Box> balance_getRecord(
    );

    @POST(Urls.balance_tx)
    Observable<Box> balance_tx(
    );
}
