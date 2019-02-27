package com.osmeet.os.contract;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.contract.ic.IMyInfo;
import com.osmeet.os.contract.ic.IMyStoreList;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 我的。
 */

public interface MineContract extends LaunchContract {

    interface IView extends BaseContract.IView,
            IMyInfo.V,
            IMyStoreList.V {

    }

    interface IPresenter extends BaseContract.IPresenter,
            IMyInfo.P,
            IMyStoreList.P,
            I.UpdateInfo,
            I.Setting,
            I.MatchList,
            I.TradeList,
            I.Wallet,
            I.VisitCard,
            I.ImageLook {
    }

}
