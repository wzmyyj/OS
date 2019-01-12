package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 完善信息。
 */

public interface PopInfoContract {

    interface IView extends IBaseView {

    }

    interface IPresenter extends IBasePresenter, I.Main {
        void consummateMyInfo(@NonNull User user);

        void consummateMyAvatar(@NonNull String filePath);
    }

}
