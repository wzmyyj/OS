package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.MatchListContract;
import com.osmeet.os.view.adapter.ivd.MatchTeamIVD;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;

/**
 * Created by yyj on 2019/01/21.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class MatchListRecyclerPanel extends BaseRecyclerPanel<MatchTeam, MatchListContract.IPresenter> {
    public MatchListRecyclerPanel(Context context, MatchListContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<MatchTeam>> ivd) {
        ivd.add(new MatchTeamIVD(context));
    }

    @Override
    protected boolean isEnableLoadMore() {
        return true;
    }

    @Override
    protected void initView() {
        super.initView();
        mRecyclerView.setLayoutManager(new GridLayoutManager(context, 3));
    }

    @Override
    protected void update() {
        mPresenter.loadMatchTeamList(pageNum);
    }


    @Override
    protected void loadMore() {
        super.loadMore();
        mPresenter.loadMatchTeamList(pageNum);
    }

}
