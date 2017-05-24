package com.ontime.handler;

import com.ontime.core.PasswordEncrypt;
import com.ontime.enums.BusinessStatusEnum;
import com.ontime.exception.DatabaseException;
import com.ontime.exception.YCException;
import com.ontime.pojo.AdminInfo;
import com.ontime.request.BaseQuery;
import com.ontime.response.AdminInfoResponse;
import com.ontime.service.LoginService;
import com.ontime.service.impl.LoginServiceImpl;
import com.ontime.utils.DateTimeUtil;
import com.ontime.utils.Page;
import com.ontime.utils.Validator;
import com.ontime.utils.YCSystemStatusEnum;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shencx on 2017/5/18.
 */
@Service
public class LoginHandler {

    Logger LOG = LoggerFactory.getLogger(LoginHandler.class);

    @Resource
    private LoginService loginService;

    /**
     * 用户登录
     * @param adminInfo
     * @return
     * @throws YCException
     */
    public AdminInfoResponse userLogin(AdminInfo adminInfo) throws YCException {
        /** 参数校验 */
        Validator.isEmpty(adminInfo, BusinessStatusEnum.PARAM_EMPTY);
        Validator.isEmpty(adminInfo.getUserName(),"用户名称为空");
        Validator.isEmpty(adminInfo.getPassWord(),"密码为空");

        String pwd = PasswordEncrypt.encrypt(adminInfo.getUserName(),adminInfo.getPassWord());
        adminInfo.setPassWord(pwd);
        AdminInfo adminResp = null;
        try {
            adminResp = loginService.loginByNameAndPassword(adminInfo);
            AdminInfoResponse adminInfoResponse = new AdminInfoResponse();
            if (adminResp != null){
                adminInfoResponse.setId(adminResp.getId());
                adminInfoResponse.setUserName(adminResp.getUserName());
                return adminInfoResponse;
            }else {
                return null;
            }
        }  catch (DatabaseException e) {
            LOG.error("userLogin exception",adminInfo);
            throw new YCException(YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getCode(), YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getDesc());
        }
    }

    /**
     * 用户添加修改
     * @param adminInfo
     * @throws YCException
     */
    public void addAdminInfo(AdminInfo adminInfo) throws YCException {
        /** 参数校验 */
        Validator.isEmpty(adminInfo,BusinessStatusEnum.PARAM_EMPTY);
        Validator.isEmpty(adminInfo.getUserName(),"登录帐号不能为空");
        Validator.isEmpty(adminInfo.getPassWord(),"登录密码不能为空");
        String pwd = PasswordEncrypt.encrypt(adminInfo.getUserName(),adminInfo.getPassWord());
        adminInfo.setPassWord(pwd);
        try {
            if (adminInfo.getId() == null){
                loginService.addAdminInfo(adminInfo);
            }else {
                loginService.updateAdminInfo(adminInfo);
            }
        }  catch (DatabaseException e) {
            LOG.error("addAdminInfo exception",adminInfo);
            throw new YCException(YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getCode(), YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getDesc());
        }

    }

    /**
     * 获取用户列表
     * @param query
     * @return
     * @throws YCException
     */
    public Page<AdminInfoResponse> fetchAdminInfoPage(BaseQuery query) throws YCException {
        try {
            Page<AdminInfo> adminInfoPage = loginService.fetchAdminInfoPage(query);
            List<AdminInfoResponse> list = new ArrayList<>();
            if (adminInfoPage != null){
                for (AdminInfo adminInfo : adminInfoPage.getResult()){
                    AdminInfoResponse adminInfoResponse = new AdminInfoResponse();
                    adminInfoResponse.setId(adminInfo.getId());
                    adminInfoResponse.setUserName(adminInfo.getUserName());
                    adminInfoResponse.setBeUsed(adminInfo.getBeUsed().getValue());
                    adminInfoResponse.setCreateTime(DateTimeUtil.formatDate(adminInfo.getCreateTime()));
                    list.add(adminInfoResponse);
                }
            }
            Page<AdminInfoResponse> page = new Page<>();
            page.setPagesize(adminInfoPage.getPagesize());
            page.setPageindex(adminInfoPage.getPageindex());
            page.setResult(list);
            page.setTotal(adminInfoPage.getTotal());
            return page;
        } catch (DatabaseException e) {
            LOG.error("addAdminInfo exception",query);
            throw new YCException(YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getCode(), YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getDesc());
        }
    }

    /**
     * 启用禁用
     * @param id
     * @param status
     * @throws YCException
     */
    public void modifyStatus(Integer id,Integer status) throws YCException {
        /** 参数校验 */
        Validator.isEmpty(id,"主键ID不能为空");
        Validator.isEmpty(status,"状态不能为空");
        try {
            loginService.modifyStatus(id,status);
        }  catch (DatabaseException e) {
            LOG.error("modifyStatus exception",id);
            throw new YCException(YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getCode(), YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getDesc());
        }
    }

    /**
     * 获取
     * @param id
     * @return
     * @throws YCException
     */
    public AdminInfo getAdminDetail(Integer id) throws YCException {
        /** 参数校验 */
        Validator.isEmpty(id,"主键ID不能为空");
        try {
            AdminInfo adminInfo = loginService.fetchAdminInfoDetail(id);
            return adminInfo;
        }catch (DatabaseException e) {
            LOG.error("modifyStatus exception",id);
            throw new YCException(YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getCode(), YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getDesc());
        }
    }
}
