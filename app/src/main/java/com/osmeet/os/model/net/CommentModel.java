package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.Comment;
import com.osmeet.os.base.model.BaseModel;
import com.osmeet.os.model.net.service.CommentService;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.CommentCreateBody;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class CommentModel extends BaseModel{

    private CommentService getService() {
        return ReOk.bind().create(CommentService.class);
    }

    public void comment(Observer<Box<String>> observer, CommentCreateBody body) {
        Observable<Box<String>> observable = getService().comment(body);
        io2main(observable, observer);
    }

    public void comment_getUserCreditInfo(Observer<Box<Comment>> observer, String userId) {
        Observable<Box<Comment>> observable = getService().comment_getUserCreditInfo(userId);
        io2main(observable, observer);
    }
}
