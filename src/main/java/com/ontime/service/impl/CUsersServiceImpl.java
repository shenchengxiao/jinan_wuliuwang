package com.ontime.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ontime.exception.DatabaseException;
import com.ontime.interceptor.PageMybatisInterceptor;
import com.ontime.mapper.CUsersMapper;
import com.ontime.mapper.QLoginLimitMapper;
import com.ontime.mapper.manual.CustomCUserMapper;
import com.ontime.pojo.CUsers;
import com.ontime.pojo.CUsersExample;
import com.ontime.pojo.CUsersExample.Criteria;
import com.ontime.pojo.QLoginLimit;
import com.ontime.pojo.QLoginLimitExample;
import com.ontime.request.trunk.CUserRequest;
import com.ontime.service.CUsersService;
import com.ontime.utils.Page;

@Service
public class CUsersServiceImpl implements CUsersService{
	
	@Resource
	private CUsersMapper userMapper;
	
	@Resource
	private QLoginLimitMapper limitMapper;
	@Resource
	private CustomCUserMapper lMapper;
	
	Logger LOG = LoggerFactory.getLogger(CUsersServiceImpl.class);

	@Override
	public boolean update(CUsers user) throws DatabaseException {
		try {
            if (user == null){
                LOG.error("updateUser 信息为空",user);
                return false;
            }
            int val = userMapper.updateByPrimaryKeySelective(user);
            return val>0?true:false;
        } catch (Throwable e) {
            LOG.error("updateUser 异常",user);
            throw new DatabaseException(e.getMessage());
        }
	}

	@Override
	public int insert(CUsers user) throws DatabaseException {
	 try {
            if (user == null){
                LOG.error("addUserInfo 信息为空",user);
                return Integer.valueOf(0);
            }
            int val = userMapper.insert(user);
            if (val > 0){
                return user.getCuId();
            }else {
                return Integer.valueOf(0);
            }
        } catch (Throwable e) {
            LOG.error("addUserInfo 异常",user);
            throw new DatabaseException(e.getMessage());
        }
	}
	
	@Override
	public Page<CUsers> queryUser(CUserRequest userRequest) throws DatabaseException {
		try {
			CUsersExample example = new CUsersExample();
			example.setOrderByClause("register_time desc");
			Criteria criteria = example.createCriteria();
			if(StringUtils.isNotBlank(userRequest.getUsername())){
				criteria.andUsernameEqualTo(userRequest.getUsername());
			}
			
			if(StringUtils.isNotBlank(userRequest.getCertName())){
				criteria.andCertNameEqualTo(userRequest.getCertName());
			}
			
			if(StringUtils.isNotBlank(userRequest.getCarPhone())){
				criteria.andCarPhoneLike("%"+userRequest.getCarPhone()+"%");
			}
			
			PageMybatisInterceptor.startPage(userRequest.getPageNum(),userRequest.getPageSize());
			userMapper.selectByExample(example);
            Page<CUsers> page = PageMybatisInterceptor.endPage();
			
			return page;

		} catch (Throwable e) {
	        LOG.error("queryUser 异常",userRequest);
	        throw new DatabaseException(e.getMessage());
	    }
	}
	
	@Override
	public List<CUsers> getUser(CUsers user) throws DatabaseException {
		try {
			CUsersExample example = new CUsersExample();
			Criteria criteria = example.createCriteria();
			if(user != null){
				if(user.getCuId() != null){
					criteria.andCuIdEqualTo(user.getCuId());
				}
				if(StringUtils.isNotBlank(user.getUsername())){
					criteria.andUsernameEqualTo(user.getUsername());
				}
				
				if(StringUtils.isNotBlank(user.getCertName())){
					criteria.andCertNameEqualTo(user.getCertName());
				}
				
				if(StringUtils.isNotBlank(user.getCarPhone())){
					criteria.andCarPhoneLike("%"+user.getCarPhone()+"%");
				}
			}
			
			List<CUsers> cuserList = userMapper.selectByExample(example);
			/*if(cuserList != null && cuserList.size()>0){
				for(CUsers cu : cuserList){
					
					QLoginLimitExample qexample = new QLoginLimitExample();
					com.ontime.pojo.QLoginLimitExample.Criteria qc = qexample.createCriteria();
					qc.andQuserIdEqualTo(cu.getCuId());
					qc.andIsCarEqualTo(1);
					List<QLoginLimit> loginLismitList = limitMapper.selectByExample(qexample);
					if(loginLismitList != null && loginLismitList.size()>0){
						cu.setLoginType(loginLismitList.get(0).getLoginTypeId());
						cu.setStopTime(loginLismitList.get(0).getStopTime());
					}
					
				}
			}*/
			
			return cuserList;

		} catch (Throwable e) {
	        LOG.error("getUser 异常",user);
	        throw new DatabaseException(e.getMessage());
	    }
	}

