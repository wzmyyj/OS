package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.MatchListContract;
import com.osmeet.os.model.net.MatchModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class MatchListPresenter extends BasePresenter<MatchListContract.IView> implements MatchListContract.IPresenter {

    private MatchModel matchModel;

    public MatchListPresenter(Activity activity, MatchListContract.IView iv) {
        super(activity, iv);
        matchModel = new MatchModel().bind((AppCompatActivity) activity);
    }

    @Override
    public void loadMatchTeamList(final int pageNum) {
        matchModel.matchTeam(new PObserver<Box<ListContent<MatchTeam>>>() {
            @Override
            public void onNext(Box<ListContent<MatchTeam>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showMatchTeamList(box.getData().getContent(), pageNum);
                }
            }
        }, pageNum, 12);
    }
}
