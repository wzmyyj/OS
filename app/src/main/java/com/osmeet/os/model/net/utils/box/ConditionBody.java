package com.osmeet.os.model.net.utils.box;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class ConditionBody {
    private int distance;
    private int maxAge;
    private int minAge;
    private int sex;
    private String name;

    public ConditionBody() {
    }

    public ConditionBody(String name) {
        this.name = name;
    }

    public ConditionBody(int distance, int maxAge, int minAge, int sex) {
        this.distance = distance;
        this.maxAge = maxAge;
        this.minAge = minAge;
        this.sex = sex;
    }

//    public static ConditionBody defaultCondition() {
//        return new ConditionBody(1000, 50, 10, 1);
//    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
