package com.osmeet.os.contract;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public interface SingleMapContract {

    interface IView extends IBaseView {


    }

    interface IPresenter extends IBasePresenter, I.AMap{

    }

}
