package com.osmeet.os.view.panel;

import android.content.Context;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.NewFriendsContract;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;

/**
 * Created by yyj on 2019/01/23.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class NewFriendsRecyclerPanel extends BaseRecyclerPanel<User, NewFriendsContract.IPresenter> {
    public NewFriendsRecyclerPanel(Context context, NewFriendsContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<User>> ivd) {

    }

    @Override
    protected void update() {

    }
}
