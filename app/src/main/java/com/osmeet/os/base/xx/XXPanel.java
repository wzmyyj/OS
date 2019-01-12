package com.osmeet.os.base.xx;

import android.content.Context;

import com.osmeet.os.base.panel.BasePanel;


/**
 * Created by yyj on 2018/08/06. email: 2209011667@qq.com
 * 模板。建议把下面的代码复制到File->Settings->Editor->Live Templates中，在"XX"两边加$符号，即"$XX$"。
 * 先写Contract，再写Presenter，最后写Activity,Fragment，Panel。
 */

public class XXPanel extends BasePanel<XXContract.IPresenter> {

    public XXPanel(Context context, XXContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

}
