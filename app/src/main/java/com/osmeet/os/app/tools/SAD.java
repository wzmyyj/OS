package com.osmeet.os.app.tools;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.osmeet.os.R;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by yyj on 2019/01/08. email: 2209011667@qq.com
 * 对话框包装工具类。
 * 不要吐槽命名，常用就用最简单的方式，写代码容易啊啊啊啊。如果有意见，可以开发完成后重命名。
 */

public class SAD {
    private SweetAlertDialog sweetAlertDialog;

    public static final int NORMAL_TYPE = 0;
    public static final int ERROR_TYPE = 1;
    public static final int SUCCESS_TYPE = 2;
    public static final int WARNING_TYPE = 3;
    public static final int CUSTOM_IMAGE_TYPE = 4;
    public static final int PROGRESS_TYPE = 5;

    private SAD(SweetAlertDialog sweetAlertDialog) {
        this.sweetAlertDialog = sweetAlertDialog;
    }

    public static SAD create(Context context, int type) {
        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(context, type);
        sweetAlertDialog.setConfirmText(context.getResources().getText(R.string.ok).toString());
        sweetAlertDialog.setCancelText(context.getResources().getText(R.string.cancel).toString());
        return new SAD(sweetAlertDialog);
    }

    public SAD setTitleText(String title) {
        this.sweetAlertDialog.setTitleText(title);
        return this;
    }

    public SAD setContentText(String text) {
        this.sweetAlertDialog.setContentText(text);
        return this;
    }

    public SAD setCustomImage(Drawable drawable) {
        this.sweetAlertDialog.setCustomImage(drawable);
        return this;
    }

    public SAD setCustomImage(int resourceId) {
        this.sweetAlertDialog.setCustomImage(resourceId);
        return this;
    }

    public SAD setConfirmText(String text) {
        this.sweetAlertDialog.setConfirmText(text);
        return this;
    }

    public SAD setCancelText(String text) {
        this.sweetAlertDialog.setCancelText(text);
        return this;
    }

    public SAD setConfirmClickListener(SweetAlertDialog.OnSweetClickListener listener) {
        this.sweetAlertDialog.setConfirmClickListener(listener);
        return this;
    }

    public SAD setCancelClickListener(SweetAlertDialog.OnSweetClickListener listener) {
        this.sweetAlertDialog.setCancelClickListener(listener);
        return this;
    }

    public SAD changeAlertType(int type) {
        this.sweetAlertDialog.changeAlertType(type);
        return this;
    }

    public SAD showContentText(boolean isShow) {
        this.sweetAlertDialog.showContentText(isShow);
        return this;
    }

    public SAD showCancelButton(boolean isShow) {
        this.sweetAlertDialog.showCancelButton(isShow);
        return this;
    }

    public void show() {
        this.sweetAlertDialog.show();
    }

    public void dismiss() {
        this.sweetAlertDialog.dismiss();
    }

    public void cancel() {
        this.sweetAlertDialog.cancel();
    }

    public interface Listener extends SweetAlertDialog.OnSweetClickListener {

    }


}
