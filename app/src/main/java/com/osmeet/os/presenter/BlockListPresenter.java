package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.BlockListContract;

/**
 * Created by yyj on 2019/02/18.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class BlockListPresenter extends BasePresenter<BlockListContract.IView> implements BlockListContract.IPresenter {

    public BlockListPresenter(Activity activity, BlockListContract.IView iv) {
        super(activity, iv);
    }
}
