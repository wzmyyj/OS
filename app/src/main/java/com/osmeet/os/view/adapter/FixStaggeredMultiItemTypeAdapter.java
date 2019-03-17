package com.osmeet.os.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.ViewGroup;

import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;


/**
 * Created by yyj on 2019/03/17.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public abstract class FixStaggeredMultiItemTypeAdapter<T> extends MultiItemTypeAdapter<T> {
    public FixStaggeredMultiItemTypeAdapter(Context context, List<T> datas) {
        super(context, datas);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        int position = holder.getLayoutPosition();
        if (isHeaderViewPosition(position) || isFooterViewPosition(position)) {
            ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
            if (null != lp && lp instanceof StaggeredGridLayoutManager.LayoutParams) {
                StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
                p.setFullSpan(true);//占满一行
            }
        }
    }
    protected abstract boolean isHeaderViewPosition(int position);

    protected abstract boolean isFooterViewPosition(int position);

}
