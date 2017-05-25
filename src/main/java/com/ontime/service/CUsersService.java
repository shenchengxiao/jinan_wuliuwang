package com.ontime.service;

import java.util.List;

import com.ontime.exception.DatabaseException;
import com.ontime.pojo.CUsers;
import com.ontime.pojo.QLoginLimit;
import com.ontime.request.trunk.CUserRequest;
import com.ontime.utils.Page;

public interface CUsersService {
	
	public boolean update(CUsers user) throws DatabaseException; 
	
	public int insert(CUsers user) throws DatabaseException; 
	
	public Page<CUsers> queryUser(CUserRequest userRequest) throws DatabaseException;
	public List<CUsers> getUser(CUsers user) throws DatabaseException;
	
	public int insertLimit(QLoginLimit limit) throws DatabaseException; 
	
	public boolean updateLimit(QLoginLimit limit) throws DatabaseException; 
	
	public void updateCUser(CUserRequest user) throws DatabaseException; 
	
	public List<QLoginLimit> queryLimit(QLoginLimit limit) throws DatabaseException; 
	
	public void updateLimitByKey(QLoginLimit limit) throws DatabaseException;
	
	public void updateLoginLimitByKey(QLoginLimit limit) throws DatabaseException;

}
