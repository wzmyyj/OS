package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.Trade;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.model.net.utils.box.Box;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public interface TradeService {

    @POST(Urls.trade_fundToAccount)
    Observable<Box<String>> trade_fundToAccount(
            @Query("_requestData") String _requestData,
            @Query("_timestamp") long _timestamp);

    @POST(Urls.trade_pay)
    Observable<Box<String>> trade_pay(
            @Query("_requestData") String _requestData,
            @Query("_timestamp") long _timestamp);

    @POST(Urls.trade_refund)
    Observable<Box<Trade>> trade_refund(
            @Query("_requestData") String _requestData,
            @Query("_timestamp") long _timestamp);


}
