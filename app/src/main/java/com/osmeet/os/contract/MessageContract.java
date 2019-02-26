package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 消息。
 */

public interface MessageContract {

    interface IView extends BaseContract.IView {
        void showMatchTeamList(@NonNull List<MatchTeam> matchTeamList);

        void showMatchInviteList(@NonNull List<MatchInvite> matchInviteList);

        void showNewFriendNum(int num);

    }

    interface IPresenter extends BaseContract.IPresenter, I.Match, I.InviteList, I.Search, I.Scan, I.FriendList {

        void loadMatchTeamList();

        void loadMatchInviteList();

        void loadNewFriendNum();
    }

}
