package com.ontime.request.trunk;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.ontime.request.BaseQuery;

public class CUserRequest extends BaseQuery {
	
	private Integer id;
	private String username;
	private String password;
	private String certName;
	private String carPhone;
	private String carType;
	private Double carLength;
	private Double carWeight;
	private String carNumber1;
	private String carNumber2;
	private Integer carStatues;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date stopTime;
	private Integer loginType;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getCertName() {
		return certName;
	}
	public void setCertName(String certName) {
		this.certName = certName;
	}
	public String getCarPhone() {
		return carPhone;
	}
	public void setCarPhone(String carPhone) {
		this.carPhone = carPhone;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
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
		this.carNumber1 = carNumber1;
	}
	public String getCarNumber2() {
		return carNumber2;
	}
	public void setCarNumber2(String carNumber2) {
		this.carNumber2 = carNumber2;
	}
	public Integer getCarStatues() {
		return carStatues;
	}
	public void setCarStatues(Integer carStatues) {
		this.carStatues = carStatues;
	}
	public Date getStopTime() {
		return stopTime;
	}
	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}
	public Integer getLoginType() {
		return loginType;
	}
	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}
	
	

}
