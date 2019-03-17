package com.osmeet.os.base.model;

import android.arch.lifecycle.LifecycleOwner;

import com.osmeet.os.app.utils.SubscribeUtil;

import java.lang.ref.WeakReference;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2019/02/22.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class BaseModel {


    private WeakReference<LifecycleOwner> lifecycleOwnerWeakReference;


    @SuppressWarnings("unchecked")
    public <T extends BaseModel> T bind(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwnerWeakReference = new WeakReference<>(lifecycleOwner);
        return (T) this;
    }

    protected <T> void io2main(Observable<T> observable, Observer<T> observer) {
        if (this.lifecycleOwnerWeakReference != null && this.lifecycleOwnerWeakReference.get() != null) {
            SubscribeUtil.io2main(observable, observer, this.lifecycleOwnerWeakReference.get());
        } else {
            SubscribeUtil.io2main(observable, observer);
        }
    }

    protected <T> void newThread2main(Observable<T> observable, Observer<T> observer) {
        if (this.lifecycleOwnerWeakReference != null && this.lifecycleOwnerWeakReference.get() != null) {
            SubscribeUtil.newThread2main(observable, observer, this.lifecycleOwnerWeakReference.get());
        } else {
            SubscribeUtil.newThread2main(observable, observer);
        }
    }
}
