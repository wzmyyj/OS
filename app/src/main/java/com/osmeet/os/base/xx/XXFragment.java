package com.osmeet.os.base.xx;


import com.osmeet.os.base.fragment.BaseFragment;

/**
 * Created by yyj on 2018/07/06. email: 2209011667@qq.com
 * 模板。建议把下面的代码复制到File->Settings->Editor->Live Templates中，在"XX"两边加$符号，即"$XX$"。
 * 先写Contract，再写Presenter，最后写Activity,Fragment，Panel。
 */

public class XXFragment extends BaseFragment<XXContract.IPresenter> implements XXContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new XXPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

}
