package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kongzue.dialog.v2.BottomMenu;
import com.osmeet.os.R;
import com.osmeet.os.base.panel.BaseNeScrollPanel;
import com.osmeet.os.contract.SettingContract;
import com.xw.repo.BubbleSeekBar;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

/**
 * Created by yyj on 2018/12/28. email: 2209011667@qq.com
 */

public class SettingNeScrollPanel extends BaseNeScrollPanel<SettingContract.IPresenter> {
    public SettingNeScrollPanel(Context context, SettingContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.layout_setting_content;
    }

    @Override
    protected void update() {

    }


    @Override
    protected void initView() {
        super.initView();
        mRefreshLayout.setEnablePureScrollMode(true);
        choiceSex(mPresenter.getSetting().getOsSex());
        bsb_age.setProgress(mPresenter.getSetting().getOsMaxAge());
        bsb_distance.setProgress(mPresenter.getSetting().getOsDistance());
        if (mPresenter.getSetting().getOsMaxAge() < 55) {
            WidgetUtil.setTextNonNull(tv_age_rang, mPresenter.getSetting().getOsMinAge()
                    + "-" + mPresenter.getSetting().getOsMaxAge());
        } else {
            WidgetUtil.setTextNonNull(tv_age_rang, mPresenter.getSetting().getOsMinAge()
                    + "-55+");
        }


        if (mPresenter.getSetting().getOsDistance() < 100) {
            WidgetUtil.setTextNonNull(tv_distance, mPresenter.getSetting().getOsDistance() + "km");
        } else {
            WidgetUtil.setTextNonNull(tv_distance, "100km+");
        }

        WidgetUtil.setTextNonNull(tv_cache, mPresenter.getCacheSize());
        WidgetUtil.setTextNonNull(tv_language, mPresenter.getLanguage());
        WidgetUtil.setTextNonNull(tv_account, mPresenter.getAccount());

    }

    @Override
    protected void initListener() {
        super.initListener();
        bsb_age.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                if (progress < 55) {
                    WidgetUtil.setTextNonNull(tv_age_rang, mPresenter.getSetting().getOsMinAge()
                            + "-" + progress);
                } else {
                    WidgetUtil.setTextNonNull(tv_age_rang, mPresenter.getSetting().getOsMinAge()
                            + "-55+");
                }
            }

            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {
                mPresenter.getSetting().setOsMaxAge(progress);
            }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {

            }
        });

        bsb_distance.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                if (progress < 100) {
                    WidgetUtil.setTextNonNull(tv_distance, progress + "km");
                } else {
                    WidgetUtil.setTextNonNull(tv_distance, "100km+");
                }
            }

            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {
                mPresenter.getSetting().setOsDistance(progress);
            }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {

            }
        });
    }

    @BindView(R.id.bsb_age)
    BubbleSeekBar bsb_age;
    @BindView(R.id.bsb_distance)
    BubbleSeekBar bsb_distance;

    @BindView(R.id.tv_distance)
    TextView tv_distance;
    @BindView(R.id.tv_age_rang)
    TextView tv_age_rang;

    @OnClick(R.id.tv_logout)
    void logout() {
        mPresenter.logout();
    }

    @OnClick(R.id.ll_setting_1)
    void setting_1() {
        mPresenter.goAccount();
    }

    @OnClick(R.id.ll_setting_2)
    void setting_2() {
        BottomMenu.show((AppCompatActivity) context,
                mPresenter.getLanguageList(),
                (text, index) -> {
                    WidgetUtil.setTextNonNull(tv_language, mPresenter.getLanguageList().get(index));
                    mPresenter.changeLanguage(index);
                }, true, context.getString(R.string.cancel)
        ).setTitle(context.getString(R.string.please_choose));
    }

    @OnClick(R.id.ll_setting_3)
    void setting_3() {
        WidgetUtil.setTextNonNull(tv_cache, "0.0B");
        mPresenter.clearCache();
        mPresenter.toast(context.getString(R.string.clear_cache_ok));
    }

    @OnClick(R.id.ll_setting_4)
    void setting_4() {
        mPresenter.goBlockList();
    }

    @OnClick(R.id.ll_setting_5)
    void setting_5() {
        mPresenter.goAboutOs();
    }

    @OnClick(R.id.ll_setting_6)
    void setting_6() {
        mPresenter.goProtocol();
    }

    @BindView(R.id.tv_account)
    TextView tv_account;
    @BindView(R.id.tv_language)
    TextView tv_language;
    @BindView(R.id.tv_cache)
    TextView tv_cache;


    @BindView(R.id.ll_sex_1)
    LinearLayout ll_sex_1;
    @BindView(R.id.ll_sex_2)
    LinearLayout ll_sex_2;
    @BindView(R.id.ll_sex_3)
    LinearLayout ll_sex_3;

    @OnClick(R.id.tv_sex_1)
    void set_1() {
        choiceSex(1);
        mPresenter.getSetting().setOsSex(1);
    }

    @OnClick(R.id.tv_sex_2)
    void set_2() {
        choiceSex(2);
        mPresenter.getSetting().setOsSex(2);
    }

    @OnClick(R.id.tv_sex_3)
    void set_3() {
        choiceSex(3);
        mPresenter.getSetting().setOsSex(0);
    }

    private void choiceSex(int i) {
        ll_sex_1.setVisibility(View.GONE);
        ll_sex_2.setVisibility(View.GONE);
        ll_sex_3.setVisibility(View.GONE);
        if (i == 1) {
            ll_sex_1.setVisibility(View.VISIBLE);
        } else if (i == 2) {
            ll_sex_2.setVisibility(View.VISIBLE);
        } else {
            ll_sex_3.setVisibility(View.VISIBLE);
        }
    }

}
