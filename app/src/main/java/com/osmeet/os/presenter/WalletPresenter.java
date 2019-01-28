package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.osmeet.os.R;
import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.Balance;
import com.osmeet.os.app.bean.Record;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.WalletContract;
import com.osmeet.os.model.net.BalanceModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class WalletPresenter extends BasePresenter<WalletContract.IView> implements WalletContract.IPresenter {

    private BalanceModel balanceModel;

    public WalletPresenter(Activity activity, WalletContract.IView iv) {
        super(activity, iv);
        balanceModel = new BalanceModel();
    }

    @Override
    public void loadBalance() {
        balanceModel.balance(new PObserver<Box<Balance>>() {
            @Override
            public void onNext(Box<Balance> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showBalance(box.getData());
                }
            }
        });
    }

    @Override
    public void loadRecordList(int pageNum) {
        balanceModel.balance_getRecord(new PObserver<Box<ListContent<Record>>>() {
            @Override
            public void onNext(Box<ListContent<Record>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showRecordList(box.getData().getContent());
                }
            }
        }, pageNum, 100);
    }

    @Override
    public void loadTX(@NonNull String account, float amount) {
        balanceModel.balance_tx(new PObserver<Box<String>>() {
            @Override
            public void onNext(Box<String> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                toast(getContext().getString(R.string.tx_success));
                loadBalance();
                loadRecordList(0);
            }
        }, App.getInstance().getMyInfo().getId(), account, amount, 1);
    }
}
