package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.CameraContract;
import com.osmeet.os.presenter.CameraPresenter;

public class CameraActivity extends BaseActivity<CameraContract.IPresenter> implements CameraContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new CameraPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_camera;
    }

}

