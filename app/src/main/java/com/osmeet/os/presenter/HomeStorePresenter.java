package com.osmeet.os.presenter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.osmeet.os.app.bean.Store;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.HomeStoreContract;
import com.osmeet.os.model.net.StoreModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class HomeStorePresenter extends BasePresenter<HomeStoreContract.IView> implements HomeStoreContract.IPresenter {

    private StoreModel storeModel;

    public HomeStorePresenter(Fragment fragment, HomeStoreContract.IView iv) {
        super(fragment, iv);
        storeModel = new StoreModel().bind(fragment);
    }

    private String categoryId;

    @Override
    public void setCategoryId(@NonNull String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String getCategoryId() {
        return categoryId;
    }

    @Override
    public void loadStoreList(final int pageNum) {
        if (TextUtils.isEmpty(categoryId)) {
            toast("Category Id is a empty value!");
            return;
        }
        storeModel.store_category(new PObserver<Box<ListContent<Store>>>() {
            @Override
            public void onNext(Box<ListContent<Store>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
//                    toast("加载成功");
//                    List<Store> storeList = new ArrayList<>();
//                    storeList.addAll(box.getData().getContent());
//                    storeList.addAll(box.getData().getContent());// test
//                    storeList.addAll(box.getData().getContent());
//                    storeList.addAll(box.getData().getContent());
//                    storeList.addAll(box.getData().getContent());
                    mView.showStoreList(box.getData().getContent(), pageNum);
                }

            }
        }, categoryId, pageNum, 20);
    }



}
