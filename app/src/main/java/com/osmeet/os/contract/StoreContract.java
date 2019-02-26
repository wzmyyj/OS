package com.osmeet.os.contract;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.contract.ic.IMatchUnitList;
import com.osmeet.os.contract.ic.IStoreInfo;
import com.osmeet.os.contract.ip.IStoreId;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 商店。
 */

public interface StoreContract {

    interface IView extends BaseContract.IView,
            IStoreInfo.V,
            IMatchUnitList.V {

    }

    interface IPresenter extends BaseContract.IPresenter,
            IStoreInfo.P,
            IMatchUnitList.P,
            IStoreId,
            I.MatchBegin,
            I.InviteFriends {

    }

}
