package top.wzmyyj.wzm_sdk.utils;

import android.annotation.SuppressLint;
import android.support.annotation.AnyRes;
import android.text.InputType;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by yyj on 2018/12/06.
 *
 * Widget辅助工具。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class WidgetUtil {

    /**
     * @param edit     .
     * @param isCanSee .
     */
    public static void setPasswordEditState(EditText edit, boolean isCanSee) {
        if (isCanSee) {
            edit.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        } else {
            edit.setInputType(129);
        }
        // 切换后将EditText光标置于末尾。
        setEditSelectionLast(edit);
    }

    /**
     * @param edit .
     */
    public static void setEditSelectionLast(EditText edit) {
        // 切换后将EditText光标置于末尾。
        CharSequence charSequence = edit.getText();
        if (charSequence != null) {
            Spannable spanText = (Spannable) charSequence;
            Selection.setSelection(spanText, charSequence.length());
        }
    }

    /**
     * @param textView .
     * @param s        .
     */
    public static void setTextOrGone(TextView textView, String s) {
        if (!TextUtils.isEmpty(s)) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(s);
        } else {
            textView.setVisibility(View.GONE);
        }
    }

    /**
     * @param textView .
     * @param s        .
     */
    public static void setTextNonNull(TextView textView, String s) {
        if (s != null) {
            textView.setText(s);
        } else {
            textView.setText("");
        }
    }

    /**
     * @param textView .
     * @param i        .
     */
    @SuppressLint("SetTextI18n")
    public static void setTextNumber(TextView textView, int i) {
        textView.setText("" + i);
    }

    /**
     * @param textView .
     * @param i        .
     */
    @SuppressLint("SetTextI18n")
    public static void setTextNumber(TextView textView, long i) {
        textView.setText("" + i);
    }

    /**
     * @param textView .
     * @param i        .
     */
    @SuppressLint("SetTextI18n")
    public static void setTextNumber(TextView textView, double i) {
        textView.setText("" + i);
    }

    /**
     * @param textView .
     * @param i        .
     */
    @SuppressLint("SetTextI18n")
    public static void setTextNumber(TextView textView, float i) {
        textView.setText("" + i);
    }

    /**
     * @param textView .
     * @param unit     .
     * @param i        .
     */
    @SuppressLint("SetTextI18n")
    public static void setTextPrice(TextView textView, String unit, float i) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (unit == null) unit = "$";
        textView.setText(unit + decimalFormat.format(i));
    }


    /**
     * @param textView .
     * @param resId    .
     */
    @SuppressLint("NewApi")
    public static void setTextColor(TextView textView, @AnyRes int resId) {
        textView.setTextColor(textView.getContext().getResources().getColor(resId, null));
    }


    /**
     * @param button .
     * @param resId  .
     */
    @SuppressLint("NewApi")
    public static void setTextColor(Button button, @AnyRes int resId) {
        button.setTextColor(button.getContext().getResources().getColor(resId, null));
    }

    /**
     * @param vs .
     */
    public static void beSquareByWidth(View... vs) {
        for (View v : vs) {
            v.getLayoutParams().height = v.getWidth();
            v.requestLayout();
        }
    }

    /**
     * @param vs .
     */
    public static void beSquareByHeight(View... vs) {
        for (View v : vs) {
            v.getLayoutParams().width = v.getHeight();
            v.requestLayout();
        }
    }
}
