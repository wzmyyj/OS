package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.CameraContract;

/**
 * Created by yyj on 2018/12/28. email: 2209011667@qq.com
 */

public class CameraPresenter extends BasePresenter<CameraContract.IView> implements CameraContract.IPresenter {

    public CameraPresenter(Activity activity, CameraContract.IView iv) {
        super(activity, iv);
    }
}
