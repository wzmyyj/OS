package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.AdContract;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class AdPresenter extends BasePresenter<AdContract.IView> implements AdContract.IPresenter {

    public AdPresenter(Activity activity, AdContract.IView iv) {
        super(activity, iv);
    }
}
