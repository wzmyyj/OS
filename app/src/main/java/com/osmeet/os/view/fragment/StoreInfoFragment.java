package com.osmeet.os.view.fragment;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.app.utils.WidgetUtil;
import com.osmeet.os.base.fragment.BaseFragment;
import com.osmeet.os.contract.StoreInfoContract;
import com.osmeet.os.presenter.StoreInfoPresenter;
import com.osmeet.os.view.panel.StoreFrontPanel;
import com.osmeet.os.view.panel.StoreInfoRecyclerPanel;

import butterknife.BindView;
import top.wzmyyj.wzm_sdk.activity.PanelActivity;

/**
 * Created by yyj on 2018/12/17. email: 2209011667@qq.com
 */

public class StoreInfoFragment extends BaseFragment<StoreInfoContract.IPresenter> implements StoreInfoContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new StoreInfoPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panel;
    }

    StoreInfoRecyclerPanel storeInfoRecyclerPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(storeInfoRecyclerPanel = new StoreInfoRecyclerPanel(context, mPresenter));
    }

    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;

    @Override
    protected void initView() {
        super.initView();
        setTopBar();
        fl_panel.addView(getPanelView(0));
        fl_panel.addView(mTopBar);
        storeInfoRecyclerPanel.bingView("v", ll_tap_bar);
    }

    private View mTopBar;
    private TextView tv_name_top;
    private ImageView img_avatar_top;
    private LinearLayout ll_tap_bar;

    @SuppressLint("InflateParams")
    private void setTopBar() {
        mTopBar = mInflater.inflate(R.layout.layout_info_top_bar, null);
        tv_name_top = mTopBar.findViewById(R.id.tv_name_top);
        img_avatar_top = mTopBar.findViewById(R.id.img_avatar_top);
        ll_tap_bar = mTopBar.findViewById(R.id.ll_top_abr);
        ll_tap_bar.setAlpha(0f);
        ImageView img_back = mTopBar.findViewById(R.id.img_back);
        img_back.setOnClickListener(v -> mPresenter.finish());
        ImageView img_menu = mTopBar.findViewById(R.id.img_menu);
        img_menu.setOnClickListener(v -> {

        });
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.log(mPresenter.getStoreId());
    }

    public void setStore(@NonNull Store store) {// 给别人调用。（第一次加载）
        storeInfoRecyclerPanel.setStore(store);

        // bar
        WidgetUtil.setTextNotNull(tv_name_top, store.getName());
        if (store.getLogoImage() != null)
            G.img(context, store.getLogoImage().getUrl(), img_avatar_top);
    }

    @Override
    public void showStoreInfo(@NonNull Store store) {// 给自己的mPresenter调用。（刷新）
        storeInfoRecyclerPanel.setStore(store);
        // bar
        WidgetUtil.setTextNotNull(tv_name_top, store.getName());
        if (store.getLogoImage() != null)
            G.img(context, store.getLogoImage().getUrl(), img_avatar_top);

        // fort
        StoreFrontPanel storeInfoFrontPanel = ((PanelActivity) activity).getPanel(0);
        if (storeInfoFrontPanel != null) {
            storeInfoFrontPanel.setStore(store);
        }
    }
}
