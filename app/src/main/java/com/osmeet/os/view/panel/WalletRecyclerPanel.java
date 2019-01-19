package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Record;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.WalletContract;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.adapter.ivd.SingleIVD;
import top.wzmyyj.wzm_sdk.utils.TimeUtil;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;


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
                TextView tv_record_name = holder.getView(R.id.tv_record_name);
                TextView tv_record_time = holder.getView(R.id.tv_record_time);
                TextView tv_record_change = holder.getView(R.id.tv_record_change);
                WidgetUtil.setTextNonNull(tv_record_name, record.getTitle());
                WidgetUtil.setTextNonNull(tv_record_time, TimeUtil.long2str(record.getCreateDate(), "yyyy-MM-dd hh:mm"));
                if (record.getAfterBalance() - record.getPreviousBalance() > 0) {
                    WidgetUtil.setTextPrice(tv_record_change, "+", record.getChangeAmount());
                    WidgetUtil.setTextColor(tv_record_change, R.color.colorPay);
                } else {
                    WidgetUtil.setTextPrice(tv_record_change, "-", record.getChangeAmount());
                    WidgetUtil.setTextColor(tv_record_change, R.color.colorGray_6);
                }
            }
        });
    }

    @Override
    protected void update() {
        mPresenter.loadBalance();
        mPresenter.loadRecordList(0);
    }

    public void setRecordList(@NonNull List<Record> recordList) {
        mData.clear();
        mData.addAll(recordList);
        notifyDataSetChanged();
    }
}
