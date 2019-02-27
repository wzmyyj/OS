package com.osmeet.os.contract;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.contract.ic.IStoreList;
import com.osmeet.os.contract.ip.ICategoryId;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public interface HomeStoreContract {

    interface IView extends BaseContract.IView,
            IStoreList.V {
    }

    interface IPresenter extends BaseContract.IPresenter,
            IStoreList.P,
            ICategoryId,
            I.Store {
    }

}
