package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.osmeet.os.app.bean.Category;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.HomeContract;
import com.osmeet.os.model.net.CategoryModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class HomePresenter extends BasePresenter<HomeContract.IView> implements HomeContract.IPresenter {

    private CategoryModel categoryModel;

    public HomePresenter(Activity activity, HomeContract.IView iv) {
        super(activity, iv);
        categoryModel = new CategoryModel().bind((AppCompatActivity) activity);
    }

    @Override
    public void loadCategoryList() {
        categoryModel.category(new PObserver<Box<ListContent<Category>>>() {
            @Override
            public void onNext(Box<ListContent<Category>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }

                if (box.getData() != null) {
                    mView.showCategoryList(box.getData().getContent());
                }


            }
        }, 0, 100);
    }
}
