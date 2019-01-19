package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2019/01/19.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class Balance {

    private int availableBalance;
    private long lastWithdrawDate;
    private int usedBalanceCount;
    private String userId;

    public void setAvailableBalance(int availableBalance) {
        this.availableBalance = availableBalance;
    }

    public int getAvailableBalance() {
        return availableBalance;
    }

    public void setLastWithdrawDate(long lastWithdrawDate) {
        this.lastWithdrawDate = lastWithdrawDate;
    }

    public long getLastWithdrawDate() {
        return lastWithdrawDate;
    }

    public void setUsedBalanceCount(int usedBalanceCount) {
        this.usedBalanceCount = usedBalanceCount;
    }

    public int getUsedBalanceCount() {
        return usedBalanceCount;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

}
