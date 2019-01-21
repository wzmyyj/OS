package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Trade;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import java.util.List;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 * 订单列表。
 */

public interface TradeListContract {

    interface IView extends IBaseView {
        void showTradeList(@NonNull List<Trade> tradeList, @NonNull String state);
    }

    interface IPresenter extends IBasePresenter, I.Trade {

        void loadTradeList(@NonNull String state,int pageNum);
    }

}
