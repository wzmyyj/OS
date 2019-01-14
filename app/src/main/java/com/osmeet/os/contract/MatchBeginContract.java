package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 相对开始（建立成功）。
 */

public interface MatchBeginContract {

    interface IView extends IBaseView {
        void showMatchTeam(@NonNull MatchTeam matchTeam);
    }

    interface IPresenter extends IBasePresenter, I.Match {

        String getMatchTeamId();

        void getMatchTeam();
    }

}
