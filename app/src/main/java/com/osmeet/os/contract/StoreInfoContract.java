package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 商店。
 */

public interface StoreInfoContract {

    interface IView extends IBaseView {
        void showStoreInfo(@NonNull Store store);

        void showGoodsList(@NonNull List<Goods> goodsList);

        void showMatchStore(boolean isInStore);
    }

    interface IPresenter extends IBasePresenter, I.Goods, I.ImageLook, I.Chat, I.SingleMap {

        void loadStoreInfo();

        void loadGoodsList();

        void report(@NonNull String content);

        void intoMatchStore();

        void outMatchStore();

    }

}
