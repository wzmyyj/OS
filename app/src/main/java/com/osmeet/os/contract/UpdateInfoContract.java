package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 编辑个人信息。
 */

public interface UpdateInfoContract {

    interface IView extends IBaseView {
        void showMyInfo(@NonNull User user);
    }

    interface IPresenter extends IBasePresenter {

        void loadMyInfo();

        void updateMyInfo(@NonNull User user);

        void updateMyAvatar(@NonNull String filePath);

        void updateMyImages(@NonNull String[] imageIds, @NonNull String[] filePaths);
    }

}
