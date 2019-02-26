package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.base.contract.BaseContract;

import java.util.Map;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 购买商品。
 */

public interface GoodsBuyContract {

    interface IView extends BaseContract.IView {
        void showResult(@NonNull Map<String, String> result);
    }

    interface IPresenter extends BaseContract.IPresenter {

        Goods.SimpleGoods getSimpleGoods();

        void buyGoods(@NonNull String goodsId, int count);

    }

}
