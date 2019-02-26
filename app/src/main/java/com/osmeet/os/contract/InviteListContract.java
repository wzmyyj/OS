package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 广告。
 */

public interface InviteListContract {

    interface IView extends BaseContract.IView {
        void showMatchInviteList(@NonNull List<MatchInvite> matchInviteList);
    }

    interface IPresenter extends BaseContract.IPresenter, I.Store {

        void loadMatchInviteList();
    }

}
