package com.ontime.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * [STRATO MyBatis Generator]
 * Table: c_users
@mbggenerated do_not_delete_during_merge 2017-05-19 15:36:09
 */
public class CUsers implements Serializable {
    /**
     *   �������û�������
     * Column: c_users.cu_id
    @mbggenerated 2017-05-19 15:36:09
     */
    private Integer cuId;

    /**
     *   �˺�
     * Column: c_users.username
    @mbggenerated 2017-05-19 15:36:09
     */
    private String username;

    /**
     *   ����
     * Column: c_users.password
    @mbggenerated 2017-05-19 15:36:09
     */
    private String password;

    /**
     *   ע��ʱ��
     * Column: c_users.register_time
    @mbggenerated 2017-05-19 15:36:09
     */
    private Date registerTime;

    /**
     *   �޸�ʱ��
     * Column: c_users.update_time
    @mbggenerated 2017-05-19 15:36:09
     */
    private Date updateTime;

    /**
     *   ��ʵ����
     * Column: c_users.cert_name
    @mbggenerated 2017-05-19 15:36:09
     */
    private String certName;

    /**
     *   �泵�绰
     * Column: c_users.car_phone
    @mbggenerated 2017-05-19 15:36:09
     */
    private String carPhone;

    /**
     *   ������
     * Column: c_users.car_type
    @mbggenerated 2017-05-19 15:36:09
     */
    private String carType;

    /**
     *   ����
     * Column: c_users.car_length
    @mbggenerated 2017-05-19 15:36:09
     */
    private Double carLength;

    /**
     *   ��λ
     * Column: c_users.car_weight
    @mbggenerated 2017-05-19 15:36:09
     */
    private Double carWeight;

    /**
     *   ���ƺ�1
     * Column: c_users.car_number1
    @mbggenerated 2017-05-19 15:36:09
     */
    private String carNumber1;

    /**
     *   ���ƺ�2
     * Column: c_users.car_number2
    @mbggenerated 2017-05-19 15:36:09
     */
    private String carNumber2;

    /**
     *   ��ע
     * Column: c_users.remark
    @mbggenerated 2017-05-19 15:36:09
     */
    private String remark;

    /**
     *   ������id
     * Column: c_users.admin_id
    @mbggenerated 2017-05-19 15:36:09
     */
    private Integer adminId;

    /**
     *   ����ʱ��
     * Column: c_users.start_time
    @mbggenerated 2017-05-19 15:36:09
     */
    private Date startTime;

    /**
     *   ����״̬(0�ճ�ģʽ 1����ģʽ)
     * Column: c_users.car_statues
    @mbggenerated 2017-05-19 15:36:09
     */
    private Integer carStatues;

    /**
     * Table: c_users
    @mbggenerated 2017-05-19 15:36:09
     */
    private static final long serialVersionUID = 1L;

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
}