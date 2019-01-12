package com.osmeet.os.base.contract;

/**
 * Created by yyj on 2018/06/28. email: 2209011667@qq.com
 */

public interface IBaseView {
    void showToast(String t);

    void showFail(int what, Object... objects);

    void showSuccess(int what, Object... objects);
}
