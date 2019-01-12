package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.MatchListContract;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class MatchListPresenter extends BasePresenter<MatchListContract.IView> implements MatchListContract.IPresenter {

    public MatchListPresenter(Activity activity, MatchListContract.IView iv) {
        super(activity, iv);
    }

    @Override
    public void loadMatchTeamList() {

    }
}
