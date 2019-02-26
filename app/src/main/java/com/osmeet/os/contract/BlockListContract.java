package com.osmeet.os.contract;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.contract.ic.IBlockList;
import com.osmeet.os.contract.ic.IDeleteBlock;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public interface BlockListContract {

    interface IView extends BaseContract.IView,
            IBlockList.V,
            IDeleteBlock.V {

    }

    interface IPresenter extends BaseContract.IPresenter,
            IBlockList.P,
            IDeleteBlock.P,
            I.UserInfo2 {

    }

}
