package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Balance;
import com.osmeet.os.app.bean.Record;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 钱包。
 */

public interface WalletContract {

    interface IView extends IBaseView {
        void showBalance(@NonNull Balance balance);

        void showRecordList(@NonNull List<Record> recordList);

    }

    interface IPresenter extends IBasePresenter {
        void loadBalance();

        void loadRecordList(int pageNum);

        void loadTX(@NonNull String account, float amount);
    }

}
