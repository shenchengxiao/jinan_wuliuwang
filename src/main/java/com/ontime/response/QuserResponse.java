package com.ontime.response;

import java.io.Serializable;

/**
 * Created by shencx on 2017/5/22.
 */
public class QuserResponse implements Serializable{

    private Integer quId;

    /** 帐号 */
    private String userName;

    /** 注册时间 */
    private String registerTime;

    /** 开户人 */
    private String customeName;

    /** 联系号码 */
    private String phoneNumber;

    /** 用户类型 （1、企业版 2、专心版）*/
    private Integer userType;

    public Integer getQuId() {
        return quId;
    }

    public void setQuId(Integer quId) {
        this.quId = quId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getCustomeName() {
        return customeName;
    }

    public void setCustomeName(String customeName) {
        this.customeName = customeName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("QuserResponse{");
        sb.append("quId=").append(quId);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", registerTime='").append(registerTime).append('\'');
        sb.append(", customeName='").append(customeName).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", userType=").append(userType);
        sb.append('}');
        return sb.toString();
    }
}
