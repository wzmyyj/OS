package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.GuideContract;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class GuidePresenter extends BasePresenter<GuideContract.IView> implements GuideContract.IPresenter {

    public GuidePresenter(Activity activity, GuideContract.IView iv) {
        super(activity, iv);
    }

}
