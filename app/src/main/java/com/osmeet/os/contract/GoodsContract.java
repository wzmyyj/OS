package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 商品。
 */

public interface GoodsContract {

    interface IView extends BaseContract.IView {

        void showGoods(@NonNull Goods goods);
    }

    interface IPresenter extends BaseContract.IPresenter, I.GoodsBuy {

        void loadGoods();

    }

}
