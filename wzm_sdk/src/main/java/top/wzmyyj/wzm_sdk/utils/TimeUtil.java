package top.wzmyyj.wzm_sdk.utils;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yyj on 2018/04/26.
 *
 * Vanessa 凡妮莎，第八个七骑士，拥有控制时间的沙漏和魔法。
 * 时间转换工具类。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

@SuppressLint("SimpleDateFormat")
public class TimeUtil {


    /**
     * @param l
     * @param format
     * @return 时间戳。
     */
    public static String long2str(long l, String format) {
        if (l == 0) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String s = sdf.format(new Date(l));
        return s;
    }

    /**
     * @param time
     * @param format
     * @return 时间格式。
     */
    public static long str2long(String time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        long l = 0;
        try {
            l = sdf.parse(time).getTime();
        } catch (ParseException e) {
           //e.printStackTrace();
        }
        return l;
    }

    /**
     * @return 时间戳。
     */
    public static long getTime() {
        Date d = new Date();
        return getTime(d);
    }

    /**
     * @param date
     * @return 时间戳。
     */
    public static long getTime(Date date) {
        return date.getTime();
    }

    /**
     * @return minute.
     */
    public static int getMinute(){
        Date d = new Date();
        return getMinute(d);
    }

    /**
     * @param date
     * @return minute.
     */
    public static int getMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    /**
     * @return hour in day.
     */
    public static int getHourInDay() {
        Date d = new Date();
        return getHourInDay(d);
    }

    /**
     * @param date
     * @return hour in day.
     */
    public static int getHourInDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * @return week:0,1,2,3,4,5,6.
     */
    public static int getWeek() {
        Date d = new Date();
        return getWeek(d);
    }

    /**
     * @param date
     * @return week:0,1,2,3,4,5,6.
     */
    public static int getWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * @return day
     */
    public static int getDay() {
        Date d = new Date();
        return getDay(d);
    }

    /**
     * @param date
     * @return day
     */
    public static int getDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * @return month.
     */
    public static int getMonth() {
        Date d = new Date();
        return getMonth(d);
    }

    /**
     * @param date
     * @return month.
     */
    public static int getMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH);
    }

    /**
     * @return year.
     */
    public static int getYear() {
        Date d = new Date();
        return getYear(d);
    }

    /**
     * @param date
     * @return year.
     */
    public static int getYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    /**
     * @param l
     * @return easy time format
     */
    @SuppressLint("SimpleDateFormat")
    public static String getEasyTime(long l) {
        Date d = new Date();
        String s;
        long t = Math.abs(d.getTime() - l);
        //一天内
        if (t < 24L * 60 * 60 * 1000) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            s = sdf.format(new Date(l));
        } else if (t < 30L * 24 * 60 * 60 * 1000) {// 30天内
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
            s = sdf.format(new Date(l));
        } else if (t < 12L * 30 * 24 * 60 * 60 * 1000) {// 12个月内
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
            s = sdf.format(new Date(l));
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            s = sdf.format(new Date(l));
        }
        return s;
    }

    /**
     * @param l
     * @return easy text.
     */
    public static String getEasyText(long l) {
        Date d = new Date();
        String s;
        long t = Math.abs(d.getTime() - l);
        if (t <= 5L * 60 * 1000) {
            s = "刚刚";
        } else if (t < 60L * 60 * 1000) {
            int a = (int) (t / (60 * 1000));
            s = a + "分钟前";
        } else if (t < 24L * 60 * 60 * 1000) {
            int a = (int) (t / (60 * 60 * 1000));
            s = a + "小时前";
        } else if (t < 30L * 24 * 60 * 60 * 1000) {
            int a = (int) (t / (24L * 60 * 60 * 1000));
            s = a + "天前";
        } else {
            s = getEasyTime(l);
        }

        return s;
    }

    /**
     * @param l
     * @param i
     * @return 是否在i天内.
     */
    public static boolean isInDay(long l, int i) {
        Date d = new Date();
        long t = Math.abs(d.getTime() - l);
        return t < i * 24L * 60 * 60 * 1000;
    }
}
