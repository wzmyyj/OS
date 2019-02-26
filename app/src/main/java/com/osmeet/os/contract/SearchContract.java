package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 搜索。
 */

public interface SearchContract {

    interface IView extends BaseContract.IView {

        void showSearchUserResult(@NonNull List<User> userList, @NonNull String word, int pageNum);

        void showSearchStoreResult(@NonNull List<Store> storeList, @NonNull String word, int pageNum);
    }

    interface IPresenter extends BaseContract.IPresenter, I.Store, I.UserInfo2 {
        void searchUser(@NonNull String word, int pageNum);

        void searchStore(@NonNull String word, int pageNum);
    }

}
