package com.osmeet.os.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.kongzue.dialog.v2.BottomMenu;
import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.ChatContract;
import com.osmeet.os.presenter.ChatPresenter;
import com.osmeet.os.view.fragment.ConChatFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.utils.FragmentUtil;
import top.wzmyyj.wzm_sdk.utils.StatusBarUtil;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

public class ChatActivity extends BaseActivity<ChatContract.IPresenter> implements ChatContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new ChatPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_chat;
    }

    @Override
    protected void initSome(Bundle savedInstanceState) {
        super.initSome(savedInstanceState);
        StatusBarUtil.initStatusBar(activity, false);
    }

    @OnClick(R.id.img_back)
    void back() {
        mPresenter.finish();
    }

    @OnClick(R.id.img_menu)
    void menu() {
        List<String> list = new ArrayList<>();
        list.add(context.getString(R.string.report));
        list.add(context.getString(R.string.block));
        BottomMenu.show((AppCompatActivity) context, list, (text, index) -> {
                    switch (index) {
                        case 0:
                            mPresenter.toast(text);
                            break;
                        case 1:
                            mPresenter.toast(text);
                            break;
                    }
                }, true, context.getString(R.string.cancel)
        ).setTitle(context.getString(R.string.please_choose));
    }

    @BindView(R.id.tv_title)
    TextView tv_title;
    private ConChatFragment conChatFragment;

    @Override
    protected void initView() {
        super.initView();

        conChatFragment = new ConChatFragment();
        FragmentUtil.add(getSupportFragmentManager(), R.id.fl_fragment, conChatFragment, "");
        if (getIntent().getData() != null) {
            WidgetUtil.setTextNonNull(tv_title, getIntent().getData().getQueryParameter("title"));
        }
    }
}

