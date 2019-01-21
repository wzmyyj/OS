package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.Trade;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.TradeListContract;
import com.osmeet.os.model.net.TradeModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class TradeListPresenter extends BasePresenter<TradeListContract.IView> implements TradeListContract.IPresenter {

    private TradeModel tradeModel;

    public TradeListPresenter(Activity activity, TradeListContract.IView iv) {
        super(activity, iv);
        tradeModel = new TradeModel();
    }

    @Override
    public void loadTradeList(@NonNull final String state, int pageNum) {
        tradeModel.trade_getTradePage(new PObserver<Box<ListContent<Trade>>>() {
            @Override
            public void onNext(Box<ListContent<Trade>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showTradeList(box.getData().getContent(), state);
                }
            }
        }, App.getInstance().getMyInfo().getId(), 0, state, pageNum, 100);
    }
}
