package top.wzmyyj.wzm_sdk.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wzm on 2018/04/23.
 * <p>
 * Init Fragment.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */


public abstract class InitFragment extends Fragment {

    protected Activity activity;
    protected Context context;
    protected Fragment fragment;
    protected View mVRoot;
    protected LayoutInflater mInflater;

    private String title;

    /**
     * @param title
     * @return this.
     */
    public InitFragment setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        this.activity = (Activity) context;
        this.fragment = this;
    }

    protected boolean isRefreshRootView() {
        return true;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mInflater = inflater;
        if (mVRoot == null) {
            initSome(savedInstanceState);
            initView();
            initData();
            initListener();
            initEvent();
        }
        return mVRoot;
    }

    /**
     * set root view
     */
    protected abstract void setRootView();

    /**
     * do something init.
     *
     * @param savedInstanceState .
     */
    protected void initSome(Bundle savedInstanceState) {
        setRootView();
    }

    /**
     * do something about view.
     */
    protected abstract void initView();

    /**
     * do something about data.
     */
    protected abstract void initData();

    /**
     * do something about listener.
     */
    protected abstract void initListener();

    /**
     * do something about event.
     */
    protected void initEvent() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        context = null;
        activity = null;
        fragment = null;
    }
}
