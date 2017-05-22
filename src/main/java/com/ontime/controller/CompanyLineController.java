package com.ontime.controller;

import com.ontime.enums.BusinessStatusEnum;
import com.ontime.exception.YCException;
import com.ontime.handler.CompanyLineHandler;
import com.ontime.pojo.QUsers;
import com.ontime.request.QUsersRequest;
import com.ontime.response.QuserResponse;
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
 * Created by shencx on 2017/5/22.
 */
@Controller
@RequestMapping(value = "/api/company_line")
public class CompanyLineController {

    @Resource
    private CompanyLineHandler companyLineHandler;

    Logger LOG = LoggerFactory.getLogger(CompanyLineController.class);

    /**
     * 添加企业或者专业版用户信息
     * @param request
     * @param qUsers
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public APIResponse add(HttpServletRequest request , QUsers qUsers){
        APIResponse apiResponse = new APIResponse();
        try {
            companyLineHandler.addCompanyLineUser(qUsers);
            apiResponse.setStatus(BusinessStatusEnum.SUCCESS.getCode());
            apiResponse.setMsg(BusinessStatusEnum.SUCCESS.getDesc());
        } catch (Throwable e) {
            LOG.error("添加用户发生异常",qUsers);
            apiResponse.setStatus(YCSystemStatusEnum.SYSTEM_ERROR.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SYSTEM_ERROR.getDesc());
        }
        return apiResponse;
    }

    /**
     * 获取企业版与专线版用户信息
     * @param request
     * @param qUsersRequest
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public APIResponse<Page<QuserResponse>> list(HttpServletRequest request , QUsersRequest qUsersRequest){
        APIResponse<Page<QuserResponse>> apiResponse = new APIResponse<>();
        Page<QuserResponse> page = null;
        try {
            page = companyLineHandler.fetchQuserInfoPage(qUsersRequest);
            apiResponse.setStatus(BusinessStatusEnum.SUCCESS.getCode());
            apiResponse.setMsg(BusinessStatusEnum.SUCCESS.getDesc());
            apiResponse.setData(page);
        } catch (Throwable e) {
            LOG.error("获取企业和专线用户发生异常",qUsersRequest);
            apiResponse.setStatus(YCSystemStatusEnum.SYSTEM_ERROR.getCode());
            apiResponse.setMsg(YCSystemStatusEnum.SYSTEM_ERROR.getDesc());
        }
        return apiResponse;
    }
}
