package com.osmeet.os.base.contract.iv;

/**
 * Created by yyj on 2019/01/18.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IFinishActivity {
    int FINISH_FADE_IN_OUT = -0x12345;
    int FINISH_DEFAULT = 0;

    void showFinishActivity(int how);
}
