package com.osmeet.os.presenter;

import android.app.Activity;
import android.text.TextUtils;

import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.Trade;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.TradeContract;
import com.osmeet.os.model.net.TradeModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.task.AliPayModel;

import java.util.Map;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class TradePresenter extends BasePresenter<TradeContract.IView> implements TradeContract.IPresenter {

    private TradeModel tradeModel;
    private AliPayModel aliPayModel;

    public TradePresenter(Activity activity, TradeContract.IView iv) {
        super(activity, iv);
        tradeModel = new TradeModel();
        aliPayModel=new AliPayModel();
    }

    private Trade trade;

    @Override
    public void loadTrade() {
        String tradeId = getActivity().getIntent().getStringExtra("tradeId");
        if (TextUtils.isEmpty(tradeId)) {
            toast("Trade Id is a empty value!");
            return;
        }

        tradeModel.trade_get(new PObserver<Box<Trade>>() {
            @Override
            public void onNext(Box<Trade> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    trade = box.getData();
                    mView.showTrade(box.getData());
                }
            }
        }, App.getInstance().getMyInfo().getId(), tradeId);

    }

    @Override
    public void loadPay() {
        if (trade == null) return;
        if (!trade.getState().equals(Trade.WAIT_PAY)) {
            toast(trade.getStateDesc());
            return;
        }
        String userId = trade.getUserId();
        String tradeId = trade.getId();
        tradeModel.trade_pay(new PObserver<Box<String>>() {
            @Override
            public void onNext(Box<String> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    pay(box.getData());
                }
            }
        }, userId, tradeId);

    }

    private void pay(String info) {
        aliPayModel.pay(new PObserver<Map<String, String>>() {
            @Override
            public void onNext(Map<String, String> map) {
                if (map != null) {
                    mView.showResult(map);
                }
            }
        }, getActivity(), info);
    }
}
