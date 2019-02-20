package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public interface BlockListContract {

    interface IView extends IBaseView {

        void showBlockList(@NonNull List<User> userList, int pageNum);

        void showDeleteBlock(@NonNull String userId, boolean isSuccess);
    }

    interface IPresenter extends IBasePresenter, I.UserInfo2 {

        void loadBlockList(int pageNum);

        void deleteBlock(@NonNull String userId);
    }

}
