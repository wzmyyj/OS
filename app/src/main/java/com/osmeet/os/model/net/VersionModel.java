package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.Code;
import com.osmeet.os.app.utils.SubscribeUtil;
import com.osmeet.os.model.net.service.VersionService;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.model.net.utils.box.Box;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2019/02/18.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class VersionModel {

    private VersionService getService() {
        return ReOk.bind().create(VersionService.class);
    }

    public void version_code_concat(Observer<Box<String>> observer, Code code) {
        Observable<Box<String>> observable = getService().version_code_concat(code);
        SubscribeUtil.io2main(observable, observer);
    }

    public void version_code_resolve(Observer<Box<Code>> observer, String info) {
        Observable<Box<Code>> observable = getService().version_code_resolve(info);
        SubscribeUtil.io2main(observable, observer);
    }
}
