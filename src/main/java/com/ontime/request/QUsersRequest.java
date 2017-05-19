package com.ontime.request;

/**
 * Created by shencx on 2017/5/19.
 */
public class QUsersRequest extends BaseQuery{

    /** 帐号 */
    private String accountName;

    /** 开户人名称 */
    private String userName;

    /** 电话 */
    private String phoneNumber;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
