package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

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
    private String storeId;
    private int mode;

    public WalletPresenter(Activity activity, WalletContract.IView iv) {
        super(activity, iv);
        balanceModel = new BalanceModel().bind((AppCompatActivity) activity);
        storeId = activity.getIntent().getStringExtra("storeId");
        if (storeId != null) {
            mode = 1;
        } else {
            mode = 0;
        }
    }


    @Override
    public int getMode() {
        return this.mode;
    }

    @Override
    public void loadBalanceInfo() {
        PObserver<Box<Balance>> pObserver = new PObserver<Box<Balance>>() {
            @Override
            public void onNext(Box<Balance> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showBalanceInfo(box.getData());
                }
            }
        };

        if (mode == 0) {
            balanceModel.balance(pObserver);
        } else {
            balanceModel.balance_store(pObserver, storeId);
        }

    }

    @Override
    public void loadRecordList(int pageNum) {
        PObserver<Box<ListContent<Record>>> pObserver = new PObserver<Box<ListContent<Record>>>() {
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
        };
        if (mode == 0) {
            balanceModel.balance_getRecord(pObserver, pageNum, 100);
        } else {
            balanceModel.balance_store_getRecord(pObserver, storeId, pageNum, 100);
        }

    }

    @Override
    public void loadTX(@NonNull String account, float amount) {
        PObserver<Box<String>> pObserver = new PObserver<Box<String>>() {
            @Override
            public void onNext(Box<String> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                toast(getContext().getString(R.string.tx_success));
                loadBalanceInfo();
                loadRecordList(0);
            }
        };
        if (mode == 0) {
            balanceModel.balance_tx(pObserver, App.getInstance().getMyInfo().getId(), account, amount, 1);
        } else {
            balanceModel.balance_store_tx(pObserver, storeId, account, amount, 1);
        }

    }


}
