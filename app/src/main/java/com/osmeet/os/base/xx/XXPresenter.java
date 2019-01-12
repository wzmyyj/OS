package com.osmeet.os.base.xx;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;


/**
 * Created by yyj on 2018/08/01. email: 2209011667@qq.com
 * 模板。建议把下面的代码复制到File->Settings->Editor->Live Templates中，在"XX"两边加$符号，即"$XX$"。
 * 先写Contract，再写Presenter，最后写Activity,Fragment，Panel。
 */

public class XXPresenter extends BasePresenter<XXContract.IView> implements XXContract.IPresenter {

    public XXPresenter(Activity activity, XXContract.IView iv) {
        super(activity, iv);
    }
}
