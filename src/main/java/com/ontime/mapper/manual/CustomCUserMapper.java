package com.ontime.mapper.manual;

import org.springframework.stereotype.Repository;

import com.ontime.pojo.QLoginLimit;

@Repository
public interface CustomCUserMapper {
	
	public int updateLimitHardware(QLoginLimit limit);

}
