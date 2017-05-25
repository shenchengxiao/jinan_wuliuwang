package com.ontime.pojo;

import com.ontime.request.BaseEntity;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class QLoginLimit extends BaseEntity {
    private Integer limitId;

    private Integer quserId;

    private Integer loginTypeId;

    private Integer enabled;

    private Date updateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stopTime;

    private String hardware;

    private Integer isCar;

    public Integer getLimitId() {
        return limitId;
    }

    public void setLimitId(Integer limitId) {
        this.limitId = limitId;
    }

    public Integer getQuserId() {
        return quserId;
    }

    public void setQuserId(Integer quserId) {
        this.quserId = quserId;
    }

    public Integer getLoginTypeId() {
        return loginTypeId;
    }

    public void setLoginTypeId(Integer loginTypeId) {
        this.loginTypeId = loginTypeId;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware == null ? null : hardware.trim();
    }

    public Integer getIsCar() {
        return isCar;
    }

    public void setIsCar(Integer isCar) {
        this.isCar = isCar;
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
        QLoginLimit other = (QLoginLimit) that;
        return (this.getLimitId() == null ? other.getLimitId() == null : this.getLimitId().equals(other.getLimitId()))
            && (this.getQuserId() == null ? other.getQuserId() == null : this.getQuserId().equals(other.getQuserId()))
            && (this.getLoginTypeId() == null ? other.getLoginTypeId() == null : this.getLoginTypeId().equals(other.getLoginTypeId()))
            && (this.getEnabled() == null ? other.getEnabled() == null : this.getEnabled().equals(other.getEnabled()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getStopTime() == null ? other.getStopTime() == null : this.getStopTime().equals(other.getStopTime()))
            && (this.getHardware() == null ? other.getHardware() == null : this.getHardware().equals(other.getHardware()))
            && (this.getIsCar() == null ? other.getIsCar() == null : this.getIsCar().equals(other.getIsCar()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLimitId() == null) ? 0 : getLimitId().hashCode());
        result = prime * result + ((getQuserId() == null) ? 0 : getQuserId().hashCode());
        result = prime * result + ((getLoginTypeId() == null) ? 0 : getLoginTypeId().hashCode());
        result = prime * result + ((getEnabled() == null) ? 0 : getEnabled().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStopTime() == null) ? 0 : getStopTime().hashCode());
        result = prime * result + ((getHardware() == null) ? 0 : getHardware().hashCode());
        result = prime * result + ((getIsCar() == null) ? 0 : getIsCar().hashCode());
        return result;
    }
}