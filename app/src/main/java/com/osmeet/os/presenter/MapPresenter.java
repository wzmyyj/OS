package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.MapContract;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class MapPresenter extends BasePresenter<MapContract.IView> implements MapContract.IPresenter {

    public MapPresenter(Activity activity, MapContract.IView iv) {
        super(activity, iv);
    }
}
