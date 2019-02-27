package com.osmeet.os.contract;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.contract.ic.ISearch;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 搜索。
 */

public interface SearchContract {

    interface IView extends BaseContract.IView,
            ISearch.V {

    }

    interface IPresenter extends BaseContract.IPresenter,
            ISearch.P,
            I.Store,
            I.UserInfo2 {
    }

}
