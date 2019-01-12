package top.wzmyyj.wzm_sdk.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

import top.wzmyyj.wzm_sdk.fragment.InitFragment;

/**
 * Created by yyj on 2018/12/17. email: 2209011667@qq.com
 */

public class InitFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<InitFragment> mFragmentList;

    public List<InitFragment> getmFragmentList() {
        return mFragmentList;
    }

    public void setmFragmentList(List<InitFragment> mFragmentList) {
        this.mFragmentList = mFragmentList;
        notifyDataSetChanged();
    }

    public InitFragmentPagerAdapter(FragmentManager fm, List<InitFragment> fragmentList) {
        super(fm);
        this.mFragmentList = fragmentList;
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentList.get(position).getTitle();
    }
}
