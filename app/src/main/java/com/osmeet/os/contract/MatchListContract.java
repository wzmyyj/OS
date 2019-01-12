package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 匹配列表。
 */

public interface MatchListContract {

    interface IView extends IBaseView {
        void showMatchTeamList(@NonNull List<MatchTeam> matchTeamList);
    }

    interface IPresenter extends IBasePresenter {
        void loadMatchTeamList();
    }

}
