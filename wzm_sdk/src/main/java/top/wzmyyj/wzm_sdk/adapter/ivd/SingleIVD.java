package top.wzmyyj.wzm_sdk.adapter.ivd;

import android.content.Context;

/**
 * Created by yyj on 2018/04/29.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */


public abstract class SingleIVD<T> implements IVD<T> {

    public SingleIVD() {

    }

    protected Context context;

    public SingleIVD(Context context) {
        this.context = context;
    }

    @Override
    public boolean isForViewType(T item, int position) {
        return true;
    }
}
