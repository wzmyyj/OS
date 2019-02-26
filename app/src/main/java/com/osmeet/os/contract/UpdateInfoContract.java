package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.contract.BaseContract;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 编辑个人信息。
 */

public interface UpdateInfoContract {

    interface IView extends BaseContract.IView {
        void showMyInfo(@NonNull User user);
    }

    interface IPresenter extends BaseContract.IPresenter {

        void loadMyInfo();

        void updateMyInfo(@NonNull User user);

        void updateMyAvatar(@NonNull String filePath);

        void updateMyImages(@NonNull String[] imageIds, @NonNull String[] filePaths);
    }

}
