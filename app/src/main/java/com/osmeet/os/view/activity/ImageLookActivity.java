package com.osmeet.os.view.activity;

import android.os.Bundle;

import com.osmeet.os.R;
import com.previewlibrary.GPreviewActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.utils.StatusBarUtil;


/**
 * Created by yyj on 2019/01/29.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class ImageLookActivity extends GPreviewActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.initStatusBar(this, true, true, true);
        ButterKnife.bind(this);
    }


    @Override
    public int setContentLayout() {
        return R.layout.activity_image_look;
    }

    @OnClick(R.id.img_back)
    void back() {
        finish();
        overridePendingTransition(0, 0);
    }

    @OnClick(R.id.img_menu)
    void menu() {

    }


}

