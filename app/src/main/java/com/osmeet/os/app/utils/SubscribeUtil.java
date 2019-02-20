package com.osmeet.os.app.utils;


import android.arch.lifecycle.LifecycleOwner;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yyj on 2018/12/03.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class SubscribeUtil {
    /**
     * IO线程 -> 主线程
     *
     * @param observable .
     * @param observer   .
     * @param <T>        .
     */
    public static <T> void io2main(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * IO线程 -> 主线程
     *
     * @param observable     .
     * @param observer       .
     * @param lifecycleOwner .
     * @param <T>            .
     */
    public static <T> void io2main(Observable<T> observable, Observer<T> observer, LifecycleOwner lifecycleOwner) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(lifecycleOwner)))
                .subscribe(observer);
    }


    /**
     * 新线程 -> 主线程
     *
     * @param observable .
     * @param observer   .
     * @param <T>        .
     */
    public static <T> void newThread2main(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 新线程 -> 主线程
     *
     * @param observable     .
     * @param observer       .
     * @param lifecycleOwner .
     * @param <T>            .
     */
    public static <T> void newThread2main(Observable<T> observable, Observer<T> observer, LifecycleOwner lifecycleOwner) {
        observable.subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(lifecycleOwner)))
                .subscribe(observer);
    }
}
