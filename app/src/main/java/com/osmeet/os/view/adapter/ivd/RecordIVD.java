package com.osmeet.os.view.adapter.ivd;

import android.content.Context;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Record;
import com.osmeet.os.base.adapter.BaseIVD;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import top.wzmyyj.wzm_sdk.utils.TimeUtil;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

/**
 * Created by yyj on 2019/01/22.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class RecordIVD extends BaseIVD<Record> {
    public RecordIVD(Context context) {
        super(context);
    }

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
        WidgetUtil.setTextNonNull(tv_record_time, TimeUtil.long2str(record.getCreateDate(), TimeUtil.YYYY_MM_DD_HH_MM));
        if (record.getAfterBalance() - record.getPreviousBalance() > 0) {
            WidgetUtil.setTextPrice(tv_record_change, "+", record.getChangeAmount());
            WidgetUtil.setTextColor(tv_record_change, R.color.colorPay);
        } else {
            WidgetUtil.setTextPrice(tv_record_change, "-", record.getChangeAmount());
            WidgetUtil.setTextColor(tv_record_change, R.color.colorGray_6);
        }
    }
}
