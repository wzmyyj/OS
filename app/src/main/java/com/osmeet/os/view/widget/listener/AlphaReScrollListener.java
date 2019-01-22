package com.osmeet.os.view.widget.listener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import top.wzmyyj.wzm_sdk.utils.DensityUtil;

/**
 * Created by yyj on 2019/01/22.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class AlphaReScrollListener extends RecyclerView.OnScrollListener {
    private int maxDistance;
    private int mDistance;
    private IAlpha ia;

    public AlphaReScrollListener(Context context, IAlpha ia) {
        this.maxDistance = DensityUtil.dp2px(context, 200);
        this.mDistance = 0;
        this.ia = ia;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        mDistance += dy;
        float percent = mDistance * 1f / maxDistance;//百分比
        ia.alpha(percent);
    }
}
