package com.osmeet.os.view.panel;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.osmeet.os.R;
import com.osmeet.os.base.panel.BaseNeScrollPanel;
import com.osmeet.os.contract.SettingContract;
import com.xw.repo.BubbleSeekBar;

import butterknife.BindView;
import butterknife.OnClick;

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
    }

    @Override
    protected void initListener() {
        super.initListener();
        bsb_age.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {

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

    @OnClick(R.id.tv_logout)
    void logout() {
        mPresenter.logout();
    }

    @OnClick(R.id.ll_setting_1)
    void setting_1() {

    }

    @OnClick(R.id.ll_setting_2)
    void setting_2() {

    }

    @OnClick(R.id.ll_setting_3)
    void setting_3() {

    }

    @OnClick(R.id.ll_setting_4)
    void setting_4() {

    }

    @OnClick(R.id.ll_setting_5)
    void setting_5() {

    }

    @OnClick(R.id.ll_setting_6)
    void setting_6() {

    }


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
        mPresenter.getSetting().setOsSex(3);
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
