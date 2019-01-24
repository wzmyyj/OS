package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 消息。
 */

public interface MessageContract {

    interface IView extends IBaseView {
        void showMatchTeamList(@NonNull List<MatchTeam> matchTeamList);

        void showMatchInviteList(@NonNull List<MatchInvite> matchInviteList);
    }

    interface IPresenter extends IBasePresenter, I.Match,I.InviteList,I.Search,I.Scan {

        void loadMatchTeamList();

        void loadMatchInviteList();

    }

}
