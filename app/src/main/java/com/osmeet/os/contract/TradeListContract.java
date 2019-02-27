package com.osmeet.os.contract;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.contract.ic.ITradeList;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 * 订单列表。
 */

public interface TradeListContract {

    interface IView extends BaseContract.IView,
            ITradeList.V {
    }

    interface IPresenter extends BaseContract.IPresenter,
            ITradeList.P,
            I.Trade {
    }

}
