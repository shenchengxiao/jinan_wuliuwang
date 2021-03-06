package com.ontime.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ontime.exception.DatabaseException;
import com.ontime.handler.CUserHandler;
import com.ontime.pojo.CUsers;
import com.ontime.pojo.QLoginLimit;
import com.ontime.request.trunk.CUserRequest;
import com.ontime.service.CUsersService;
import com.ontime.utils.APIResponse;
import com.ontime.utils.Page;
import com.ontime.utils.YCSystemStatusEnum;

@Controller
@RequestMapping("api/cuser")
public class CUserController {
	
	Logger LOG = LoggerFactory.getLogger(CUserController.class);
	
	@Resource
	private CUserHandler cuserHandler;
	
	/**
	 * 添加车主信息
	 * @param request
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public APIResponse addCUser(CUserRequest request){
        APIResponse apiResponse = new APIResponse<>();
        try {
        	cuserHandler.editUser(request);
            apiResponse.setStatus(YCSystemStatusEnum.SUCCESS.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SUCCESS.getDesc());
        } catch (Throwable e) {
            LOG.error("添加车主信息发生异常",request);
            apiResponse.setStatus(YCSystemStatusEnum.SYSTEM_ERROR.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SYSTEM_ERROR.getDesc());
        }
        return apiResponse;
    }
	
	/**
     * 获取用户列表
     * @param request
     * @param userRequest
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public APIResponse<Page<CUsers>> list(HttpServletRequest request, CUserRequest userRequest){
        APIResponse<Page<CUsers>> apiResponse = new APIResponse<>();
        Page<CUsers> page = null;
        try {
            page = cuserHandler.queryCUser(userRequest);
            apiResponse.setStatus(YCSystemStatusEnum.SUCCESS.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SUCCESS.getDesc());
            apiResponse.setData(page);
        } catch (Throwable e) {
            LOG.error("获取用户列表发生异常",userRequest);
            apiResponse.setStatus(YCSystemStatusEnum.SYSTEM_ERROR.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SYSTEM_ERROR.getDesc());
        }
        return apiResponse;
    }
    
    /**
     * 获取解绑列表
     * @param request
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/limitlist",method = RequestMethod.GET)
    public APIResponse<List<QLoginLimit>> limitList(HttpServletRequest request ,QLoginLimit limit){
        APIResponse<List<QLoginLimit>> apiResponse = new APIResponse<>();
        List<QLoginLimit> list = null;
        try {
        	list = cuserHandler.queryLimit(limit);
            apiResponse.setStatus(YCSystemStatusEnum.SUCCESS.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SUCCESS.getDesc());
            apiResponse.setData(list);
        } catch (Throwable e) {
            LOG.error("获取解绑列表",limit);
            apiResponse.setStatus(YCSystemStatusEnum.SYSTEM_ERROR.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SYSTEM_ERROR.getDesc());
        }
        return apiResponse;
    }
	
	@ResponseBody
    @RequestMapping(value = "/verify",method = RequestMethod.GET)
    public APIResponse<List<CUsers>> verify(HttpServletRequest request,CUsers user){
        APIResponse<List<CUsers>> apiResponse = new APIResponse<>();
        List<CUsers> list = null;
        try {
            list = cuserHandler.getUser(user);
            apiResponse.setStatus(YCSystemStatusEnum.SUCCESS.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SUCCESS.getDesc());
            apiResponse.setData(list);
        } catch (Throwable e) {
            LOG.error("获取用户信息发生异常",user);
            apiResponse.setStatus(YCSystemStatusEnum.SYSTEM_ERROR.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SYSTEM_ERROR.getDesc());
        }
        return apiResponse;
    }
	
	/**
	 * 解绑
	 * @param limit
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/modify_status",method = RequestMethod.POST)
    public APIResponse modifyStatus(QLoginLimit limit){
        APIResponse apiResponse = new APIResponse<>();
        try {
        	cuserHandler.modifyStatus(limit);
            apiResponse.setStatus(YCSystemStatusEnum.SUCCESS.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SUCCESS.getDesc());
        } catch (Throwable e) {
            LOG.error("解绑发生异常",limit);
            apiResponse.setStatus(YCSystemStatusEnum.SYSTEM_ERROR.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SYSTEM_ERROR.getDesc());
        }
        return apiResponse;
    }
	
	@ResponseBody
    @RequestMapping(value = "/modify_limit",method = RequestMethod.POST)
    public APIResponse modifyLimit(QLoginLimit limit){
        APIResponse apiResponse = new APIResponse<>();
        try {
        	cuserHandler.modifyLimit(limit);
            apiResponse.setStatus(YCSystemStatusEnum.SUCCESS.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SUCCESS.getDesc());
        } catch (Throwable e) {
            LOG.error("解绑发生异常",limit);
            apiResponse.setStatus(YCSystemStatusEnum.SYSTEM_ERROR.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SYSTEM_ERROR.getDesc());
        }
        return apiResponse;
    }

}
