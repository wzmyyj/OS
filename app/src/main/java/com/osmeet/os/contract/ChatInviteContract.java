package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Store;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 聊天邀请相对。
 */

public interface ChatInviteContract {

    interface IView extends IBaseView {
        void showStoreList(@NonNull List<Store> storeList, int pageNum);
    }

    interface IPresenter extends IBasePresenter {

        void loadStoreList(int pageNum);

    }

}
