package com.osmeet.os.view.adapter.ivd;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.adapter.BaseIVD;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import top.wzmyyj.wzm_sdk.utils.WidgetUtil;


/**
 * Created by yyj on 2019/01/24.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class SearchStoreIVD extends BaseIVD<Store> {
    public SearchStoreIVD(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.layout_user_item;
    }

    @Override
    public void convert(ViewHolder holder, Store store, int position) {
        ImageView img_avatar = holder.getView(R.id.img_avatar);
        TextView tv_name = holder.getView(R.id.tv_name);
        TextView tv_desc = holder.getView(R.id.tv_desc);
        if (store.getLogoImage() != null)
            G.img(context, store.getLogoImage().getUrl(), img_avatar);
        WidgetUtil.setTextNonNull(tv_name, store.getName());
        WidgetUtil.setTextNonNull(tv_desc, context.getString(R.string.have)
                + store.getMatchUnitCount()
                + context.getString(R.string.are_meeting_now));
    }
}
