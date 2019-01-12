package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.Category;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public interface CategoryService {

    @GET(Urls.category)
    Observable<Box<ListContent<Category>>> category(
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);
}
