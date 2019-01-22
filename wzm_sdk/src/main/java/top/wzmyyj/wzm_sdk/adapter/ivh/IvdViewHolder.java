package top.wzmyyj.wzm_sdk.adapter.ivh;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.SparseArray;
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

public class IvdViewHolder<T> {
    private VH viewHolder;
    private IVD<T> ivd;

    public IvdViewHolder(@NonNull Context context, @NonNull IVD<T> ivd, @NonNull ViewGroup root, View... views) {
        View view = LayoutInflater.from(context).inflate(ivd.getItemViewLayoutId(), null,
                false);
        root.addView(view);
        this.viewHolder = new VH(context, view);
        this.ivd = ivd;
        for (View v : views) {
            viewHolder.addView(v);
        }
    }

    public ViewHolder getViewHolder() {
        return viewHolder;
    }

    public void convert(T o) {
        ivd.convert(viewHolder, o, 0);
    }

    public static class VH extends ViewHolder {
        private SparseArray<View> mViews2;

        VH(Context context, View itemView) {
            super(context, itemView);
            mViews2 = new SparseArray<>();
        }

        public void addView(View view) {
            mViews2.put(view.getId(), view);
        }

        @Override
        public <T extends View> T getView(int viewId) {
            View view = super.getView(viewId);
            if (view == null) {
                view = mViews2.get(viewId);
            }
            return (T) view;
        }
    }
}
