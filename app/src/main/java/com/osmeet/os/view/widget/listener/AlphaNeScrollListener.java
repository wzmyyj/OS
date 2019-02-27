package com.osmeet.os.view.widget.listener;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;

import top.wzmyyj.wzm_sdk.utils.DensityUtil;

/**
 * Created by yyj on 2019/01/22.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class AlphaNeScrollListener implements NestedScrollView.OnScrollChangeListener {
    private int maxDistance;
    private int mDistance;
    private IAlpha ia;

    public AlphaNeScrollListener(Context context, IAlpha ia) {
        this.maxDistance = DensityUtil.dp2px(context, 100);
        this.mDistance = 0;
        this.ia = ia;
    }

    @Override
    public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        mDistance = scrollY;
        float percent = mDistance * 1f / maxDistance;//百分比
        ia.alpha(percent);
    }
}
