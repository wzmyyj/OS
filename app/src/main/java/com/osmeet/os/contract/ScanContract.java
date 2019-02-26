package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 扫码。
 */

public interface ScanContract {

    interface IView extends BaseContract.IView {

    }

    interface IPresenter extends BaseContract.IPresenter, I.UserInfo2,I.Store,I.Trade{

        void loadCode(@NonNull String qrCode);
    }

}
