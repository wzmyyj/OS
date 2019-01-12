package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.Region;
import com.osmeet.os.model.net.service.RegionService;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.app.utils.SubscribeUtil;
import com.osmeet.os.model.net.utils.box.Box;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class RegionModel {

    private RegionService getService() {
        return ReOk.bind().create(RegionService.class);
    }

    public void region_all(Observer<Box<List<Region>>> observer) {
        Observable<Box<List<Region>>> observable = getService().region_all();
        SubscribeUtil.io2main(observable, observer);
    }

    public void region_city(Observer<Box<List<Region>>> observer) {
        Observable<Box<List<Region>>> observable = getService().region_city();
        SubscribeUtil.io2main(observable, observer);
    }

    public void region_district(Observer<Box<List<Region>>> observer, String cityId) {
        Observable<Box<List<Region>>> observable = getService().region_district(cityId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void region_road(Observer<Box<List<Region>>> observer, String districtId) {
        Observable<Box<List<Region>>> observable = getService().region_road(districtId);
        SubscribeUtil.io2main(observable, observer);
    }

}
