package com.ontime.pojo;

import com.ontime.request.BaseEntity;
import java.util.Date;

public class QUsers extends BaseEntity {
    private Integer quId;

    private String username;

    private String password;

    private String phone;

    private Date registerTime;

    private Date updateTime;

    private String certName;

    private String certNumber;

    private String certAddress;

    private String compName;

    private String compAddress;

    private String compPhone;

    private String compIntroduction;

    private String remark;

    private Integer adminId;

    private Date startTime;

    private Integer userTypeId;

    private String zlineCity;

    public Integer getQuId() {
        return quId;
    }

    public void setQuId(Integer quId) {
        this.quId = quId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName == null ? null : certName.trim();
    }

    public String getCertNumber() {
        return certNumber;
    }

    public void setCertNumber(String certNumber) {
        this.certNumber = certNumber == null ? null : certNumber.trim();
    }

    public String getCertAddress() {
        return certAddress;
    }

    public void setCertAddress(String certAddress) {
        this.certAddress = certAddress == null ? null : certAddress.trim();
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName == null ? null : compName.trim();
    }

    public String getCompAddress() {
        return compAddress;
    }

    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress == null ? null : compAddress.trim();
    }

    public String getCompPhone() {
        return compPhone;
    }

    public void setCompPhone(String compPhone) {
        this.compPhone = compPhone == null ? null : compPhone.trim();
    }

    public String getCompIntroduction() {
        return compIntroduction;
    }

    public void setCompIntroduction(String compIntroduction) {
        this.compIntroduction = compIntroduction == null ? null : compIntroduction.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getZlineCity() {
        return zlineCity;
    }

    public void setZlineCity(String zlineCity) {
        this.zlineCity = zlineCity == null ? null : zlineCity.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        QUsers other = (QUsers) that;
        return (this.getQuId() == null ? other.getQuId() == null : this.getQuId().equals(other.getQuId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getRegisterTime() == null ? other.getRegisterTime() == null : this.getRegisterTime().equals(other.getRegisterTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCertName() == null ? other.getCertName() == null : this.getCertName().equals(other.getCertName()))
            && (this.getCertNumber() == null ? other.getCertNumber() == null : this.getCertNumber().equals(other.getCertNumber()))
            && (this.getCertAddress() == null ? other.getCertAddress() == null : this.getCertAddress().equals(other.getCertAddress()))
            && (this.getCompName() == null ? other.getCompName() == null : this.getCompName().equals(other.getCompName()))
            && (this.getCompAddress() == null ? other.getCompAddress() == null : this.getCompAddress().equals(other.getCompAddress()))
            && (this.getCompPhone() == null ? other.getCompPhone() == null : this.getCompPhone().equals(other.getCompPhone()))
            && (this.getCompIntroduction() == null ? other.getCompIntroduction() == null : this.getCompIntroduction().equals(other.getCompIntroduction()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getUserTypeId() == null ? other.getUserTypeId() == null : this.getUserTypeId().equals(other.getUserTypeId()))
            && (this.getZlineCity() == null ? other.getZlineCity() == null : this.getZlineCity().equals(other.getZlineCity()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getQuId() == null) ? 0 : getQuId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getRegisterTime() == null) ? 0 : getRegisterTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCertName() == null) ? 0 : getCertName().hashCode());
        result = prime * result + ((getCertNumber() == null) ? 0 : getCertNumber().hashCode());
        result = prime * result + ((getCertAddress() == null) ? 0 : getCertAddress().hashCode());
        result = prime * result + ((getCompName() == null) ? 0 : getCompName().hashCode());
        result = prime * result + ((getCompAddress() == null) ? 0 : getCompAddress().hashCode());
        result = prime * result + ((getCompPhone() == null) ? 0 : getCompPhone().hashCode());
        result = prime * result + ((getCompIntroduction() == null) ? 0 : getCompIntroduction().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getUserTypeId() == null) ? 0 : getUserTypeId().hashCode());
        result = prime * result + ((getZlineCity() == null) ? 0 : getZlineCity().hashCode());
        return result;
    }
}