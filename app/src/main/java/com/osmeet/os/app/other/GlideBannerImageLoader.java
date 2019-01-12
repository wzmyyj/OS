package com.osmeet.os.app.other;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.osmeet.os.R;
import com.youth.banner.loader.ImageLoader;



/**
 * Created by yyj on 2018/07/30. email: 2209011667@qq.com
 */

public class GlideBannerImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context)
                .load((String)path)
//                .placeholder(R.mipmap.ic_progress)
                .apply(new RequestOptions().fitCenter().error(R.mipmap.ic_bg))
                .into(imageView);
    }
}
