package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.Category;
import com.osmeet.os.base.model.BaseModel;
import com.osmeet.os.model.net.service.CategoryService;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class CategoryModel extends BaseModel {

    private CategoryService getService() {
        return ReOk.bind().create(CategoryService.class);
    }

    public void category(Observer<Box<ListContent<Category>>> observer, int pageNum, int pageSize) {
        Observable<Box<ListContent<Category>>> observable = getService().category(pageNum, pageSize);
        io2main(observable, observer);
    }
}
