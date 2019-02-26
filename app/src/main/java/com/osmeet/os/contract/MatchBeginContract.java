package com.osmeet.os.contract;

import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 相对开始（建立成功）。
 */

public interface MatchBeginContract {

    interface IView extends BaseContract.IView{

    }

    interface IPresenter extends BaseContract.IPresenter, I.Match {

        MatchTeam.SimpleMatchTeam getSimpleMatchTeam();

    }

}
