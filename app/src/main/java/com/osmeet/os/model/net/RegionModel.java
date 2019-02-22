package com.osmeet.os.model.net;

import com.osmeet.os.app.bean.Region;
import com.osmeet.os.base.model.BaseModel;
import com.osmeet.os.model.net.service.RegionService;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.model.net.utils.box.Box;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class RegionModel  extends BaseModel {

    private RegionService getService() {
        return ReOk.bind().create(RegionService.class);
    }

    public void region_all(Observer<Box<List<Region>>> observer) {
        Observable<Box<List<Region>>> observable = getService().region_all();
        io2main(observable, observer);
    }

    public void region_city(Observer<Box<List<Region>>> observer) {
        Observable<Box<List<Region>>> observable = getService().region_city();
        io2main(observable, observer);
    }

    public void region_district(Observer<Box<List<Region>>> observer, String cityId) {
        Observable<Box<List<Region>>> observable = getService().region_district(cityId);
        io2main(observable, observer);
    }

    public void region_road(Observer<Box<List<Region>>> observer, String districtId) {
        Observable<Box<List<Region>>> observable = getService().region_road(districtId);
        io2main(observable, observer);
    }

}
