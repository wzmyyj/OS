package com.osmeet.os.view.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.SearchContract;
import com.osmeet.os.presenter.SearchPresenter;
import com.osmeet.os.view.panel.SearchStorePanel;
import com.osmeet.os.view.panel.SearchUserPanel;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.utils.PanelUtil;

public class SearchActivity extends BaseActivity<SearchContract.IPresenter> implements SearchContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new SearchPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }


    SearchUserPanel searchUserPanel;
    SearchStorePanel searchStorePanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(
                searchUserPanel = new SearchUserPanel(context, mPresenter).setTitle(context.getString(R.string.user)),
                searchStorePanel = new SearchStorePanel(context, mPresenter).setTitle(context.getString(R.string.store))
        );
    }

    @BindView(R.id.et_input)
    EditText et_input;

    @OnClick(R.id.img_clear)
    void clear() {
        et_input.setText("");
    }

    @OnClick(R.id.tv_cancel)
    void cancel() {
        mPresenter.finish();
    }

    @BindView(R.id.tab_1)
    TabLayout mTabLayout;
    @BindView(R.id.vp_1)
    ViewPager mViewPager;

    @Override
    protected void initView() {
        super.initView();
        PanelUtil.in(getPanelList(), mTabLayout, mViewPager);
    }

    @Override
    protected void initListener() {
        super.initListener();
        et_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String word = s.toString();
                if (!TextUtils.isEmpty(word)) {
                    searchUserPanel.setTag(word);
                    searchStorePanel.setTag(word);
                    mPresenter.searchUser(word, 0);
                    mPresenter.searchStore(word, 0);
                }

            }
        });
    }

    @Override
    public void showSearchUserResult(@NonNull List<User> userList, @NonNull String word, int pageNum) {
        if (word.equals(searchUserPanel.getTag().toString()))
            searchUserPanel.setDataList(userList, pageNum);
    }

    @Override
    public void showSearchStoreResult(@NonNull List<Store> storeList, @NonNull String word, int pageNum) {
        if (word.equals(searchStorePanel.getTag().toString()))
            searchStorePanel.setDataList(storeList, pageNum);
    }
}

