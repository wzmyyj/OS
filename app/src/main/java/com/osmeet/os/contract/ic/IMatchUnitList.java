package com.osmeet.os.contract.ic;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.MatchUnit;

import java.util.List;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IMatchUnitList {
    interface V {
        void showMatchUnitList(@NonNull List<MatchUnit> matchUnitList);
    }

    interface P {
        void loadMatchUnitList();
    }
}
