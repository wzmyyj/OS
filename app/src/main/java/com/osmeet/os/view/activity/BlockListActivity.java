package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.BlockListContract;
import com.osmeet.os.presenter.BlockListPresenter;

public class BlockListActivity extends BaseActivity<BlockListContract.IPresenter> implements BlockListContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new BlockListPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_block_list;
    }


}

