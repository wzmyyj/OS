package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.MatchInvite2;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.contract.ip.IBlock;
import com.osmeet.os.contract.ip.IReport;
import com.osmeet.os.contract.ip.IUserId;

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
            IReport,
            IBlock,
            IUserId,
            I.ChatInvite,
            I.MatchBegin {


        void inviteFriends(@NonNull String storeId);

        void matchInvite_friends_accept(@NonNull String matchInviteId);

        String getTitle();
    }

}
