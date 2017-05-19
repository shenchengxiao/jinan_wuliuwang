package com.ontime.handler;

import com.ontime.core.PasswordEncrypt;
import com.ontime.enums.BusinessStatusEnum;
import com.ontime.exception.DatabaseException;
import com.ontime.exception.YCException;
import com.ontime.pojo.AdminInfo;
import com.ontime.response.AdminInfoResponse;
import com.ontime.service.LoginService;
import com.ontime.service.impl.LoginServiceImpl;
import com.ontime.utils.Validator;
import com.ontime.utils.YCSystemStatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
