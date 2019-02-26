package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Balance;
import com.osmeet.os.app.bean.Record;
import com.osmeet.os.base.contract.BaseContract;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 钱包。
 */

public interface WalletContract {

    interface IView extends BaseContract.IView {
        void showBalance(@NonNull Balance balance);

        void showRecordList(@NonNull List<Record> recordList);

    }

    interface IPresenter extends BaseContract.IPresenter {

        int getMode();

        void loadBalance();

        void loadRecordList(int pageNum);

        void loadTX(@NonNull String account, float amount);


    }

}
