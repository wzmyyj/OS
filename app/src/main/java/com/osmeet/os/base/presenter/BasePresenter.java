package com.osmeet.os.base.presenter;

import android.app.Activity;
import android.content.Context;

import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import java.lang.ref.WeakReference;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import top.wzmyyj.wzm_sdk.tools.L;


/**
 * Created by yyj on 2018/06/28. email: 2209011667@qq.com
 */

public class BasePresenter<V extends IBaseView> implements IBasePresenter {
    protected V mView;
    private WeakReference<Activity> weakActivity;

    public BasePresenter(Activity activity, V iv) {
        this.weakActivity = new WeakReference<>(activity);
        this.mView = iv;
    }

    @Override
    public Context getContext() {
        return weakActivity.get();
    }

    @Override
    public Activity getActivity() {
        return weakActivity.get();
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
        this.weakActivity.clear();
        this.weakActivity = null;
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
            mView.showStart(mView.PROCESS_DEFAULT, "Start!");
        }

        @Override
        public void onError(Throwable e) {
            onFinish();
            mView.showFail(mView.PROCESS_DEFAULT, "Error:" + e.getMessage());
            log("Error:" + e.getMessage());
        }

        @Override
        public void onComplete() {
            onFinish();
            mView.showSuccess(mView.PROCESS_DEFAULT, "Complete!");
        }

        protected void onFinish() {
            mView.showFinish(mView.PROCESS_DEFAULT, "Finish!");
        }


    }


}
