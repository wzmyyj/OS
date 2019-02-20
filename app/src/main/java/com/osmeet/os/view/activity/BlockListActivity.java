package com.osmeet.os.view.activity;

import android.support.annotation.NonNull;
import android.widget.FrameLayout;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.BlockListContract;
import com.osmeet.os.presenter.BlockListPresenter;
import com.osmeet.os.view.panel.BlockListRecyclerPanel;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class BlockListActivity extends BaseActivity<BlockListContract.IPresenter> implements BlockListContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new BlockListPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_block_list;
    }


    BlockListRecyclerPanel blockListRecyclerPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(
                blockListRecyclerPanel = new BlockListRecyclerPanel(context, mPresenter)
        );
    }

    @OnClick(R.id.img_back)
    void back() {
        mPresenter.finish();
    }

    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;

    @Override
    protected void initView() {
        super.initView();
        fl_panel.addView(getPanelView(0));
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadBlockList(0);
    }

    @Override
    public void showBlockList(@NonNull List<User> userList, int pageNum) {
        blockListRecyclerPanel.setDataList(userList, pageNum);
    }

    @Override
    public void showDeleteBlock(@NonNull String userId, boolean isSuccess) {
        if (isSuccess) {
            blockListRecyclerPanel.removeBlock(userId);
        }
    }
}

