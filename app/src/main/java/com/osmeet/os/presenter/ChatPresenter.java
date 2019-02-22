package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchInvite2;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.bean.Report;
import com.osmeet.os.app.event.InviteListChangeEvent;
import com.osmeet.os.app.event.TeamListChangeEvent;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.ChatContract;
import com.osmeet.os.model.net.AttentionModel;
import com.osmeet.os.model.net.MatchModel;
import com.osmeet.os.model.net.ReportModel;
import com.osmeet.os.model.net.utils.box.Box;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.tools.Sure;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class ChatPresenter extends BasePresenter<ChatContract.IView> implements ChatContract.IPresenter {

    private MatchModel matchModel;

    public ChatPresenter(Activity activity, ChatContract.IView iv) {
        super(activity, iv);
        matchModel = new MatchModel().bind((AppCompatActivity) activity);
        Sure.sure(activity.getIntent().getData() != null, "Intent Data is null!");
        if (getActivity().getIntent().getData() != null) {
            this.title = getActivity().getIntent().getData().getQueryParameter("title");
            this.userId = getActivity().getIntent().getData().getQueryParameter("targetId");
        }
        Sure.sure(userId != null, "user id is null!");
    }


    @Override
    public void inviteFriends(@NonNull String storeId) {
        List<String> userIdList = new ArrayList<>();
        userIdList.add(userId);
        matchModel.matchInvite_friends(new PObserver<Box<List<MatchInvite2>>>() {
            @Override
            public void onNext(Box<List<MatchInvite2>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showInviteFriendList(box.getData());
                }
            }
        }, storeId, userIdList);
    }

    @Override
    public void matchInvite_friends_accept(@NonNull String matchInviteId) {
        matchModel.matchInvite_friends_accept(new PObserver<Box<MatchTeam>>() {
            @Override
            public void onNext(Box<MatchTeam> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }

                if (box.getData() != null) {
                    EventBus.getDefault().post(new InviteListChangeEvent(true));
                    EventBus.getDefault().post(new TeamListChangeEvent(true));
                    goMatchBegin(new MatchTeam.SimpleMatchTeam(box.getData()));
                    finish();
                }
            }

        }, matchInviteId);
    }

    @Override
    public String getUserId() {
        return this.userId;
    }

    @Override
    public String getTitle() {
        return this.title;
    }


    private String userId;
    private String title;


    @Override
    public void report(@NonNull String content) {
        new ReportModel().report(new PObserver<Box<Report>>() {
            @Override
            public void onNext(Box<Report> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                toast(context.getString(R.string.report_success));
            }
        }, new Report(Report.REPORT_USER, userId, content));
    }

    @Override
    public void block() {
        new AttentionModel().block_post(new PObserver<Box<String>>() {
            @Override
            public void onNext(Box<String> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                toast(context.getString(R.string.block_success));
            }
        }, userId);

    }
}
