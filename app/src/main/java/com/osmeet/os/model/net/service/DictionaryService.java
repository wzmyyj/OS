package com.osmeet.os.model.net.service;

import com.osmeet.os.model.net.utils.Urls;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public interface DictionaryService {

    @GET(Urls.dictionary_errors)
    Observable<String> dictionary_errors();
}
