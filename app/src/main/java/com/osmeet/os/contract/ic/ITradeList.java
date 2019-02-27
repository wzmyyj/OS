package com.osmeet.os.contract.ic;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Trade;

import java.util.List;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface ITradeList {
    interface V {
        void showTradeList(@NonNull List<Trade> tradeList, @NonNull String state);
    }

    interface P {
        void loadTradeList(@NonNull String state, int pageNum);
    }
}
