package com.osmeet.os.view.adapter;

import android.content.Context;
import android.view.View;

import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.base.adapter.BaseIvdAdapter;
import com.osmeet.os.view.adapter.ivd.MatchTeamIVD;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.utils.DensityUtil;

/**
 * Created by yyj on 2019/01/21.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class MatchTeamAdapter extends BaseIvdAdapter<MatchTeam> {

    public MatchTeamAdapter(Context context, List<MatchTeam> data) {
        super(context, data);
    }

    @Override
    protected void setIVD(List<IVD<MatchTeam>> ivd) {
        ivd.add(new MatchTeamIVD(context) {
            @Override
            public void convert(ViewHolder holder, MatchTeam matchTeam, int position) {
                super.convert(holder, matchTeam, position);
                View v = holder.getConvertView();
                v.getLayoutParams().width = DensityUtil.dp2px(context, 110);
                v.getLayoutParams();
            }
        });
    }
}
