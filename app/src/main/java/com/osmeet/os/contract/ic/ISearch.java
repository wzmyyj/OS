package com.osmeet.os.contract.ic;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.User;

import java.util.List;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface ISearch {
    interface V {
        void showSearchUserResult(@NonNull List<User> userList, @NonNull String word, int pageNum);

        void showSearchStoreResult(@NonNull List<Store> storeList, @NonNull String word, int pageNum);
    }

    interface P {
        void searchUser(@NonNull String word, int pageNum);

        void searchStore(@NonNull String word, int pageNum);
    }
}
