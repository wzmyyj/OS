package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.TradeListContract;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class TradeListPresenter extends BasePresenter<TradeListContract.IView> implements TradeListContract.IPresenter {

    public TradeListPresenter(Activity activity, TradeListContract.IView iv) {
        super(activity, iv);
    }
}
