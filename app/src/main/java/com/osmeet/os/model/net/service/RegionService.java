package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.Region;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.model.net.utils.box.Box;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public interface RegionService {

    @GET(Urls.region_all)
    Observable<Box<List<Region>>> region_all();

    @GET(Urls.region_city)
    Observable<Box<List<Region>>> region_city();

    @GET(Urls.region_district)
    Observable<Box<List<Region>>> region_district(
            @Query("cityId") String cityId);

    @GET(Urls.region_road)
    Observable<Box<List<Region>>> region_road(
            @Query("districtId") String districtId);
}
