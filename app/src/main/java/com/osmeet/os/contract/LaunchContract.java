package com.osmeet.os.contract;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 起始页，欢迎页。
 */

public interface LaunchContract {

    interface IView extends BaseContract.IView {

    }

    interface IPresenter extends BaseContract.IPresenter, I.Ad, I.Guide, I.Login,I.PopInfo,I.Main {
        void checkPermission();

        void init();

        void go();
    }

}
