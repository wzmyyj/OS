package com.osmeet.os.view.adapter.ivd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.osmeet.os.R;
import com.osmeet.os.base.adapter.BaseIVD;
import com.osmeet.os.app.bean.Story;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import top.wzmyyj.wzm_sdk.utils.DensityUtil;
import top.wzmyyj.wzm_sdk.utils.MockUtil;

/**
 * Created by yyj on 2019/01/22.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class StoryIVD extends BaseIVD<Story> {

    private boolean isHasHead;

    public StoryIVD(Context context) {
        super(context);
        isHasHead=true;// 默认有head。
    }

    public boolean isHasHead() {
        return isHasHead;
    }

    public void setHasHead(boolean hasHead) {
        isHasHead = hasHead;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.layout_story_item;
    }

    @Override
    public void convert(ViewHolder holder, Story photo, int position) {
        int w = MockUtil.getScreenWidth(context);
        int m = DensityUtil.dp2px(context, 10);
        View convertView = holder.getConvertView();
        ViewGroup.LayoutParams params = convertView.getLayoutParams();
        params.width = w / 2;
        params.height = (w - 3 * m);
        int p = isHasHead ? position - 1 : position;
        if ((p & 1) > 0) {// 右边。
            convertView.setPadding(m / 2, 0, m, 0);
        } else {// 左边。
            convertView.setPadding(m, 0, m / 2, 0);
        }
        convertView.setLayoutParams(params);
    }
}
