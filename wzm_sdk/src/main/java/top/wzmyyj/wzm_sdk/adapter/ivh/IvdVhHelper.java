package top.wzmyyj.wzm_sdk.adapter.ivh;

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
 * 用于显示单个item的view。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class IvdVhHelper<T> {
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

    public ViewHolder getViewHolder() {
        return viewHolder;
    }

    public View getView() {
        return viewHolder.getConvertView();
    }

    public void addIn(@NonNull ViewGroup group) {
        group.addView(viewHolder.getConvertView());
    }

    public void convert(T o) {
        ivd.convert(viewHolder, o, 0);
    }
}
