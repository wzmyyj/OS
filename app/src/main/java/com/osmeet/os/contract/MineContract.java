package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 我的。
 */

public interface MineContract {

    interface IView extends IBaseView {
        void showMyInfo(@NonNull User user);

        void showMyStoreList(@NonNull List<Store> storeList);
    }

    interface IPresenter extends IBasePresenter, I.UpdateInfo ,I.Setting{
        void loadMyInfo();

        void freshMyInfo();

        void loadMyStoreList();
    }

}
