package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.MatchUnit;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 商店。
 */

public interface StoreContract {

    interface IView extends IBaseView {
        void showStoreInfo(@NonNull Store store);

        void showMatchUnitList(@NonNull List<MatchUnit> matchUnitList);
    }

    interface IPresenter extends IBasePresenter {

        void loadStoreInfo();

        void loadMatchUnitList();
    }

}
