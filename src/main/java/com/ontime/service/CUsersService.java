package com.ontime.service;

import java.util.List;

import com.ontime.exception.DatabaseException;
import com.ontime.pojo.CUsers;
import com.ontime.pojo.QLoginLimit;
import com.ontime.request.trunk.CUserRequest;

public interface CUsersService {
	
	public boolean update(CUsers user) throws DatabaseException; 
	
	public int insert(CUsers user) throws DatabaseException; 
	
	public List<CUsers> queryUser(CUsers user) throws DatabaseException;
	
	public int insertLimit(QLoginLimit limit) throws DatabaseException; 
	
	public boolean updateLimit(QLoginLimit limit) throws DatabaseException; 
	
	public void updateCUser(CUserRequest user) throws DatabaseException; 

}
