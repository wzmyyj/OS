package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.VisitCardContract;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class VisitCardPresenter extends BasePresenter<VisitCardContract.IView> implements VisitCardContract.IPresenter {

    public VisitCardPresenter(Activity activity, VisitCardContract.IView iv) {
        super(activity, iv);
    }
}
