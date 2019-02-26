package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 匹配列表。
 */

public interface MatchListContract {

    interface IView extends BaseContract.IView {
        void showMatchTeamList(@NonNull List<MatchTeam> matchTeamList, int pageNum);
    }

    interface IPresenter extends BaseContract.IPresenter , I.Match{
        void loadMatchTeamList(final int pageNum);
    }

}
