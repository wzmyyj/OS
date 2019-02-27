package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.contract.ic.ITradeInfo;

import java.util.Map;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 * 订单。
 */

public interface TradeContract {

    interface IView extends BaseContract.IView,
            ITradeInfo.V {

        void showResult(@NonNull Map<String, String> result);

    }

    interface IPresenter extends BaseContract.IPresenter,
            ITradeInfo.P {

        void loadPay();

    }

}
