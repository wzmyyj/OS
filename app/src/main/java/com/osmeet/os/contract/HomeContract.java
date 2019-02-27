package com.osmeet.os.contract;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.contract.ic.ICategoryList;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public interface HomeContract {

    interface IView extends BaseContract.IView,
            ICategoryList.V {
    }

    interface IPresenter extends BaseContract.IPresenter,
            ICategoryList.P,
            I.Search,
            I.Scan {
    }

}
