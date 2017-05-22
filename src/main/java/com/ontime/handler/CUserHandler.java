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
import com.ontime.utils.Validator;
import com.ontime.utils.YCSystemStatusEnum;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
        	
        	QLoginLimit limit = new QLoginLimit();
        	limit.setLoginTypeId(request.getLoginType());
        	limit.setStopTime(request.getStopTime());
        	
            //判断ID是否为空，是则添加，否则更新
            if (request.getCuId() == null) {
            	/*AuthUser authUser = ActionContext.getActionContext().currentUser();
            	user.setAdminId(authUser.getId().intValue());*/

                Integer id = userService.insert(user);

                //添加登录绑定信息
                if(id > 0){
                	limit.setQuserId(id);
                	limit.setEnabled(1);
                	userService.insertLimit(limit);
                }
                
            } else {
            	boolean result = userService.update(user);

                //修改绑定信息
            	if(result){
            		limit.setQuserId(request.getCuId());
            		userService.updateLimit(limit);
            	}

            }
        } catch (DatabaseException e) {
            LOG.error("editUser exception", request);
            throw new YCException(YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getCode(), YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getDesc());
        }
    }
    
    
    public List<CUsers> queryCUser(CUsers user)throws YCException{
    	try {
			return userService.queryUser(user);
		} catch (DatabaseException e) {
			LOG.error("editUser exception", user);
            throw new YCException(YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getCode(), YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getDesc());
		}
    }

}
