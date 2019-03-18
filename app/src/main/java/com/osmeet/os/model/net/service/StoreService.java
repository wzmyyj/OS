package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.Store;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public interface StoreService {

    @GET(Urls.store)
    Observable<Box<Store>> store(
            @Query("id") String id);

    @GET(Urls.store_boss)
    Observable<Box<List<Store>>> store_boss();

    @POST(Urls.store_findByCondition)
    Observable<Box<ListContent<Store>>> store_findByCondition(
            @Query("condition") String condition,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @GET(Urls.store_category)
    Observable<Box<ListContent<Store>>> store_category(
            @Query("categoryId") String categoryId,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @GET(Urls.store_poi)
    Observable<Box<List<Store>>> store_poi(
            @Query("poiIds") String poiIds);

    @GET(Urls.store_region)
    Observable<Box<ListContent<Store>>> store_region(
            @Body Body1 body,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);


    class Body1 {

        private String categoryId;
        private int highLat;
        private int highLng;
        private int lowLat;
        private int lowLng;

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setHighLat(int highLat) {
            this.highLat = highLat;
        }

        public int getHighLat() {
            return highLat;
        }

        public void setHighLng(int highLng) {
            this.highLng = highLng;
        }

        public int getHighLng() {
            return highLng;
        }

        public void setLowLat(int lowLat) {
            this.lowLat = lowLat;
        }

        public int getLowLat() {
            return lowLat;
        }

        public void setLowLng(int lowLng) {
            this.lowLng = lowLng;
        }

        public int getLowLng() {
            return lowLng;
        }

    }
}
