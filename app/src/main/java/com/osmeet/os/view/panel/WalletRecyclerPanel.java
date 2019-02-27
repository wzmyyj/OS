package com.osmeet.os.view.panel;

import android.content.Context;

import com.osmeet.os.app.bean.Record;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.WalletContract;
import com.osmeet.os.view.adapter.ivd.RecordIVD;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;


/**
 * Created by yyj on 2019/01/19.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class WalletRecyclerPanel extends BaseRecyclerPanel<Record, WalletContract.IPresenter> {
    public WalletRecyclerPanel(Context context, WalletContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<Record>> ivd) {
        ivd.add(new RecordIVD(context));
    }

    @Override
    protected void update() {
        mPresenter.loadBalanceInfo();
        mPresenter.loadRecordList(0);
    }

}
