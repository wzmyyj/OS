package com.osmeet.os.contract.ic;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Category;

import java.util.List;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface ICategoryList {
    interface V {
        void showCategoryList(@NonNull List<Category> categoryList);
    }

    interface P {
        void loadCategoryList();
    }
}
