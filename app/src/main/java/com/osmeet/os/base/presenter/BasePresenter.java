package com.osmeet.os.base.presenter;

import android.app.Activity;
import android.content.Context;

import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import top.wzmyyj.wzm_sdk.tools.L;


/**
 * Created by yyj on 2018/06/28. email: 2209011667@qq.com
 */

public class BasePresenter<V extends IBaseView> implements IBasePresenter {
    protected V mView;
    protected Activity activity;
    protected Context context;

    public BasePresenter(Activity activity, V iv) {
        this.activity = activity;
        this.context = activity;
        this.mView = iv;
    }

    @Override
    public Context getContext() {
        return this.context;
    }

    @Override
    public Activity getActivity() {
        return this.activity;
    }

    @Override
    public void finish() {
        finish(mView.FINISH_DEFAULT);
    }

    @Override
    public void finish(int how) {
        mView.showFinishActivity(how);
    }

    @Override
    public void destroy() {
        this.activity = null;
        this.context = null;
        this.mView = null;
    }


    @Override
    public void log(String msg) {
        L.d(msg);
    }

    @Override
    public void toast(String msg) {
        mView.showToast(msg);
    }


    protected abstract class PObserver<B> implements Observer<B> {
        @Override
        public void onSubscribe(Disposable d) {
            L.d("onSubscribe");
        }

        @Override
        public void onError(Throwable e) {
            onFinish();
            L.e("onError" + e.getMessage());
            mView.showToast("Error:" + e.getMessage());
        }

        @Override
        public void onComplete() {
            L.d("onComplete");
            onFinish();
        }

        protected void onFinish() {
        }


    }


}
