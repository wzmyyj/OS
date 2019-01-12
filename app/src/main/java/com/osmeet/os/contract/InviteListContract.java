package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 广告。
 */

public interface InviteListContract {

    interface IView extends IBaseView {
        void showMatchInviteList(@NonNull List<MatchInvite> matchInviteList);
    }

    interface IPresenter extends IBasePresenter {

        void loadMatchInviteList();
    }

}
