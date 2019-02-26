package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.application.SettingManager;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 设置。
 */

public interface SettingContract {

    interface IView extends BaseContract.IView {

    }

    interface IPresenter extends BaseContract.IPresenter, I.Login, I.BlockList, I.AboutOs, I.Protocol, I.Account,I.Launch {
        void logout();

        SettingManager getSetting();

        void clearCache();

        String getCacheSize();

        void changeLanguage(int i);

        String getLanguage();

        @NonNull
        List<String> getLanguageList();

        String getAccount();


    }

}
