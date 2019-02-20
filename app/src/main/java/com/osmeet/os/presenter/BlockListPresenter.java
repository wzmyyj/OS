package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.BlockListContract;
import com.osmeet.os.model.net.AttentionModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

/**
 * Created by yyj on 2019/02/18.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class BlockListPresenter extends BasePresenter<BlockListContract.IView> implements BlockListContract.IPresenter {

    private AttentionModel attentionModel;

    public BlockListPresenter(Activity activity, BlockListContract.IView iv) {
        super(activity, iv);
        attentionModel = new AttentionModel();
    }

    @Override
    public void loadBlockList(final int pageNum) {
        attentionModel.block_get(new PObserver<Box<ListContent<User>>>() {
            @Override
            public void onNext(Box<ListContent<User>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showBlockList(box.getData().getContent(), pageNum);
                }
            }
        }, pageNum, 20);
    }

    @Override
    public void deleteBlock(@NonNull final String userId) {
        attentionModel.block_del(new PObserver<Box<String>>() {
            @Override
            public void onNext(Box<String> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                mView.showDeleteBlock(userId, true);
            }
        }, userId);
    }
}
