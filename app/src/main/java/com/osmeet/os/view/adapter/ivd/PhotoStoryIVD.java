package com.osmeet.os.view.adapter.ivd;

import android.content.Context;

import com.osmeet.os.R;
import com.osmeet.os.base.adapter.BaseIVD;
import com.osmeet.os.view.panel.bean.PhotoStory;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by yyj on 2019/01/22.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class PhotoStoryIVD extends BaseIVD<PhotoStory> {
    public PhotoStoryIVD(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.layout_photo_item;
    }

    @Override
    public void convert(ViewHolder holder, PhotoStory photo, int position) {

    }
}
