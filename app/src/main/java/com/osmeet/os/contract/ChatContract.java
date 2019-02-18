package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.MatchInvite2;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 聊天。
 */

public interface ChatContract {

    interface IView extends IBaseView {
        void showInviteFriendList(@NonNull List<MatchInvite2> matchInvite2List);
    }

    interface IPresenter extends IBasePresenter, I.ChatInvite, I.MatchBegin {
        void report(@NonNull String content);

        void block();

        void inviteFriends(@NonNull String storeId, @NonNull String userId);

        void matchInvite_friends_accept(@NonNull String matchInviteId);
    }

}
