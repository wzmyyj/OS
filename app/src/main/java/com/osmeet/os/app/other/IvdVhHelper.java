package com.osmeet.os.app.other;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhy.adapter.recyclerview.base.ViewHolder;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;

/**
 * Created by yyj on 2019/01/22.
 * <p>
 * 用于显示单个item的view。主要用于显示。少用。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public  class IvdVhHelper<T> {
    private ViewHolder viewHolder;
    private IVD<T> ivd;

    public IvdVhHelper(@NonNull Context context, @NonNull IVD<T> ivd, @NonNull View view) {
        this.viewHolder = new ViewHolder(context, view);
        this.ivd = ivd;
    }

    public IvdVhHelper(@NonNull Context context, @NonNull IVD<T> ivd) {
        View view = LayoutInflater.from(context).inflate(ivd.getItemViewLayoutId(), null,
                false);
        this.viewHolder = new ViewHolder(context, view);
        this.ivd = ivd;
    }

    /**
     * @return viewHolder.
     */
    public ViewHolder getViewHolder() {
        return viewHolder;
    }

    /**
     * @return ConvertView .
     */
    public View getConvertView() {
        return viewHolder.getConvertView();
    }

    /**
     * @param viewId .
     * @param <V>    .
     * @return view .
     */
    @SuppressWarnings("unchecked")
    public <V extends View> V getView(int viewId) {
        return viewHolder.getView(viewId);
    }

    /**
     * @param group .
     */
    public void addIn(@NonNull ViewGroup group) {
        group.addView(viewHolder.getConvertView());
    }

    /**
     * @param o .
     */
    public void convert(T o) {
        ivd.convert(viewHolder, o, 0);
    }
}