	@Override
	public int insertLimit(QLoginLimit limit) throws DatabaseException {
		try {
			int result = limitMapper.insert(limit);
			if(result>0){
				return limit.getLimitId();
			}
		} catch (Throwable e) {
	        LOG.error("insertLimit 异常",limit);
	        throw new DatabaseException(e.getMessage());
	    }
		return -1;
	}

	@Override
	public boolean updateLimit(QLoginLimit limit) throws DatabaseException {
		try {
            if (limit == null){
                LOG.error("updateLimit 信息为空",limit);
                return false;
            }
            
            QLoginLimitExample example = new QLoginLimitExample();
            com.ontime.pojo.QLoginLimitExample.Criteria criteria = example.createCriteria();
            criteria.andQuserIdEqualTo(limit.getQuserId());
            int val = limitMapper.updateByExampleSelective(limit, example);
            return val>0?true:false;
        } catch (Throwable e) {
            LOG.error("updateLimit 异常",limit);
            throw new DatabaseException(e.getMessage());
        }
	}

	@Override
	public void updateCUser(CUserRequest request) throws DatabaseException {
		try {
			CUsers user = new CUsers();
	    	user.setUsername(request.getUsername());
	    	user.setCarLength(request.getCarLength());
	    	user.setCarWeight(request.getCarWeight());
	    	user.setCertName(request.getCertName());
	    	user.setCarType(request.getCarType());
	    	user.setCarPhone(request.getCarPhone());
	    	user.setCarStatues(request.getCarStatues());
	    	user.setCarNumber1(request.getCarNumber1());
	    	user.setCarNumber2(request.getCarNumber2());
	    	user.setPassword(request.getPassword());
	    	
	    	/*QLoginLimit limit = new QLoginLimit();
	    	limit.setLoginTypeId(request.getLoginType());
	    	limit.setStopTime(request.getStopTime());*/
	    	
	        //判断ID是否为空，是则添加，否则更新
	        if (request.getId() == null) {
	
	            Integer id = userMapper.insert(user);
	
	            //添加登录绑定信息
	            if(id > 0){
	            	/*limit.setQuserId(id);
	            	limit.setEnabled(1);
	            	limitMapper.insert(limit);*/
	            }
	            
	        } else {
	        	userMapper.updateByPrimaryKeySelective(user);
	
	            //修改绑定信息
	    		/*limit.setQuserId(request.getId());
	    		QLoginLimitExample example = new QLoginLimitExample();
	            com.ontime.pojo.QLoginLimitExample.Criteria criteria = example.createCriteria();
	            criteria.andQuserIdEqualTo(limit.getQuserId());
	            int val = limitMapper.updateByExampleSelective(limit, example);*/
	
	        }
		} catch (Throwable e) {
            LOG.error("updateCUser 异常",request);
            throw new DatabaseException(e.getMessage());
        }
		
	}

	@Override
	public List<QLoginLimit> queryLimit(QLoginLimit limit) throws DatabaseException {
		
		QLoginLimitExample example = new QLoginLimitExample();
		com.ontime.pojo.QLoginLimitExample.Criteria criteria = example.createCriteria();
		criteria.andQuserIdEqualTo(limit.getQuserId());
		criteria.andIsCarEqualTo(1);
		if(limit.getEnabled() != null){
			criteria.andEnabledEqualTo(limit.getEnabled());
		}
		return limitMapper.selectByExample(example);
	}

	@Override
	public void updateLimitByKey(QLoginLimit limit) throws DatabaseException {
		try {
            if (limit == null){
                LOG.error("updateLimitByKey 信息为空",limit);
            }
            
            lMapper.updateLimitHardware(limit);
        } catch (Throwable e) {
            LOG.error("updateLimitByKey 异常",limit);
            throw new DatabaseException(e.getMessage());
        }
	}

	@Override
	public void updateLoginLimitByKey(QLoginLimit limit) throws DatabaseException {
		try {
			limit.setUpdateTime(new Date());
			limitMapper.updateByPrimaryKeySelective(limit);
		} catch (Throwable e) {
            LOG.error("updateLoginLimitByKey 异常",limit);
            throw new DatabaseException(e.getMessage());
        }
	}

}
