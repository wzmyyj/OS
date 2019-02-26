package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Store;
import com.osmeet.os.base.contract.BaseContract;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 聊天邀请相对。
 */

public interface ChatInviteContract {

    interface IView extends BaseContract.IView {
        void showStoreList(@NonNull List<Store> storeList, int pageNum);
    }

    interface IPresenter extends BaseContract.IPresenter {

        void loadStoreList(int pageNum);

    }

}
