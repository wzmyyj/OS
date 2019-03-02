package com.osmeet.os.presenter;

import android.support.v4.app.Fragment;

import com.osmeet.os.app.bean.Category;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.HomeContract;
import com.osmeet.os.model.net.CategoryModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class HomePresenter extends BasePresenter<HomeContract.IView> implements HomeContract.IPresenter {

    private CategoryModel categoryModel;

    public HomePresenter(Fragment fragment, HomeContract.IView iv) {
        super(fragment, iv);
        categoryModel = new CategoryModel().bind(fragment);
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
                    List<Category> categoryList = new ArrayList<>();
                    categoryList.addAll(box.getData().getContent());
                    categoryList.addAll(box.getData().getContent());
                    categoryList.addAll(box.getData().getContent());
                    mView.showCategoryList(categoryList);
                }


            }
        }, 0, 100);
    }
}
