package com.ontime.controller;

import com.ontime.core.ActionContext;
import com.ontime.core.AuthUser;
import com.ontime.enums.BusinessStatusEnum;
import com.ontime.exception.YCException;
import com.ontime.handler.LoginHandler;
import com.ontime.pojo.AdminInfo;
import com.ontime.request.BaseQuery;
import com.ontime.response.AdminInfoResponse;
import com.ontime.utils.APIResponse;
import com.ontime.utils.Page;
import com.ontime.utils.YCSystemStatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by shencx on 2017/5/18.
 */
@Controller
@RequestMapping(value = "/api/web")
public class LoginController {

    Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private LoginHandler loginHandler;

    /**
     * 用户登录
     * @param request
     * @param adminInfo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public APIResponse<AdminInfoResponse> login(HttpServletRequest request, AdminInfo adminInfo){
        APIResponse<AdminInfoResponse> apiResponse = new APIResponse<AdminInfoResponse>();
        AdminInfoResponse adminInfoResponse = null;
        try {
            adminInfoResponse = loginHandler.userLogin(adminInfo);
            if (adminInfoResponse != null ){
                AuthUser authUser = ActionContext.getActionContext().currentUser();
                authUser.login(Long.valueOf(adminInfoResponse.getId()),adminInfoResponse.getUserName());
                apiResponse.setStatus(BusinessStatusEnum.SUCCESS.getStatus());
                apiResponse.setMsg(BusinessStatusEnum.SUCCESS.getDesc());
                apiResponse.setData(adminInfoResponse);
            }else {
                apiResponse.setStatus(BusinessStatusEnum.USERNAME_OR_PASSWORD_ERR.getCode());
                apiResponse.setMsg(BusinessStatusEnum.USERNAME_OR_PASSWORD_ERR.getDesc());
            }
        } catch (Throwable e) {
            LOG.error("用户登录发生异常",adminInfo);
            apiResponse.setStatus(YCSystemStatusEnum.SYSTEM_ERROR.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SYSTEM_ERROR.getDesc());
        }
        return apiResponse;
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public APIResponse login(HttpServletRequest request){
        APIResponse response = new APIResponse();
        AuthUser user = ActionContext.getActionContext().currentUser();
        user.logout();
        response.setStatus(0);
        return response;
    }

    /**
     * 获取用户列表
     * @param request
     * @param query
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public APIResponse<Page<AdminInfoResponse>> list(HttpServletRequest request, BaseQuery query){
        APIResponse<Page<AdminInfoResponse>> apiResponse = new APIResponse<>();
        Page<AdminInfoResponse> page = null;
        try {
            page = loginHandler.fetchAdminInfoPage(query);
            apiResponse.setStatus(BusinessStatusEnum.SUCCESS.getStatus());
            apiResponse.setMsg(BusinessStatusEnum.SUCCESS.getDesc());
            apiResponse.setData(page);
        } catch (Throwable e) {
            LOG.error("获取用户列表发生异常",query);
            apiResponse.setStatus(YCSystemStatusEnum.SYSTEM_ERROR.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SYSTEM_ERROR.getDesc());
        }
        return apiResponse;
    }

    /**
     * 添加帐号
     * @param request
     * @param adminInfo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public APIResponse add(HttpServletRequest request,AdminInfo adminInfo){
        APIResponse apiResponse = new APIResponse();
        try {
            loginHandler.addAdminInfo(adminInfo);
            apiResponse.setStatus(BusinessStatusEnum.SUCCESS.getStatus());
            apiResponse.setMsg(BusinessStatusEnum.SUCCESS.getDesc());
        } catch (Throwable e) {
            LOG.error("添加管理帐号发生异常",adminInfo);
            apiResponse.setStatus(YCSystemStatusEnum.SYSTEM_ERROR.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SYSTEM_ERROR.getDesc());
        }
        return apiResponse;
    }

    /**
     * 启用禁用
     * @param request
     * @param id
     * @param beUsed
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/modify_status",method = RequestMethod.POST)
    public APIResponse modify(HttpServletRequest request,Integer id,Integer beUsed){
        APIResponse apiResponse = new APIResponse();
        try {
            loginHandler.modifyStatus(id,beUsed);
            apiResponse.setStatus(BusinessStatusEnum.SUCCESS.getStatus());
            apiResponse.setMsg(BusinessStatusEnum.SUCCESS.getDesc());
        } catch (Throwable e) {
            LOG.error("更新帐号状态发生异常",id);
            apiResponse.setStatus(YCSystemStatusEnum.SYSTEM_ERROR.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SYSTEM_ERROR.getDesc());
        }
        return apiResponse;
    }

    /**
     * 获取帐号详情
     * @param request
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public APIResponse<AdminInfo> detail(HttpServletRequest request,Integer id){
        APIResponse<AdminInfo> apiResponse = new APIResponse<>();
        AdminInfo adminInfo = null;
        try {
            adminInfo = loginHandler.getAdminDetail(id);
            apiResponse.setStatus(BusinessStatusEnum.SUCCESS.getStatus());
            apiResponse.setMsg(BusinessStatusEnum.SUCCESS.getDesc());
            apiResponse.setData(adminInfo);
        } catch (Throwable e) {
            LOG.error("获取用户详情信息发生异常",id);
            apiResponse.setStatus(YCSystemStatusEnum.SYSTEM_ERROR.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SYSTEM_ERROR.getDesc());
        }
        return apiResponse;
    }
}
