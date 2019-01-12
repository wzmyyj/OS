package com.osmeet.os.view.fragment;

import com.osmeet.os.R;
import com.osmeet.os.base.fragment.BaseFragment;
import com.osmeet.os.contract.MapContract;
import com.osmeet.os.presenter.MapPresenter;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class MapFragment extends BaseFragment<MapContract.IPresenter> implements MapContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new MapPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panel;
    }

}
