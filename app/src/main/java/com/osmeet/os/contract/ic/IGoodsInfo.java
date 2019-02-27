package com.osmeet.os.contract.ic;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Goods;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IGoodsInfo {
    interface V {
        void showGoodsInfo(@NonNull Goods goods);
    }

    interface P {
        void loadGoodsInfo();
    }
}
