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
     *   ��ҵ���û���½���Ʊ�����
     * Column: q_login_limit.limit_id
    @mbggenerated 2017-05-18 15:32:38
     */
    private Integer limitId;

    /**
     *   ��ҵ���û�id,ר���û�id,�����û�id
     * Column: q_login_limit.quser_id
    @mbggenerated 2017-05-18 15:32:38
     */
    private Integer quserId;

    /**
     *   ��ҵ���½����(1 ios,2 ��׿)
     * Column: q_login_limit.login_type_id
    @mbggenerated 2017-05-18 15:32:38
     */
    private Integer loginTypeId;

    /**
     *   �Ƿ������½(0������1����)
     * Column: q_login_limit.enabled
    @mbggenerated 2017-05-18 15:32:38
     */
    private Integer enabled;

    /**
     *   �޸�ʱ��
     * Column: q_login_limit.update_time
    @mbggenerated 2017-05-18 15:32:38
     */
    private Date updateTime;

    /**
     *   ������ʱ��
     * Column: q_login_limit.stop_time
    @mbggenerated 2017-05-18 15:32:38
     */
    private Date stopTime;

    /**
     *   �󶨵��豸��
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