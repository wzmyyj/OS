package top.wzmyyj.wzm_sdk.adapter;

import android.content.Context;

import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.R;
import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.adapter.ivd.SingleIVD;

/**
 * Created by yyj on 2019/01/22.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public abstract class IvdRecyclerAdapter<T> extends MultiItemTypeAdapter<T> {
    protected final List<IVD<T>> mIVD = new ArrayList<>();
    protected Context context;

    public IvdRecyclerAdapter(Context context, List<T> data) {
        super(context, data);
        this.context = context;
        setIVD(mIVD);
        if (mIVD.size() == 0) {
            defaultIVD();
        }
        for (IVD<T> ivd : mIVD) {
            addItemViewDelegate(ivd);
        }
    }

    protected abstract void setIVD(List<IVD<T>> ivd);

    /**
     * when mIVD.size() is 0, add default IVD. just use look.
     */
    private void defaultIVD() {
        mIVD.add(new SingleIVD<T>() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.layout_default_ivd;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position) {
                holder.setText(R.id.tv_item, "item: " + position);
            }
        });
    }
}