package com.osmeet.os.app.utils;

import com.amap.api.location.CoordinateConverter;
import com.amap.api.location.DPoint;
import com.osmeet.os.app.application.App;

import java.text.DecimalFormat;

/**
 * Created by yyj on 2019/02/27.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class DistanceUtil {
    public static String distance(double latitude, double longitude) {
        DPoint dPoint = new DPoint();
        dPoint.setLatitude(latitude);
        dPoint.setLongitude(latitude);
        float distance = CoordinateConverter.calculateLineDistance(App.getInstance().getMyDPoint(), dPoint) / 1000;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(distance) + "km";
    }
}
