package com.osmeet.os.model.net;

import com.osmeet.os.model.net.service.DictionaryService;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.app.utils.SubscribeUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class DictionaryModel {

    private DictionaryService getService() {
        return ReOk.bind().create(DictionaryService.class);
    }

    public void dictionary_errors(Observer<String> observer) {
        Observable<String> observable = getService().dictionary_errors();
        SubscribeUtil.io2main(observable, observer);
    }
}
