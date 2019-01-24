package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Category;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public interface HomeContract {

    interface IView extends IBaseView {

        void showCategoryList(@NonNull List<Category> categoryList);
    }

    interface IPresenter extends IBasePresenter, I.Search ,I.Scan{

        void loadCategoryList();
    }

}
