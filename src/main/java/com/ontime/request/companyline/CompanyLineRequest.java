package com.ontime.request.companyline;

/**
 * Created by shencx on 2017/5/25.
 */
public class CompanyLineRequest {
    private Integer quId;

    /** 帐号 */
    private String username;

    /** 密码 */
    private String password;

    /** 联系电话 */
    private String phone;

    /** 姓名 */
    private String certName;

    /** 身份证号 */
    private String certNumber;

    /** 身份证地址 */
    private String certAddress;

    /** 公司名称 */
    private String compName;

    /** 公司地址 */
    private String compAddress;

    /** 公司电话 */
    private String compPhone;

    /** 公司描述 */
    private String compIntroduction;

    /** 备注 */
    private String remark;

    /** 用户类型 */
    private Integer userTypeId;

    /** 专线城市 */
    private String zlineCity;

    /** 安卓类型 */
    private Integer aloginType;

    /** iOS类型 */
    private Integer iloginType;

    /** 安卓到期时间 */
    private String astopTime;

    /** iOS到期时间 */
    private String istopTime;

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
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public String getCertNumber() {
        return certNumber;
    }

    public void setCertNumber(String certNumber) {
        this.certNumber = certNumber;
    }

    public String getCertAddress() {
        return certAddress;
    }

    public void setCertAddress(String certAddress) {
        this.certAddress = certAddress;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompAddress() {
        return compAddress;
    }

    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress;
    }

    public String getCompPhone() {
        return compPhone;
    }

    public void setCompPhone(String compPhone) {
        this.compPhone = compPhone;
    }

    public String getCompIntroduction() {
        return compIntroduction;
    }

    public void setCompIntroduction(String compIntroduction) {
        this.compIntroduction = compIntroduction;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        this.zlineCity = zlineCity;
    }

    public Integer getAloginType() {
        return aloginType;
    }

    public void setAloginType(Integer aloginType) {
        this.aloginType = aloginType;
    }

    public Integer getIloginType() {
        return iloginType;
    }

    public void setIloginType(Integer iloginType) {
        this.iloginType = iloginType;
    }

    public String getAstopTime() {
        return astopTime;
    }

    public void setAstopTime(String astopTime) {
        this.astopTime = astopTime;
    }

    public String getIstopTime() {
        return istopTime;
    }

    public void setIstopTime(String istopTime) {
        this.istopTime = istopTime;
    }
}
