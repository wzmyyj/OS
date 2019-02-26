package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public interface HomeStoreContract {

    interface IView extends BaseContract.IView {

        void showStoreList(@NonNull List<Store> storeList, int pageNum);
    }

    interface IPresenter extends BaseContract.IPresenter, I.Store {

        void setCategoryId(@NonNull String categoryId);

        String getCategoryId();

        void loadStoreList(final int pageNum);
    }

}
