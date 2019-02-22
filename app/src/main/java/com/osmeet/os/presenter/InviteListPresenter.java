package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.InviteListContract;
import com.osmeet.os.model.net.MatchModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class InviteListPresenter extends BasePresenter<InviteListContract.IView> implements InviteListContract.IPresenter {

    private MatchModel matchModel;

    public InviteListPresenter(Activity activity, InviteListContract.IView iv) {
        super(activity, iv);
        matchModel = new MatchModel().bind((AppCompatActivity) activity);
    }

    @Override
    public void loadMatchInviteList() {
        matchModel.matchInvite_getBeInvited(new PObserver<Box<ListContent<MatchInvite>>>() {
            @Override
            public void onNext(Box<ListContent<MatchInvite>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showMatchInviteList(box.getData().getContent());
                }
            }

        }, 0, 100);
    }
}