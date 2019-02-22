package com.osmeet.os.model.net;


import com.osmeet.os.app.bean.Report;
import com.osmeet.os.base.model.BaseModel;
import com.osmeet.os.model.net.service.ReportService;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.model.net.utils.box.Box;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class ReportModel extends BaseModel{

    private ReportService getService() {
        return ReOk.bind().create(ReportService.class);
    }

    public void report(Observer<Box<Report>> observer, Report report) {
        Observable<Box<Report>> observable = getService().report(report);
        io2main(observable, observer);
    }
}
