package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2019/01/19.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class Balance {

    private float availableBalance;
    private long lastWithdrawDate;
    private float usedBalanceCount;
    private String userId;

    public void setAvailableBalance(float availableBalance) {
        this.availableBalance = availableBalance;
    }

    public float getAvailableBalance() {
        return availableBalance;
    }

    public void setLastWithdrawDate(long lastWithdrawDate) {
        this.lastWithdrawDate = lastWithdrawDate;
    }

    public long getLastWithdrawDate() {
        return lastWithdrawDate;
    }

    public void setUsedBalanceCount(float usedBalanceCount) {
        this.usedBalanceCount = usedBalanceCount;
    }

    public float getUsedBalanceCount() {
        return usedBalanceCount;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

}
