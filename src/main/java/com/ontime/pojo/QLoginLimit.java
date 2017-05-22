package com.ontime.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * [STRATO MyBatis Generator]
 * Table: q_login_limit
@mbggenerated do_not_delete_during_merge 2017-05-18 15:32:38
 */
public class QLoginLimit implements Serializable {
    /**
     *   企业版用户登陆限制表主键
     * Column: q_login_limit.limit_id
    @mbggenerated 2017-05-18 15:32:38
     */
    private Integer limitId;

    /**
     *   企业版用户id,专线用户id,车辆用户id
     * Column: q_login_limit.quser_id
    @mbggenerated 2017-05-18 15:32:38
     */
    private Integer quserId;

    /**
     *   企业版登陆类型(1 ios,2 安卓)
     * Column: q_login_limit.login_type_id
    @mbggenerated 2017-05-18 15:32:38
     */
    private Integer loginTypeId;

    /**
     *   是否允许登陆(0不允许1允许)
     * Column: q_login_limit.enabled
    @mbggenerated 2017-05-18 15:32:38
     */
    private Integer enabled;

    /**
     *   修改时间
     * Column: q_login_limit.update_time
    @mbggenerated 2017-05-18 15:32:38
     */
    private Date updateTime;

    /**
     *   服务到期时间
     * Column: q_login_limit.stop_time
    @mbggenerated 2017-05-18 15:32:38
     */
    private Date stopTime;

    /**
     *   绑定的设备码
     * Column: q_login_limit.hardware
    @mbggenerated 2017-05-18 15:32:38
     */
    private String hardware;

    /**
     * Table: q_login_limit
    @mbggenerated 2017-05-18 15:32:38
     */
    private static final long serialVersionUID = 1L;

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
}