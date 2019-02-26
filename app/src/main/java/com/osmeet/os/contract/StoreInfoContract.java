package com.osmeet.os.contract;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.contract.ic.IStoreInfo;
import com.osmeet.os.contract.ic.IStoryList;
import com.osmeet.os.contract.ip.IReport;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 商店。
 */

public interface StoreInfoContract {

    interface IView extends BaseContract.IView,
            IStoryList.V,
            IStoreInfo.V {
    }

    interface IPresenter extends BaseContract.IPresenter,
            IStoryList.P,
            IStoreInfo.P,
            IReport,
            I.ImageLook,
            I.Chat,
            I.SingleMap {
    }

}
