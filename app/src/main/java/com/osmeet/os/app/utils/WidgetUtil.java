package com.osmeet.os.app.utils;

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

import com.osmeet.os.R;

/**
 * Created by yyj on 2018/12/06. email: 2209011667@qq.com
 */

public class WidgetUtil {

    @SuppressLint("NewApi")
    public static void setButtonState(Button button, boolean isCanPressed) {
        if (isCanPressed) {
            button.setBackgroundResource(R.drawable.bg_button_selector);
            button.setTextColor(button.getContext().getResources().getColor(R.color.colorWhite, null));
        } else {
            button.setBackgroundResource(R.drawable.bg_button_down);
            button.setTextColor(button.getContext().getResources().getColor(R.color.colorAhp_d, null));
        }
    }

    public static void setPasswordEditState(EditText edit, boolean isCanSee) {
        if (isCanSee) {
            edit.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        } else {
            edit.setInputType(129);
        }
        // 切换后将EditText光标置于末尾。
        setEditSelectionLast(edit);
    }

    public static void setEditSelectionLast(EditText edit) {
        // 切换后将EditText光标置于末尾。
        CharSequence charSequence = edit.getText();
        if (charSequence != null) {
            Spannable spanText = (Spannable) charSequence;
            Selection.setSelection(spanText, charSequence.length());
        }
    }

    public static void setTextOrGone(TextView textView, String s) {
        if (!TextUtils.isEmpty(s)) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(s);
        } else {
            textView.setVisibility(View.GONE);
        }
    }

    public static void setTextNotNull(TextView textView, String s) {
        if (s != null) {
            textView.setText(s);
        } else {
            textView.setText("");
        }
    }

    @SuppressLint("SetTextI18n")
    public static void setTextNumber(TextView textView, int i) {
        textView.setText("" + i);
    }

    @SuppressLint("SetTextI18n")
    public static void setTextNumber(TextView textView, long i) {
        textView.setText("" + i);
    }

    @SuppressLint("SetTextI18n")
    public static void setTextNumber(TextView textView, double i) {
        textView.setText("" + i);
    }

    @SuppressLint("SetTextI18n")
    public static void setTextNumber(TextView textView, float i) {
        textView.setText("" + i);
    }


    public static void beSquareByWidth(View... vs) {
        for (View v : vs) {
            v.getLayoutParams().height = v.getWidth();
            v.requestLayout();
        }
    }


    @SuppressLint("NewApi")
    public static void setTextColor(TextView textView, @AnyRes int resId) {
        textView.setTextColor(textView.getContext().getResources().getColor(resId, null));
    }


    @SuppressLint("NewApi")
    public static void setTextColor(Button button, @AnyRes int resId) {
        button.setTextColor(button.getContext().getResources().getColor(resId, null));
    }

    public static void beSquareByHeight(View... vs) {
        for (View v : vs) {
            v.getLayoutParams().width = v.getHeight();
            v.requestLayout();
        }
    }
}
