package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.MatchInvite2;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 聊天。
 */

public interface ChatContract {

    interface IView extends BaseContract.IView {
        void showInviteFriendList(@NonNull List<MatchInvite2> matchInvite2List);
    }

    interface IPresenter extends BaseContract.IPresenter,
            I.ChatInvite,
            I.MatchBegin {

        void report(@NonNull String content);

        void block();

        void inviteFriends(@NonNull String storeId);

        void matchInvite_friends_accept(@NonNull String matchInviteId);

        String getUserId();

        String getTitle();
    }

}
