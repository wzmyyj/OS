package com.osmeet.os.view.adapter.ivd;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.app.utils.DistanceUtil;
import com.osmeet.os.base.adapter.BaseIVD;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import top.wzmyyj.wzm_sdk.utils.WidgetUtil;


/**
 * Created by yyj on 2019/01/21.
 *
 * 不用了，要删。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class HomeStoreIVD extends BaseIVD<Store> {
    public HomeStoreIVD(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.layout_home_store_item;
    }

    @Override
    public void convert(ViewHolder holder, Store store, int position) {

        TextView tv_name = holder.getView(R.id.tv_name);
        ImageView img_store_avatar = holder.getView(R.id.img_avatar);
        TextView tv_distance = holder.getView(R.id.tv_distance);
        TextView tv_desc = holder.getView(R.id.tv_desc);

        if (store.getLogoImage() != null)
            G.img(context, store.getLogoImage().getUrl(), img_store_avatar);

        WidgetUtil.setTextNonNull(tv_name, store.getName());
        WidgetUtil.setTextNonNull(tv_desc, store.getIntroduce());
        WidgetUtil.setTextNonNull(tv_distance, DistanceUtil.distance(store.getLat(),store.getLng()));


    }
}
