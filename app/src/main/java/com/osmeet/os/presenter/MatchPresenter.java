package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.event.TeamListChangeEvent;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.MatchContract;
import com.osmeet.os.model.net.MatchModel;
import com.osmeet.os.model.net.utils.box.Box;

import org.greenrobot.eventbus.EventBus;

import top.wzmyyj.wzm_sdk.tools.Sure;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class MatchPresenter extends BasePresenter<MatchContract.IView> implements MatchContract.IPresenter {

    private MatchModel matchModel;
    private  String matchId;

    public MatchPresenter(Activity activity, MatchContract.IView iv) {
        super(activity, iv);
        matchModel = new MatchModel().bind((AppCompatActivity) activity);
        matchId = activity.getIntent().getStringExtra("matchId");
        Sure.sure(!TextUtils.isEmpty(matchId),"Match Id is a empty value!");
    }

    @Override
    public void loadMatchTeam() {
        matchModel.matchTeam_detail(new PObserver<Box<MatchTeam>>() {
            @Override
            public void onNext(Box<MatchTeam> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showMatchTeam(box.getData());
                }
            }
        }, matchId);
    }

    @Override
    public void refuseTime() {
        matchModel.matchTeam_refuseTime(new PObserver<Box<MatchTeam>>() {
            @Override
            public void onNext(Box<MatchTeam> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showMatchTeam(box.getData());
                }
            }
        }, matchId);
    }

    @Override
    public void acceptTime() {
        matchModel.matchTeam_acceptTime(new PObserver<Box<MatchTeam>>() {
            @Override
            public void onNext(Box<MatchTeam> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    EventBus.getDefault().post(new TeamListChangeEvent(true));
                    mView.showMatchTeam(box.getData());
                }
            }
        }, matchId);
    }

    @Override
    public void changeTime(long time) {
        matchModel.matchTeam_changeTime(new PObserver<Box<MatchTeam>>() {
            @Override
            public void onNext(Box<MatchTeam> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showMatchTeam(box.getData());
                }
            }
        }, matchId, time);
    }

    @Override
    public void finishMatch() {
        matchModel.matchTeam_finish(new PObserver<Box<MatchTeam>>() {
            @Override
            public void onNext(Box<MatchTeam> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    EventBus.getDefault().post(new TeamListChangeEvent(true));
                    mView.showMatchTeam(box.getData());
                }
            }
        }, matchId);
    }

    @Override
    public void quitMatch() {
        matchModel.matchTeam_quitTeam(new PObserver<Box<MatchTeam>>() {
            @Override
            public void onNext(Box<MatchTeam> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    EventBus.getDefault().post(new TeamListChangeEvent(true));
                    mView.showMatchTeam(box.getData());
                }
            }
        }, matchId);
    }

    @NonNull
    @Override
    public String getMatchId() {
        return this.matchId;
    }
}
