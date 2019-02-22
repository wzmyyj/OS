package com.osmeet.os.base.model;

import android.arch.lifecycle.LifecycleOwner;

import com.osmeet.os.app.utils.SubscribeUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2019/02/22.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class BaseModel {


    private LifecycleOwner lifecycleOwner;

    public BaseModel() {
    }

    public  <T extends BaseModel> T bind(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
        return (T) this;
    }

    protected <T> void io2main(Observable<T> observable, Observer<T> observer) {
        if (this.lifecycleOwner != null) {
            SubscribeUtil.io2main(observable, observer, this.lifecycleOwner);
        } else {
            SubscribeUtil.io2main(observable, observer);
        }
    }

    protected <T> void newThread2main(Observable<T> observable, Observer<T> observer) {
        if (this.lifecycleOwner != null) {
            SubscribeUtil.newThread2main(observable, observer, this.lifecycleOwner);
        } else {
            SubscribeUtil.newThread2main(observable, observer);
        }
    }
}
