package com.osmeet.os.view.adapter;

import android.content.Context;

import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.base.adapter.BaseRecyclerAdapter;
import com.osmeet.os.view.adapter.ivd.MatchTeamIVD;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;

/**
 * Created by yyj on 2019/01/21.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class MatchTeamAdapter extends BaseRecyclerAdapter<MatchTeam> {

    public MatchTeamAdapter(Context context, List<MatchTeam> data) {
        super(context, data);
    }

    @Override
    protected void setIVD(List<IVD<MatchTeam>> ivd) {
        ivd.add(new MatchTeamIVD(context));
    }
}
