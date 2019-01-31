package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 聊天。
 */

public interface ChatContract {

    interface IView extends IBaseView {

    }

    interface IPresenter extends IBasePresenter {
        void report(@NonNull String content);

        void block();
    }

}
