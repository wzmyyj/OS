package com.osmeet.os.base.presenter;

import android.app.Activity;
import android.content.Context;

import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import top.wzmyyj.wzm_sdk.tools.L;
import top.wzmyyj.wzm_sdk.tools.T;


/**
 * Created by yyj on 2018/06/28. email: 2209011667@qq.com
 */

public class BasePresenter<V extends IBaseView> implements IBasePresenter {
    protected V mView;
    protected Activity mActivity;

    public BasePresenter(Activity activity, V iv) {
        this.mActivity = activity;
        this.mView = iv;
    }

    @Override
    public Context getContext() {
        return mActivity;
    }

    @Override
    public void finish() {
        mActivity.finish();
    }

    @Override
    public void destroy() {
        this.mActivity = null;
        this.mView = null;
    }


    @Override
    public void log(String s) {
        L.d(s);
    }

    @Override
    public void toast(String s) {
        T.s(s);
    }


    protected abstract class PObserver<B> implements Observer<B> {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onError(Throwable e) {
            toast("Error:" + e.getMessage());
            log("Error:" + e.getMessage());
        }

        @Override
        public void onComplete() {

        }

    }


}
