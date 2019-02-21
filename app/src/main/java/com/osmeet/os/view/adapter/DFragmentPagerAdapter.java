package com.osmeet.os.view.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.InitFragmentPagerAdapter;
import top.wzmyyj.wzm_sdk.fragment.InitFragment;

/**
 * Created by yyj on 2019/02/20.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class DFragmentPagerAdapter extends InitFragmentPagerAdapter {
    public DFragmentPagerAdapter(FragmentManager fm, List<InitFragment> fragmentList) {
        super(fm, fragmentList);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return PagerAdapter.POSITION_NONE;
    }
}
