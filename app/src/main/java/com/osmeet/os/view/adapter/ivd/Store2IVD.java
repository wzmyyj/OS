package com.osmeet.os.view.adapter.ivd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.adapter.BaseIVD;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import top.wzmyyj.wzm_sdk.utils.DensityUtil;
import top.wzmyyj.wzm_sdk.utils.MockUtil;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;


/**
 * Created by yyj on 2019/01/21.
 *
 * 不用了，要删。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class Store2IVD extends BaseIVD<Store> {
    public Store2IVD(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.layout_xx_store_item;
    }

    @Override
    public void convert(ViewHolder holder, Store store, int position) {
        int w = MockUtil.getScreenWidth(context);
        int m = DensityUtil.dp2px(context, 10);
        View convertView = holder.getConvertView();
        ViewGroup.LayoutParams params = convertView.getLayoutParams();
        params.width = w / 2;
        params.height = (w - 3 * m);
        if ((position & 1) > 0) {// 右边。
            convertView.setPadding(m / 2, 0, m, 0);
        } else {// 左边。
            convertView.setPadding(m, 0, m / 2, 0);
        }
        convertView.setLayoutParams(params);

        ImageView img_bg = holder.getView(R.id.img_bg);
        TextView tv_store_name = holder.getView(R.id.tv_store_name);
        ImageView img_store_avatar = holder.getView(R.id.img_store_avatar);
        TextView tv_store_os_num = holder.getView(R.id.tv_store_os_num);

        if (store.getCoverImage() != null)
            G.img(context, store.getCoverImage().getUrl(), img_bg);

        if (store.getLogoImage() != null)
            G.img(context, store.getLogoImage().getUrl(), img_store_avatar);

        WidgetUtil.setTextNonNull(tv_store_name, store.getName());
        WidgetUtil.setTextNumber(tv_store_os_num, store.getMatchUnitCount());

    }
}
