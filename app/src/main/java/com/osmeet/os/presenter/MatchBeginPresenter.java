package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.MatchBeginContract;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class MatchBeginPresenter extends BasePresenter<MatchBeginContract.IView> implements MatchBeginContract.IPresenter {

    public MatchBeginPresenter(Activity activity, MatchBeginContract.IView iv) {
        super(activity, iv);
    }


    @Override
    public MatchTeam.SimpleMatchTeam getSimpleMatchTeam() {
        return (MatchTeam.SimpleMatchTeam) getActivity().getIntent().getSerializableExtra("mt");
    }
}
