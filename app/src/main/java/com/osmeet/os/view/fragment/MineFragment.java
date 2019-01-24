package com.osmeet.os.view.fragment;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.event.MyInfoUpdateEvent;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.app.tools.GP;
import com.osmeet.os.base.fragment.BaseFragment;
import com.osmeet.os.contract.MineContract;
import com.osmeet.os.presenter.MinePresenter;
import com.osmeet.os.view.activity.MainActivity;
import com.osmeet.os.view.panel.MineInfoRecyclerPanel;
import com.osmeet.os.view.panel.MineStoreRecyclerPanel;
import com.osmeet.os.view.widget.MenuHorizontalScrollView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
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
        mPresenter = new MinePresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;

    MineInfoRecyclerPanel mineInfoRecyclerPanel;
    MineStoreRecyclerPanel mineStoreRecyclerPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(
                mineInfoRecyclerPanel = new MineInfoRecyclerPanel(context, mPresenter),
                mineStoreRecyclerPanel = new MineStoreRecyclerPanel(context, mPresenter)
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
        satChoiceList();


        fl_panel.addView(getPanelView(0));
        fl_panel.addView(getPanelView(1));
        fl_panel.addView(mTopBar);
        fl_panel.addView(mChoiceList);

        getPanelView(1).setVisibility(View.GONE);

        mineInfoRecyclerPanel.bindView("v", ll_tap_bar);
        mineStoreRecyclerPanel.bindView("v", ll_tap_bar);

    }

    private View mTopBar;
    private TextView tv_who;
    private TextView tv_name_top;
    private ImageView img_avatar_top;
    private LinearLayout ll_tap_bar;

    @SuppressLint("InflateParams")
    private void setTopBar() {
        mTopBar = mInflater.inflate(R.layout.layout_mine_top_bar, null);
        img_avatar_top = mTopBar.findViewById(R.id.img_avatar_top);
        tv_name_top = mTopBar.findViewById(R.id.tv_name_top);
        tv_who = mTopBar.findViewById(R.id.tv_who);
        ll_tap_bar = mTopBar.findViewById(R.id.ll_top_abr);
        ll_tap_bar.setAlpha(0f);
        mTopBar.findViewById(R.id.img_camera).setOnClickListener(v -> openCamera());
        mTopBar.findViewById(R.id.img_menu).setOnClickListener(v -> mMenuHorizontalScrollView.toggle());
        mTopBar.findViewById(R.id.ll_who).setOnClickListener(v -> toggleChoice());
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

    private View mChoiceList;
    private CommonAdapter mChoiceAdapter;
    private List<UserStore> mChoiceData;

    private int whoChoice = 0;

    @SuppressLint("InflateParams")
    private void satChoiceList() {
        mChoiceList = mInflater.inflate(R.layout.layout_mine_choice, null);
        mChoiceList.setVisibility(View.INVISIBLE);
        mChoiceList.findViewById(R.id.v_empty).setOnClickListener(v -> closeChoice());
        RecyclerView recyclerView = mChoiceList.findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mChoiceAdapter = new CommonAdapter<UserStore>(context,
                R.layout.layout_mine_choice_item,
                mChoiceData = new ArrayList<>()) {

            @Override
            protected void convert(ViewHolder holder, UserStore o, int position) {
                ImageView img_avatar = holder.getView(R.id.img_avatar);
                TextView tv_name = holder.getView(R.id.tv_name);
                ImageView img_tag = holder.getView(R.id.img_tag);

                if (o.type == 1 && o.user != null) {
                    if (o.user.getAvatar() != null)
                        G.img(context, o.user.getAvatar().getUrl(), img_avatar);
                    WidgetUtil.setTextNonNull(tv_name, o.user.getUsername());
                } else if (o.type == 2 && o.store != null) {
                    if (o.store.getLogoImage() != null)
                        G.img(context, o.store.getLogoImage().getUrl(), img_avatar);
                    WidgetUtil.setTextNonNull(tv_name, o.store.getName());
                } else {
                    G.img(context, R.mipmap.ic_os_1, img_avatar);
                    WidgetUtil.setTextNonNull(tv_name, "注册相对地点");
                }
                if (whoChoice == position) {
                    img_tag.setVisibility(View.VISIBLE);
                } else {
                    img_tag.setVisibility(View.GONE);
                }

            }
        });
        mChoiceAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                UserStore o = mChoiceData.get(position);
                if (o.type == 1) {
                    tv_who.setText(R.string.mine);
                    mineInfoRecyclerPanel.getView().setVisibility(View.VISIBLE);
                    mineStoreRecyclerPanel.getView().setVisibility(View.GONE);
                    whoChoice = position;
                    mChoiceAdapter.notifyDataSetChanged();
                } else if (o.type == 2) {
                    tv_who.setText(R.string.place);
                    mineInfoRecyclerPanel.getView().setVisibility(View.GONE);
                    mineStoreRecyclerPanel.getView().setVisibility(View.VISIBLE);
                    mineStoreRecyclerPanel.setStore(o.store);
                    whoChoice = position;
                    mChoiceAdapter.notifyDataSetChanged();

                } else {
                    mPresenter.toast("等级不够，无法注册！");
                }

                closeChoice();
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });

    }

    boolean isChoiceOpen = false;

    private void closeChoice() {
        if (!isChoiceOpen) return;
        mChoiceList.setVisibility(View.INVISIBLE);
        isChoiceOpen = false;
    }

    private void openChoice() {
        if (isChoiceOpen) return;
        mChoiceList.setVisibility(View.VISIBLE);
        isChoiceOpen = true;
    }

    private void toggleChoice() {
        if (isChoiceOpen) {
            closeChoice();
        } else {
            openChoice();
        }
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadMyInfo();
        mPresenter.loadMyStoreList();
    }


    private User user;

    @Override
    public void showMyInfo(@NonNull User user) {
        this.user = user;
        ((MainActivity) activity).showMyInfo(user);
        mineInfoRecyclerPanel.setUser(user);
        // bar
        tv_who.setText(R.string.mine);
        WidgetUtil.setTextNonNull(tv_name_top, user.getUsername());
        if (user.getAvatar() != null)
            G.img(context, user.getAvatar().getUrl(), img_avatar_top);

        if (mChoiceData.size() > 0) {
            mChoiceData.get(0).user = user;
            mChoiceAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showMyStoreList(@NonNull List<Store> storeList) {
        mChoiceData.clear();
        mChoiceData.add(new UserStore(this.user));
        for (Store store : storeList) {
            mChoiceData.add(new UserStore(store));
        }
        mChoiceData.add(new UserStore());
        mChoiceAdapter.notifyDataSetChanged();
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


    static class UserStore {
        int type;
        User user;
        Store store;

        public UserStore() {
            type = 3;
        }

        UserStore(User user) {
            this.user = user;
            type = 1;
        }

        UserStore(Store store) {
            this.store = store;
            type = 2;
        }
    }

}
