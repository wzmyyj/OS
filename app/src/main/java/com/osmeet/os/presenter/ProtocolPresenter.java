package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.ProtocolContract;

/**
 * Created by yyj on 2019/02/18.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class ProtocolPresenter extends BasePresenter<ProtocolContract.IView> implements ProtocolContract.IPresenter {

    public ProtocolPresenter(Activity activity, ProtocolContract.IView iv) {
        super(activity, iv);
    }
}
