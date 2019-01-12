package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.GoodsContract;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class GoodsPresenter extends BasePresenter<GoodsContract.IView> implements GoodsContract.IPresenter {

    public GoodsPresenter(Activity activity, GoodsContract.IView iv) {
        super(activity, iv);
    }
}
