package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.Code;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.model.net.utils.box.Box;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by yyj on 2019/02/18.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface VersionService {

    @POST(Urls.version_concat)
    Observable<Box<String>> version_code_concat(
            @Body Code code);

    @POST(Urls.version_resolve)
    Observable<Box<Code>> version_code_resolve(
            @Query("info") String info);
}
