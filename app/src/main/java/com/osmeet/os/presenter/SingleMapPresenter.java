package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.SingleMapContract;

/**
 * Created by yyj on 2019/02/19.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class SingleMapPresenter extends BasePresenter<SingleMapContract.IView> implements SingleMapContract.IPresenter {

    public SingleMapPresenter(Activity activity, SingleMapContract.IView iv) {
        super(activity, iv);
    }
}
