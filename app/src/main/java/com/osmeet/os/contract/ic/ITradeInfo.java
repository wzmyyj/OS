package com.osmeet.os.contract.ic;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Trade;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface ITradeInfo {
    interface V {
        void showTradeInfo(@NonNull Trade trade);
    }

    interface P {
        void loadTradeInfo();
    }
}
