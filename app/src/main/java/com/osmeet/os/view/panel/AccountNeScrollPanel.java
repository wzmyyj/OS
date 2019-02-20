package com.osmeet.os.view.panel;

import android.content.Context;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.base.panel.BaseNeScrollPanel;
import com.osmeet.os.contract.AccountContract;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;


/**
 * Created by yyj on 2019/02/20.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class AccountNeScrollPanel extends BaseNeScrollPanel<AccountContract.IPresenter> {
    public AccountNeScrollPanel(Context context, AccountContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.layout_account;
    }

    @Override
    protected void update() {

    }

    @Override
    protected boolean isEnableRefresh() {
        return false;
    }

    @BindView(R.id.tv_account)
    TextView tv_account;

    @Override
    protected void initView() {
        super.initView();
        WidgetUtil.setTextNonNull(tv_account, mPresenter.getAccount());
    }

    @OnClick(R.id.ll_account_2)
    void ll_2() {
        mPresenter.goPassword();
    }
}
