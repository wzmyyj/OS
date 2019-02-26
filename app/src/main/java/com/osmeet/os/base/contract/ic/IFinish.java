package com.osmeet.os.base.contract.ic;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IFinish {

    interface V {
        int FINISH_FADE_IN_OUT = -0x12345;
        int FINISH_DEFAULT = 0;

        void showFinishActivity(int how);
    }

    interface P {
        void finish();

        void finish(int how);
    }

}
