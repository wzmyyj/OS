package com.osmeet.os.contract;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.contract.ic.IMyInfo;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 主页面。
 */

public interface MainContract {

    interface IView extends BaseContract.IView,
            IMyInfo.V {

    }

    interface IPresenter extends BaseContract.IPresenter,
            IMyInfo.P,
            I.PopInfo {

        void sendLocation(double lng, double lat);
    }

}
