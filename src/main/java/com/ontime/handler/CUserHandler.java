package com.ontime.handler;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ontime.core.ActionContext;
import com.ontime.core.AuthUser;
import com.ontime.exception.DatabaseException;
import com.ontime.exception.YCException;
import com.ontime.pojo.CUsers;
import com.ontime.pojo.QLoginLimit;
import com.ontime.request.trunk.CUserRequest;
import com.ontime.service.CUsersService;
import com.ontime.utils.Page;
import com.ontime.utils.Validator;
import com.ontime.utils.YCSystemStatusEnum;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


/**
 * 
 * @author zcy
 *
 */
@Service
public class CUserHandler {

    @Resource
	private CUsersService userService;

    Logger LOG = LoggerFactory.getLogger(CUserHandler.class);

    /**
     * 车主信息添加、修改
     *
     * @param request
     * @throws YCException
     */
    public void editUser(CUserRequest request) throws YCException {
        /** 参数校验 */
        Validator.isEmpty(request, YCSystemStatusEnum.PARAM_EMPTY);
        Validator.isEmpty(request.getUsername(), "账号不能为空");
        Validator.isEmpty(request.getPassword(), "密码不能为空");
        
        //车主基本信息
        try {
        	CUsers user = new CUsers();
        	user.setCuId(request.getId());
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
        	
        	
        	
            //判断ID是否为空，是则添加，否则更新
            if (request.getId() == null) {
            	AuthUser authUser = ActionContext.getActionContext().currentUser();
            	user.setAdminId(authUser.getId().intValue());
            	user.setAdminName(authUser.getName());
            	user.setRegisterTime(new Date());
            	
            	List<CUsers> cusers = userService.getUser(user);
            	
                Integer id = userService.insert(user);

                //添加登录绑定信息
                if(id > 0){
                	insertLimit(user.getCuId(), request.getAloginType(), request.getAstopTime(),2);
                	insertLimit(user.getCuId(), request.getIloginType(), request.getIstopTime(),1);
                }
                
            } else {
            	
            	user.setUpdateTime(new Date());
            	boolean result = userService.update(user);
                //修改绑定信息
            	/*if(result){
            		limit.setQuserId(request.getId());
            		limit.setUpdateTime(new Date());
            		userService.updateLimit(limit);
            	}*/

            }
        } catch (DatabaseException e) {
            LOG.error("editUser exception", request);
            throw new YCException(YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getCode(), YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getDesc());
        }
    }
    
    public void insertLimit(Integer userId,Integer loginTypeId,Date stopTime,Integer type) throws DatabaseException{
    	QLoginLimit limit = new QLoginLimit();
    	limit.setLoginTypeId(type);
    	if(loginTypeId != null){
        	limit.setStopTime(stopTime);
        	limit.setEnabled(1);
    	}
    	limit.setQuserId(userId);
    	limit.setIsCar(1);
    	userService.insertLimit(limit);
    	
    }
    
    /**
     *  车主信息
     * @param user
     * @return
     * @throws YCException
     */
    public List<CUsers> getUser(CUsers user)throws YCException{
    	try {
            
			return userService.getUser(user);
		} catch (DatabaseException e) {
			LOG.error("editUser exception", user);
            throw new YCException(YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getCode(), YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getDesc());
		}
    }
    
    /**
     * 车主信息列表
     * @param user
     * @return
     * @throws YCException
     */
    public Page<CUsers> queryCUser(CUserRequest userRequest)throws YCException{
		Page<CUsers> page = null;
        try {
            page = userService.queryUser(userRequest);
            page.setPagesize(page.getPagesize());
            page.setPageindex(page.getPageindex());
            page.setTotal(page.getTotal());
        } catch (DatabaseException e) {
            LOG.error("fetchBlackwordList exception",userRequest);
            throw new YCException(YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getCode(), YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getDesc());
        }
		return page;
    }
    
    
    public List<QLoginLimit> queryLimit(QLoginLimit limit)throws YCException{
    	List<QLoginLimit> limitlist = null;
        try {
        	limitlist = userService.queryLimit(limit);
        } catch (DatabaseException e) {
            LOG.error("queryLimit exception",limit);
            throw new YCException(YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getCode(), YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getDesc());
        }
		return limitlist;
    }
    
    public void modifyStatus(QLoginLimit limit)throws YCException{
    	try {
        	userService.updateLimitByKey(limit);
        } catch (DatabaseException e) {
            LOG.error("modifyStatus exception",limit);
            throw new YCException(YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getCode(), YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getDesc());
        }
    }

}
