package com.ontime.pojo;

import com.ontime.request.BaseEntity;
import java.util.Date;

public class CUsers extends BaseEntity {
    private Integer cuId;

    private String username;

    private String password;

    private Date registerTime;

    private Date updateTime;

    private String certName;

    private String carPhone;

    private String carType;

    private Double carLength;

    private Double carWeight;

    private String carNumber1;

    private String carNumber2;

    private String remark;

    private Integer adminId;

    private Date startTime;

    private Integer carStatues;

    public Integer getCuId() {
        return cuId;
    }

    public void setCuId(Integer cuId) {
        this.cuId = cuId;
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

    public String getCarPhone() {
        return carPhone;
    }

    public void setCarPhone(String carPhone) {
        this.carPhone = carPhone == null ? null : carPhone.trim();
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    public Double getCarLength() {
        return carLength;
    }

    public void setCarLength(Double carLength) {
        this.carLength = carLength;
    }

    public Double getCarWeight() {
        return carWeight;
    }

    public void setCarWeight(Double carWeight) {
        this.carWeight = carWeight;
    }

    public String getCarNumber1() {
        return carNumber1;
    }

    public void setCarNumber1(String carNumber1) {
        this.carNumber1 = carNumber1 == null ? null : carNumber1.trim();
    }

    public String getCarNumber2() {
        return carNumber2;
    }

    public void setCarNumber2(String carNumber2) {
        this.carNumber2 = carNumber2 == null ? null : carNumber2.trim();
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

    public Integer getCarStatues() {
        return carStatues;
    }

    public void setCarStatues(Integer carStatues) {
        this.carStatues = carStatues;
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
        CUsers other = (CUsers) that;
        return (this.getCuId() == null ? other.getCuId() == null : this.getCuId().equals(other.getCuId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getRegisterTime() == null ? other.getRegisterTime() == null : this.getRegisterTime().equals(other.getRegisterTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCertName() == null ? other.getCertName() == null : this.getCertName().equals(other.getCertName()))
            && (this.getCarPhone() == null ? other.getCarPhone() == null : this.getCarPhone().equals(other.getCarPhone()))
            && (this.getCarType() == null ? other.getCarType() == null : this.getCarType().equals(other.getCarType()))
            && (this.getCarLength() == null ? other.getCarLength() == null : this.getCarLength().equals(other.getCarLength()))
            && (this.getCarWeight() == null ? other.getCarWeight() == null : this.getCarWeight().equals(other.getCarWeight()))
            && (this.getCarNumber1() == null ? other.getCarNumber1() == null : this.getCarNumber1().equals(other.getCarNumber1()))
            && (this.getCarNumber2() == null ? other.getCarNumber2() == null : this.getCarNumber2().equals(other.getCarNumber2()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getCarStatues() == null ? other.getCarStatues() == null : this.getCarStatues().equals(other.getCarStatues()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCuId() == null) ? 0 : getCuId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getRegisterTime() == null) ? 0 : getRegisterTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCertName() == null) ? 0 : getCertName().hashCode());
        result = prime * result + ((getCarPhone() == null) ? 0 : getCarPhone().hashCode());
        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());
        result = prime * result + ((getCarLength() == null) ? 0 : getCarLength().hashCode());
        result = prime * result + ((getCarWeight() == null) ? 0 : getCarWeight().hashCode());
        result = prime * result + ((getCarNumber1() == null) ? 0 : getCarNumber1().hashCode());
        result = prime * result + ((getCarNumber2() == null) ? 0 : getCarNumber2().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getCarStatues() == null) ? 0 : getCarStatues().hashCode());
        return result;
    }
}