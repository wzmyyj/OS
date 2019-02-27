package com.osmeet.os.view.fragment;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Story;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.event.MyInfoUpdateEvent;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.app.tools.GP;
import com.osmeet.os.base.fragment.BaseFragment;
import com.osmeet.os.contract.MineContract;
import com.osmeet.os.presenter.MinePresenter;
import com.osmeet.os.view.activity.MainActivity;
import com.osmeet.os.view.panel.MineInfoRecyclerPanel;
import com.osmeet.os.view.widget.MenuHorizontalScrollView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class MineFragment extends BaseFragment<MineContract.IPresenter> implements MineContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new MinePresenter(fragment, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;

    MineInfoRecyclerPanel mineInfoRecyclerPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(
                mineInfoRecyclerPanel = new MineInfoRecyclerPanel(context, mPresenter)
        );
    }

    @BindView(R.id.menuHorizontalScrollView)
    MenuHorizontalScrollView mMenuHorizontalScrollView;

    @OnClick(R.id.img_back)
    void back() {
        mMenuHorizontalScrollView.closeMenu();
    }

    @OnClick(R.id.ll_menu_0)
    void menu_0() {
        mPresenter.goMatchList();
    }

    @OnClick(R.id.ll_menu_1)
    void menu_1() {
        mPresenter.goTradeList();
    }

    @OnClick(R.id.ll_menu_2)
    void menu_2() {
        mPresenter.goVisitCard();
    }

    @OnClick(R.id.ll_menu_3)
    void menu_3() {
        mPresenter.toast("menu 3");
    }

    @OnClick(R.id.ll_menu_4)
    void menu_4() {
        mPresenter.goWallet();
    }


    @OnClick(R.id.ll_menu_setting)
    void menu_6() {
        mPresenter.goSetting();
    }


    @Override
    protected void initView() {
        super.initView();
        setTopBar();

        fl_panel.addView(getPanelView(0));
        fl_panel.addView(mTopBar);

        mineInfoRecyclerPanel.bindView("v", ll_tap_bar);

    }

    private View mTopBar;
    private TextView tv_name_top;
    private ImageView img_avatar_top;
    private LinearLayout ll_tap_bar;

    @SuppressLint("InflateParams")
    private void setTopBar() {
        mTopBar = mInflater.inflate(R.layout.layout_mine_top_bar, null);
        img_avatar_top = mTopBar.findViewById(R.id.img_avatar_top);
        tv_name_top = mTopBar.findViewById(R.id.tv_name_top);
        ll_tap_bar = mTopBar.findViewById(R.id.ll_top_abr);
        ll_tap_bar.setAlpha(0f);
        mTopBar.findViewById(R.id.img_camera).setOnClickListener(v -> openCamera());
        mTopBar.findViewById(R.id.img_menu).setOnClickListener(v -> mMenuHorizontalScrollView.toggle());
    }

    private void openCamera() {
        GP.create(new GP.CallBack() {
            @Override
            public void onSuccess(List<String> photoList) {
                if (photoList.size() > 0)
                    mPresenter.toast(photoList.get(0));
            }
        }).isOpenCamera(true).openWithPermission(activity);
    }


    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadMyInfo();
        mPresenter.loadStoryList(0);
    }


    @Override
    public void showMyInfo(@NonNull User user) {
        ((MainActivity) activity).showMyInfo(user);
        mineInfoRecyclerPanel.setUser(user);
        // bar
        WidgetUtil.setTextNonNull(tv_name_top, user.getUsername());
        if (user.getAvatar() != null)
            G.img(context, user.getAvatar().getUrl(), img_avatar_top);
    }

    @Override
    public void showStoryList(@NonNull List<Story> storyList, int pageNum) {
        mineInfoRecyclerPanel.setDataList(storyList, pageNum);
    }


    @Override
    protected void initEvent() {
        super.initEvent();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Subscribe
    public void onEvent(MyInfoUpdateEvent event) {
        if (event.isUpdate()) {
            mPresenter.freshMyInfo();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        mMenuHorizontalScrollView.closeMenuNoSmooth();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}
