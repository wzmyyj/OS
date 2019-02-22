package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.app.bean.Trade;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.GoodsBuyContract;
import com.osmeet.os.model.net.GoodsModel;
import com.osmeet.os.model.net.TradeModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.task.AliPayModel;

import java.util.Map;

import top.wzmyyj.wzm_sdk.tools.Sure;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class GoodsBuyPresenter extends BasePresenter<GoodsBuyContract.IView> implements GoodsBuyContract.IPresenter {

    private TradeModel tradeModel;
    private GoodsModel goodsModel;
    private AliPayModel aliPayModel;

    private Goods.SimpleGoods simpleGoods;

    public GoodsBuyPresenter(Activity activity, GoodsBuyContract.IView iv) {
        super(activity, iv);
        tradeModel = new TradeModel().bind((AppCompatActivity) activity);
        goodsModel = new GoodsModel().bind((AppCompatActivity) activity);
        aliPayModel = new AliPayModel().bind((AppCompatActivity) activity);
        simpleGoods = (Goods.SimpleGoods) getActivity().getIntent().getSerializableExtra("goods");
        Sure.sure(simpleGoods != null, "simpleGoods is null");
    }

    @Override
    public Goods.SimpleGoods getSimpleGoods() {
        return simpleGoods;
    }

    private Trade trade;
    private boolean isBuying = false;

    @Override
    public void buyGoods(@NonNull String goodsId, int count) {
        if (trade != null) {
            trade_pay(trade);
            return;
        }
        if (isBuying) return;
        isBuying = true;
        goodsModel.goods_buyGoods(new PObserver<Box<Trade>>() {
            @Override
            public void onNext(Box<Trade> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    trade = box.getData();
                    trade_pay(trade);
                }
            }

            @Override
            protected void onFinish() {
                super.onFinish();
                isBuying = false;
            }
        }, goodsId, count);
    }

    private void trade_pay(Trade trade) {
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
