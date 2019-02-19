package com.osmeet.os.app.application;

import android.content.Context;

/**
 * Created by yyj on 2018/12/28. email: 2209011667@qq.com
 * 单例。
 */

public final class LanguageManager {
    private LanguageManager() {

    }

    private static class Holder {
        private static LanguageManager manager = new LanguageManager();
    }

    public static LanguageManager getInstance() {
        return Holder.manager;
    }


    private void init(Context context) {

    }





}
