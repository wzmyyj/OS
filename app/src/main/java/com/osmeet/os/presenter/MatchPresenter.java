package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.MatchContract;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class MatchPresenter extends BasePresenter<MatchContract.IView> implements MatchContract.IPresenter {

    public MatchPresenter(Activity activity, MatchContract.IView iv) {
        super(activity, iv);
    }

    @Override
    public void loadMatchTeam() {

    }
}
