package com.osmeet.os.contract;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.contract.ic.IGoodsInfo;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 商品。
 */

public interface GoodsContract {

    interface IView extends BaseContract.IView,
            IGoodsInfo.V {
    }

    interface IPresenter extends BaseContract.IPresenter,
            IGoodsInfo.P,
            I.GoodsBuy {
    }

}
