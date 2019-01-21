package com.osmeet.os.view.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
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
import top.wzmyyj.wzm_sdk.adapter.ViewTitlePagerAdapter;
import top.wzmyyj.wzm_sdk.panel.Panel;
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
                walletRecyclerPanel_0 = new WalletRecyclerPanel(context, mPresenter).setTitle("全部"),
                walletRecyclerPanel_1 = new WalletRecyclerPanel(context, mPresenter).setTitle("收入"),
                walletRecyclerPanel_2 = new WalletRecyclerPanel(context, mPresenter).setTitle("支出")
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

    @OnClick(R.id.bt_tx)
    void tx() {
        if (money < 0.001) {
            mPresenter.toast("提现余额需不少于0.01￥！");
            return;
        }
        dialogInput1();

    }

    private void dialogInput1() {
        InputDialog.show(context, "提示", "请输入支付宝账号：",
                "提交", (dialog, inputText) -> {
                    if (TextUtils.isEmpty(inputText)) {
                        mPresenter.toast("支付宝账号不能为空！");
                        return;
                    }
                    aliPayAccount = inputText;
                    dialog.dismiss();
                    dialogInput2();
                }, "取消", (dialog, which) -> {
                    mPresenter.toast("操作已取消！");
                });
    }

    private void dialogInput2() {
        InputDialog.show(context, "提示", "请提现金额：",
                "提交", (dialog, inputText) -> {
                    txMoney = Float.parseFloat(inputText);
                    if (txMoney > money) {
                        mPresenter.toast("余额不足！");
                        return;
                    } else if (txMoney < 0.011) {
                        mPresenter.toast("提现金额需不少于0.1￥！");
                        return;
                    } else {
                        mPresenter.loadTX(aliPayAccount, txMoney);
                    }
                    dialog.dismiss();
                }, "取消", (dialog, which) -> {
                    mPresenter.toast("操作已取消！");
                });
    }

    private float txMoney;
    private String aliPayAccount;

    @Override
    protected void initView() {
        super.initView();
        List<View> viewList = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (Panel p : getPanelList()) {
            viewList.add(p.getView());
            titles.add(p.getTitle());
        }
        ViewTitlePagerAdapter pagerAdapter = new ViewTitlePagerAdapter(viewList, titles);
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadBalance();
        mPresenter.loadRecordList(0);
    }

    private float money;

    @Override
    public void showBalance(@NonNull Balance balance) {
        money = balance.getAvailableBalance();
        WidgetUtil.setTextPrice(tv_wallet_money, "", money);
        WidgetUtil.setTextPrice(tv_wallet_money_2, "￥", money);
    }

    @Override
    public void showRecordList(@NonNull List<Record> recordList) {
        walletRecyclerPanel_0.setRecordList(recordList);
        List<Record> recordList1 = new ArrayList<>();
        List<Record> recordList2 = new ArrayList<>();
        for (Record record : recordList) {
            if (record.getAfterBalance() - record.getPreviousBalance() > 0) {
                recordList1.add(record);
            } else {
                recordList2.add(record);
            }
        }
        walletRecyclerPanel_1.setRecordList(recordList1);
        walletRecyclerPanel_2.setRecordList(recordList2);
    }
}

