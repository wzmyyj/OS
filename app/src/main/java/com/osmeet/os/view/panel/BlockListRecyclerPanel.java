package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kongzue.dialog.v2.BottomMenu;
import com.kongzue.dialog.v2.SelectDialog;
import com.osmeet.os.R;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.BlockListContract;
import com.osmeet.os.view.adapter.ivd.SingleUserIVD;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;


/**
 * Created by yyj on 2019/02/20.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class BlockListRecyclerPanel extends BaseRecyclerPanel<User, BlockListContract.IPresenter> {
    public BlockListRecyclerPanel(Context context, BlockListContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<User>> ivd) {
        ivd.add(new SingleUserIVD(context));
    }

    @Override
    protected void update() {
        mPresenter.loadBlockList(0);
    }

    @Override
    protected void loadMore() {
        super.loadMore();
        mPresenter.loadBlockList(nextPageNum());
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        super.onItemClick(view, holder, position);
        mPresenter.goUserInfo2(mData.get(position).getId());
    }

    @Override
    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
        this.mDeleteIndex = position;
        menu();
        return true;
    }

    private int mDeleteIndex = -1;

    protected void menu() {
        List<String> list = new ArrayList<>();
        list.add(context.getString(R.string.delete));
        BottomMenu.show((AppCompatActivity) context, list, (text, index) -> {
                    switch (index) {
                        case 0:
                            dialog();
                            break;
                    }
                }, true, context.getString(R.string.cancel)
        ).setTitle(context.getString(R.string.please_choose));
    }

    private void dialog() {
        SelectDialog.show(context, context.getString(R.string.warm),
                context.getString(R.string.remove_block),
                context.getString(R.string.ok), (dialog, which) ->
                        mPresenter.deleteBlock(mData.get(mDeleteIndex).getId()),
                context.getString(R.string.cancel), (dialog, which) -> {
                });
    }


    public void removeBlock(@NonNull String userId) {
        for (User user : mData) {
            if (user.getId().equals(userId)) {
                mData.remove(user);
                break;
            }
        }
        notifyDataSetChanged();
    }
}
