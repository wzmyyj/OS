package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.contract.ic.IBalanceInfo;
import com.osmeet.os.contract.ic.IRecordList;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 钱包。
 */

public interface WalletContract {

    interface IView extends BaseContract.IView,
            IBalanceInfo.V,
            IRecordList.V {


    }

    interface IPresenter extends BaseContract.IPresenter,
            IBalanceInfo.P,
            IRecordList.P {

        int getMode();

        void loadTX(@NonNull String account, float amount);


    }

}
