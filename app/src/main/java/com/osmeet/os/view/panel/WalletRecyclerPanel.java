package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.annotation.NonNull;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Record;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.WalletContract;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.adapter.ivd.SingleIVD;


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
        ivd.add(new SingleIVD<Record>() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.layout_record_item;
            }

            @Override
            public void convert(ViewHolder holder, Record record, int position) {

            }
        });
    }

    @Override
    protected void update() {

    }

    public void setRecordList(@NonNull List<Record> recordList) {
        mData.clear();
        mData.addAll(recordList);
        notifyDataSetChanged();
    }
}
