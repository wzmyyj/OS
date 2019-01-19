package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.Balance;
import com.osmeet.os.app.bean.Record;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public interface BalanceService {

    @GET(Urls.balance)
    Observable<Box<Balance>> balance();

    @GET(Urls.balance_getRecord)
    Observable<Box<ListContent<Record>>> balance_getRecord(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @POST(Urls.balance_tx)
    Observable<Box<String>> balance_tx(
            @Query("_requestData") String _requestData,
            @Query("_timestamp") long _timestamp);
}
