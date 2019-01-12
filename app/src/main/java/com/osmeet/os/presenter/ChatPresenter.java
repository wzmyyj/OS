package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.ChatContract;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class ChatPresenter extends BasePresenter<ChatContract.IView> implements ChatContract.IPresenter {

    public ChatPresenter(Activity activity, ChatContract.IView iv) {
        super(activity, iv);
    }
}
