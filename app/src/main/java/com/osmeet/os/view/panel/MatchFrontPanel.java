package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.kongzue.dialog.v2.BottomMenu;
import com.osmeet.os.R;
import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.app.tools.SDT;
import com.osmeet.os.app.utils.DistanceUtil;
import com.osmeet.os.base.panel.BasePanel;
import com.osmeet.os.contract.MatchContract;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.utils.TimeUtil;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class MatchFrontPanel extends BasePanel<MatchContract.IPresenter> {

    public MatchFrontPanel(Context context, MatchContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_match_front;
    }

    @BindView(R.id.img_store_logo)
    ImageView img_store_logo;
    @BindView(R.id.tv_store_name)
    TextView tv_store_name;
    @BindView(R.id.tv_store_distance)
    TextView tv_store_distance;

    @BindView(R.id.img_lock_1)
    ImageView img_lock_1;
    @BindView(R.id.img_lock_2)
    ImageView img_lock_2;
    @BindView(R.id.img_lock_3)
    ImageView img_lock_3;

    @BindView(R.id.fl_cancel)
    FrameLayout fl_cancel;
    @BindView(R.id.tv_what)
    TextView tv_what;

    @BindView(R.id.fl_state_1)
    FrameLayout fl_state_1;
    @BindView(R.id.fl_state_2)
    FrameLayout fl_state_2;
    @BindView(R.id.fl_state_3)
    FrameLayout fl_state_3;

    @BindView(R.id.tv_meet_time)
    TextView tv_meet_time;

    @Override
    protected void initListener() {
        super.initListener();
        img_store_logo.setOnClickListener(v -> mPresenter.loadMatchTeam());
    }

    public void setMatchTeam(@NonNull MatchTeam matchTeam) {
        Store store = matchTeam.getStore();
        if (store != null) {
            if (store.getLogoImage() != null) {
                G.img(context, store.getLogoImage().getUrl(), img_store_logo);
            }
            WidgetUtil.setTextNonNull(tv_store_name, store.getName());
            WidgetUtil.setTextNonNull(tv_store_distance, DistanceUtil.distance(store.getLat(), store.getLng()));
        }

        letAIsMe(matchTeam);
        state_1 = 0;
        state_2 = 0;
        state_3 = 0;

        if (matchTeam.getMatchStatus() != MatchTeam.MATCH_NOW) {
            fl_cancel.setVisibility(View.VISIBLE);
        } else {
            fl_cancel.setVisibility(View.GONE);

            if (matchTeam.getTogetherState().equals(MatchTeam.Wait_Accept_Meet_Time)) {
                whenWMT(matchTeam);
            } else if (matchTeam.getTogetherState().equals(MatchTeam.Confirm_Meet_Time)) {
                whenB(matchTeam);
            }

        }

    }

    private int state_1 = 0;
    private int state_2 = 0;
    private int state_3 = 0;


    private void letAIsMe(MatchTeam matchTeam) {
        if (!matchTeam.getUnita().getUser().getId()
                .equals(App.getInstance().getMyInfo().getId())) {// a 不是我。
            matchTeam.changeAB();
        }
    }

    private void whenWMT(MatchTeam matchTeam) {
        img_lock_1.setVisibility(View.GONE);
        checkBTime(matchTeam);
    }

    private void checkBTime(MatchTeam matchTeam) {
        if (matchTeam.getBwantMeetTime() > 0) {// 对方有时间。
            if (matchTeam.getBtimeStatus() == 0) {// 我没处理。
                WidgetUtil.setTextNonNull(tv_meet_time, "对方提议时间" + "\n"
                        + TimeUtil.long2str(matchTeam.getBwantMeetTime(), TimeUtil.MM_DD_HH_MM));
                state_1 = 1;
            } else if (matchTeam.getBtimeStatus() == 1) { // 我拒绝了。
                checkATime(matchTeam);
            }
        } else {
            checkATime(matchTeam);
        }
    }

    private void checkATime(MatchTeam matchTeam) {
        if (matchTeam.getAwantMeetTime() > 0) { // 我有时间。
            if (matchTeam.getAtimeStatus() == 0) {// 对方没处理。
                WidgetUtil.setTextNonNull(tv_meet_time, "我提议时间" + "\n"
                        + TimeUtil.long2str(matchTeam.getAwantMeetTime(), TimeUtil.MM_DD_HH_MM));
                state_1 = 2;
            } else if (matchTeam.getAtimeStatus() == 1) {
                WidgetUtil.setTextNonNull(tv_meet_time, "对方拒绝" + "\n"
                        + "更换时间");
                state_1 = 3;
            }
        } else {
            WidgetUtil.setTextNonNull(tv_meet_time, "发送提议时间");
            state_1 = 4;
        }
    }


    private void whenB(MatchTeam matchTeam) {
        img_lock_1.setVisibility(View.VISIBLE);
        WidgetUtil.setTextNonNull(tv_meet_time, "同行时间" + "\n"
                + TimeUtil.long2str(matchTeam.getMeetTime(), TimeUtil.MM_DD_HH_MM));
        if (matchTeam.getMeetTime() > (TimeUtil.getTime() - 1000 * 60 * 60)
                && matchTeam.getMeetTime() < (TimeUtil.getTime() + 1000 * 60 * 60)) {
            state_2 = 1;
            img_lock_2.setVisibility(View.GONE);
        } else {
            state_2 = 0;
            img_lock_2.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.fl_state_1)
    void f_state_1() {
        if (state_1 == 0) return;
        if (state_1 == 1) {
            List<String> list = new ArrayList<>();
            list.add("接受");
            list.add("拒绝");
            list.add("更改");
            BottomMenu.show((AppCompatActivity) context, list, (text, index) -> {
                        switch (index) {
                            case 0:
                                mPresenter.acceptTime();
                                break;
                            case 1:
                                mPresenter.refuseTime();
                                break;
                            case 2:
                                changeTime();
                                break;
                        }
                    }, true, context.getString(R.string.cancel)
            ).setTitle(context.getString(R.string.please_choose));
        } else if (state_1 > 1) {
            List<String> list = new ArrayList<>();
            if (state_1 == 4) {
                list.add("提议");
            } else {
                list.add("更改");
            }
            BottomMenu.show((AppCompatActivity) context, list, (text, index) -> {
                        switch (index) {
                            case 0:
                                changeTime();
                                break;
                        }
                    }, true, context.getString(R.string.cancel)
            ).setTitle(context.getString(R.string.please_choose));
        }
    }

    private void changeTime() {
        SDT.create().Listener(new SDT.Listener() {
            @Override
            public void onPositiveButtonClick(Date date) {
                if (date.getTime() > (TimeUtil.getTime() + 70 * 60 * 1000) && TimeUtil.isInDay(date.getTime(), 7)) {
                    mPresenter.changeTime(date.getTime());
                } else {
                    mPresenter.toast("时间不合理，请重新选择！");
                }
            }

            @Override
            public void onNegativeButtonClick(Date date) {

            }
        })
                .setDefaultYear(TimeUtil.getYear() - 17)
                .setDefaultDateTime(TimeUtil.getTime())
                .show(((AppCompatActivity) activity)
                        .getSupportFragmentManager(), "dialog_time");
    }

    @OnClick(R.id.fl_state_2)
    void f_state_2() {
        if (state_2 == 0) return;
        mPresenter.finishMatch();
    }

}
