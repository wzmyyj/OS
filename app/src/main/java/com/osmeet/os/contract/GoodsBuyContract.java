package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import java.util.Map;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 购买商品。
 */

public interface GoodsBuyContract {

    interface IView extends IBaseView {
        void showResult(Map<String, String> result);
    }

    interface IPresenter extends IBasePresenter {
        Goods.SimpleGoods getSimpleGoods();

        void buyGoods(@NonNull String goodsId, int count);

    }

}
