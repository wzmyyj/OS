package com.osmeet.os.app.tools;

import android.support.v4.app.FragmentManager;

import com.kunzisoft.switchdatetime.SwitchDateTimeDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

import top.wzmyyj.wzm_sdk.utils.TimeUtil;

/**
 * Created by yyj on 2018/12/07. email: 2209011667@qq.com
 * 日期时间选择器工具类。
 * 不要吐槽命名，常用就用最简单的方式，写代码容易啊啊啊啊。如果有意见，可以开发完成后重命名。
 */

public class SDT {

    private SwitchDateTimeDialogFragment dateTimeDialogFragment;

    private SDT(SwitchDateTimeDialogFragment dateTimeDialogFragment) {
        this.dateTimeDialogFragment = dateTimeDialogFragment;
    }


    public static SDT create() {
        SwitchDateTimeDialogFragment dialogFragment = SwitchDateTimeDialogFragment.newInstance(
                "请选择",
                "确定",
                "取消"
        );
        dialogFragment.startAtCalendarView();
        dialogFragment.set24HoursMode(true);
        return new SDT(dialogFragment);
    }


    public SDT startAt(int at) {
        switch (at) {
            case 0:
                this.dateTimeDialogFragment.startAtCalendarView();
                break;
            case 1:
                this.dateTimeDialogFragment.startAtTimeView();
                break;
            case 2:
                this.dateTimeDialogFragment.startAtYearView();
                break;
        }
        return this;
    }

    public SDT set24HoursMode(boolean is24) {
        this.dateTimeDialogFragment.set24HoursMode(is24);
        return this;
    }

    public SDT setDefaultDateTime(long time) {
        return setDefaultDateTime(time, true);
    }

    public SDT setDefaultDateTime(long time, boolean isDo) {
        if (!isDo) return this;
        Date date = new Date(time);
        this.dateTimeDialogFragment.setDefaultYear(TimeUtil.getYear(date));
        this.dateTimeDialogFragment.setDefaultMonth(TimeUtil.getMonth(date));
        this.dateTimeDialogFragment.setDefaultDay(TimeUtil.getDay(date));
        this.dateTimeDialogFragment.setDefaultHourOfDay(TimeUtil.getHourInDay(date));
        this.dateTimeDialogFragment.setDefaultMinute(TimeUtil.getMinute(date));
        return this;
    }


    public SDT setDefaultMinute(int minute) {
        this.dateTimeDialogFragment.setDefaultMinute(minute);
        return this;
    }

    public SDT setDefaultHourOfDay(int hour) {
        this.dateTimeDialogFragment.setDefaultHourOfDay(hour);
        return this;
    }

    public SDT setDefaultDay(int day) {
        this.dateTimeDialogFragment.setDefaultDay(day);
        return this;
    }

    public SDT setDefaultMonth(int month) {
        this.dateTimeDialogFragment.setDefaultMonth(month);
        return this;
    }

    public SDT setDefaultYear(int year) {
        this.dateTimeDialogFragment.setDefaultYear(year);
        return this;
    }


    public SDT Listener(Listener listener) {
        this.dateTimeDialogFragment.setOnButtonClickListener(listener);
        return this;
    }

    public SDT setSimpleDateMonthAndDayFormat(SimpleDateFormat simpleDateFormat) {
        try {
            this.dateTimeDialogFragment.setSimpleDateMonthAndDayFormat(simpleDateFormat);
        } catch (SwitchDateTimeDialogFragment.SimpleDateMonthAndDayFormatException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void show(FragmentManager manager, String tag) {
        this.dateTimeDialogFragment.show(manager, tag);
    }


    public interface Listener extends SwitchDateTimeDialogFragment.OnButtonClickListener {
    }

}
