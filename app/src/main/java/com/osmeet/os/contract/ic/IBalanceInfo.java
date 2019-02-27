package com.osmeet.os.contract.ic;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Balance;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IBalanceInfo {
    interface V {
        void showBalanceInfo(@NonNull Balance balance);
    }

    interface P {
        void loadBalanceInfo();
    }
}
