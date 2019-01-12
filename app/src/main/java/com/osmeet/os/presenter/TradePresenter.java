package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.TradeContract;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class TradePresenter extends BasePresenter<TradeContract.IView> implements TradeContract.IPresenter {

    public TradePresenter(Activity activity, TradeContract.IView iv) {
        super(activity, iv);
    }
}
