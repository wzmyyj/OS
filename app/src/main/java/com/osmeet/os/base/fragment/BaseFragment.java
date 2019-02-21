package com.osmeet.os.base.fragment;

import android.os.Bundle;

import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import butterknife.ButterKnife;
import top.wzmyyj.wzm_sdk.fragment.PanelFragment;
import top.wzmyyj.wzm_sdk.tools.T;


/**
 * Created by yyj on 2018/06/28. email: 2209011667@qq.com
 */

public abstract class BaseFragment<P extends IBasePresenter> extends PanelFragment implements IBaseView {
    protected P mPresenter;



    @Override
    protected void initSome(Bundle savedInstanceState) {
        initPresenter();
        checkPresenterIsNull();
        super.initSome(savedInstanceState);
    }

    protected abstract void initPresenter();

    public P getPresenter() {
        return mPresenter;
    }

    private void checkPresenterIsNull() {
        if (mPresenter == null) {
            throw new IllegalStateException("please init mPresenter in initPresenter() method ");
        }
    }

    protected abstract int getLayoutId();

    @Override
    protected void setRootView() {
        mVRoot = mInflater.inflate(getLayoutId(), null);
        ButterKnife.bind(this, mVRoot);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }


    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.destroy();
        mPresenter = null;
    }

    @Override
    public void showToast(String msg) {
        T.s(msg);
    }


    @Override
    public void showFinishActivity(int how) {
        if (getActivity() == null) return;
        getActivity().finish();
        if (how == IBaseView.FINISH_FADE_IN_OUT) {
            getActivity().overridePendingTransition(android.R.anim.fade_in,
                    android.R.anim.fade_out);
        }

    }
}
