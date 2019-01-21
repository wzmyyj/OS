package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Trade;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import java.util.Map;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 * 订单。
 */

public interface TradeContract {

    interface IView extends IBaseView {

        void showTrade(@NonNull Trade trade);

        void showResult(@NonNull Map<String, String> result);

    }

    interface IPresenter extends IBasePresenter {

        void loadTrade();

        void loadPay();

    }

}
