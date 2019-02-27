package com.osmeet.os.view.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.widget.TextView;

import com.kongzue.dialog.v2.InputDialog;
import com.osmeet.os.R;
import com.osmeet.os.app.bean.Balance;
import com.osmeet.os.app.bean.Record;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.WalletContract;
import com.osmeet.os.presenter.WalletPresenter;
import com.osmeet.os.view.panel.WalletRecyclerPanel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.panel.PanelUtil;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

public class WalletActivity extends BaseActivity<WalletContract.IPresenter> implements WalletContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new WalletPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wallet;
    }

    WalletRecyclerPanel walletRecyclerPanel_0;
    WalletRecyclerPanel walletRecyclerPanel_1;
    WalletRecyclerPanel walletRecyclerPanel_2;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(
                walletRecyclerPanel_0 = new WalletRecyclerPanel(context, mPresenter).setTitle(context.getString(R.string.all)),
                walletRecyclerPanel_1 = new WalletRecyclerPanel(context, mPresenter).setTitle(context.getString(R.string.income)),
                walletRecyclerPanel_2 = new WalletRecyclerPanel(context, mPresenter).setTitle(context.getString(R.string.expend))
        );
    }

    @BindView(R.id.tab_1)
    TabLayout mTabLayout;
    @BindView(R.id.vp_1)
    ViewPager mViewPager;
    @BindView(R.id.tv_wallet_money)
    TextView tv_wallet_money;
    @BindView(R.id.tv_wallet_money_2)
    TextView tv_wallet_money_2;

    @OnClick(R.id.img_back)
    void back() {
        mPresenter.finish();
    }

    @BindView(R.id.tv_title)
    TextView tv_title;

    @OnClick(R.id.bt_tx)
    void tx() {
        if (money < 0.001) {
            mPresenter.toast(context.getString(R.string.tx_je_not_blow_0_01));
            return;
        }
        dialogInput1();
    }

    private void dialogInput1() {
        InputDialog.show(context, context.getString(R.string.tip),
                context.getString(R.string.input_alipay_account),
                context.getString(R.string.submit), (dialog, inputText) -> {
                    if (TextUtils.isEmpty(inputText)) {
                        mPresenter.toast(context.getString(R.string.alipay_account_can_not_empty));
                        return;
                    }
                    aliPayAccount = inputText;
                    dialog.dismiss();
                    dialogInput2();
                }, context.getString(R.string.cancel), (dialog, which) -> {
                    mPresenter.toast(context.getString(R.string.submit));
                });
    }

    private void dialogInput2() {
        InputDialog.show(context, context.getString(R.string.tip),
                context.getString(R.string.tx_je),
                context.getString(R.string.submit), (dialog, inputText) -> {
                    txMoney = Float.parseFloat(inputText);
                    if (txMoney > money) {
                        mPresenter.toast(getString(R.string.ye_bz));
                        return;
                    } else if (txMoney < 0.011) {
                        mPresenter.toast(getString(R.string.tx_je_can_not_blow_0_01));
                        return;
                    } else {
                        mPresenter.loadTX(aliPayAccount, txMoney);
                    }
                    dialog.dismiss();
                }, context.getString(R.string.cancel), (dialog, which) -> {
                    mPresenter.toast(context.getString(R.string.cancel));
                });
    }

    private float txMoney;
    private String aliPayAccount;

    @Override
    protected void initView() {
        super.initView();
        PanelUtil.in(getPanelList(), mTabLayout, mViewPager);

        if (mPresenter.getMode() == 0) {
            WidgetUtil.setTextRes(tv_title, R.string.wallet);
        } else {
            WidgetUtil.setTextRes(tv_title, R.string.store_wallet);
        }
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadBalanceInfo();
        mPresenter.loadRecordList(0);
    }

    private float money;

    @Override
    public void showBalanceInfo(@NonNull Balance balance) {
        money = balance.getAvailableBalance();
        WidgetUtil.setTextPrice(tv_wallet_money, "", money);
        WidgetUtil.setTextPrice(tv_wallet_money_2, context.getString(R.string.yuan), money);
    }

    @Override
    public void showRecordList(@NonNull List<Record> recordList) {
        walletRecyclerPanel_0.setDataList(recordList);
        List<Record> recordList1 = new ArrayList<>();
        List<Record> recordList2 = new ArrayList<>();
        for (Record record : recordList) {
            if (record.getAfterBalance() - record.getPreviousBalance() > 0) {
                recordList1.add(record);
            } else {
                recordList2.add(record);
            }
        }
        walletRecyclerPanel_1.setDataList(recordList1);
        walletRecyclerPanel_2.setDataList(recordList2);
    }
}

