package com.osmeet.os.base.contract.iv;

/**
 * Created by yyj on 2019/01/14.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IShowProcess {

    int PROCESS_DEFAULT = -0x10000;

    void showStart(int what, Object... objects);

    void showProgress(int what, int progress, Object... objects);

    void showCancel(int what, int progress, Object... objects);

    void showFail(int what, Object... objects);

    void showSuccess(int what, Object... objects);

    void showFinish(int what, Object... objects);
}
