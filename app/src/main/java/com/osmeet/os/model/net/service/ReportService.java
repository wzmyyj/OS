package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.Report;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.model.net.utils.box.Box;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public interface ReportService {

    @POST(Urls.report)
    Observable<Box<Report>> report(
            @Body Report report);
}
