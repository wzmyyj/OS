package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.ScanContract;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class ScanPresenter extends BasePresenter<ScanContract.IView> implements ScanContract.IPresenter {

    public ScanPresenter(Activity activity, ScanContract.IView iv) {
        super(activity, iv);
    }
}
