package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 商品。
 */

public interface GoodsContract {

    interface IView extends IBaseView {

        void showGoods(@NonNull Goods goods);
    }

    interface IPresenter extends IBasePresenter {

        void loadGoods();

    }

}
