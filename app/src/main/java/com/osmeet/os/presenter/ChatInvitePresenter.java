package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.ChatInviteContract;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class ChatInvitePresenter extends BasePresenter<ChatInviteContract.IView> implements ChatInviteContract.IPresenter {

    public ChatInvitePresenter(Activity activity, ChatInviteContract.IView iv) {
        super(activity, iv);
    }
}
