package com.osmeet.os.base.contract.ip;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by yyj on 2018/11/20.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IContext {

    Context getContext();

    Activity getActivity();

    Fragment getFragment();

}
