package top.wzmyyj.wzm_sdk.adapter.ivd;

/**
 * Created by yyj on 2018/04/29.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */


public abstract class SingleIVD<T> implements IVD<T> {
    @Override
    public boolean isForViewType(T item, int position) {
        return true;
    }
}
