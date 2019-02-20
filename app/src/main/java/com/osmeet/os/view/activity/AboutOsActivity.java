package com.osmeet.os.view.activity;

import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.AboutOsContract;
import com.osmeet.os.presenter.AboutOsPresenter;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

public class AboutOsActivity extends BaseActivity<AboutOsContract.IPresenter> implements AboutOsContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new AboutOsPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_os;
    }

    @OnClick(R.id.img_back)
    void back() {
        mPresenter.finish();
    }

    @BindView(R.id.tv_version)
    TextView tv_version;

    @Override
    protected void initView() {
        super.initView();
        WidgetUtil.setTextNonNull(tv_version, "Ver: " + mPresenter.getVersion());
    }
}

