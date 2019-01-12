package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.GoodsBuyContract;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class GoodsBuyPresenter extends BasePresenter<GoodsBuyContract.IView> implements GoodsBuyContract.IPresenter {

    public GoodsBuyPresenter(Activity activity, GoodsBuyContract.IView iv) {
        super(activity, iv);
    }
}
