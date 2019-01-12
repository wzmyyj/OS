package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Store;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 商店。
 */

public interface StoreInfoContract {

    interface IView extends IBaseView {
        void showStoreInfo(@NonNull Store store);
    }

    interface IPresenter extends IBasePresenter {
        String getStoreId();

        void loadStoreInfo();


    }

}
