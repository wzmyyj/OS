package com.osmeet.os.model.task;

import android.app.Activity;

import com.alipay.sdk.app.PayTask;
import com.osmeet.os.app.utils.SubscribeUtil;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2019/01/17. email: 2209011667@qq.com
 */

public class AliPayModel {
    public void pay(Observer<Map<String, String>> observer, final Activity activity, final String info) {
        Observable<Map<String, String>> observable = Observable.create(emitter -> {
            PayTask payTask = new PayTask(activity);
            Map<String, String> result = payTask.payV2(info, true);
            emitter.onNext(result);
        });
        SubscribeUtil.newThread2main(observable, observer);
    }
}
