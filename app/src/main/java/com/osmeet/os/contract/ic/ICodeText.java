package com.osmeet.os.contract.ic;

import android.support.annotation.NonNull;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface ICodeText {
    interface V {
        void showCodeText(@NonNull String text);
    }

    interface P {
        void loadCodeText();
    }
}
