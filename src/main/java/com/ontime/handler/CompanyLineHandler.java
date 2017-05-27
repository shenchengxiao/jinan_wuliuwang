package com.ontime.handler;

import com.ontime.core.ActionContext;
import com.ontime.enums.BusinessStatusEnum;
import com.ontime.exception.DatabaseException;
import com.ontime.exception.ValidationException;
import com.ontime.exception.YCException;
import com.ontime.pojo.CUsers;
import com.ontime.pojo.QLoginLimit;
import com.ontime.pojo.QUsers;
import com.ontime.request.QUsersRequest;
import com.ontime.request.companyline.CompanyLineRequest;
import com.ontime.response.QuserResponse;
import com.ontime.service.CUsersService;
import com.ontime.service.CompanyLineService;
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
import java.util.Date;
import java.util.List;

/**
 * Created by shencx on 2017/5/22.
 */
@Service
public class CompanyLineHandler {

    Logger LOG = LoggerFactory.getLogger(CompanyLineHandler.class);

    @Resource
    private CompanyLineService companyLineService;

    @Resource
    private CUsersService cUsersService;

    /**
     * 添加修改
     * @param companyLineRequest
     * @throws YCException
     */
    public void addCompanyLineUser(CompanyLineRequest companyLineRequest) throws YCException {
        /** 参数校验 */
        Validator.isEmpty(companyLineRequest, BusinessStatusEnum.PARAM_EMPTY);
        Validator.isEmpty(companyLineRequest.getUsername(),"帐号不能为空");
        Validator.isEmpty(companyLineRequest.getPassword(),"用户密码不能为空");
        Validator.isEmpty(companyLineRequest.getCertName(),"用户姓名不能为空");
        Validator.isEmpty(companyLineRequest.getPhone(),"联系方式不能为空");
        Validator.isEmpty(companyLineRequest.getCertNumber(),"身份证号码不能为空");

        QUsers qUsers = new QUsers();
        qUsers.setQuId(companyLineRequest.getQuId());
        qUsers.setUsername(companyLineRequest.getUsername());
        qUsers.setPassword(companyLineRequest.getPassword());
        qUsers.setPhone(companyLineRequest.getPhone());
        qUsers.setCertName(companyLineRequest.getCertName());
        qUsers.setCertNumber(companyLineRequest.getCertNumber());
        qUsers.setCertAddress(companyLineRequest.getCertAddress());
        qUsers.setCompName(companyLineRequest.getCompName());
        qUsers.setCompAddress(companyLineRequest.getCompAddress());
        qUsers.setCompPhone(companyLineRequest.getCompPhone());
        qUsers.setCompIntroduction(companyLineRequest.getCompIntroduction());
        qUsers.setRemark(companyLineRequest.getRemark());
        qUsers.setUserTypeId(companyLineRequest.getUserTypeId());
        qUsers.setZlineCity(companyLineRequest.getZlineCity());
        /** 操作人 ID */
        qUsers.setAdminId(ActionContext.getActionContext().currentUser().getId().intValue());
        try {
            if (qUsers.getQuId() == null){
                Integer id = companyLineService.addQUsersInfo(qUsers);
                if (id > 0){
                    //android与iOS登录限制信息入库
                    addLimitInfo(id,companyLineRequest.getAstopTime(),2);
                    addLimitInfo(id,companyLineRequest.getIstopTime(),1);
                }
            }else {
                companyLineService.updateQUsersInfo(qUsers);
            }
        }  catch (DatabaseException e) {
            LOG.error("addCompanyLineUser exception",companyLineRequest);
            throw new YCException(YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getCode(), YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getDesc());
        }
    }


    /**
     * 获取企业、专线版列表
     * @param qUsersRequest
     * @return
     * @throws YCException
     */
    public Page<QuserResponse> fetchQuserInfoPage(QUsersRequest qUsersRequest) throws YCException {
        try {
            Page<QUsers> qUsersPage = companyLineService.fetchQUsersPage(qUsersRequest);
            List<QuserResponse> list = new ArrayList<>();
            if (qUsersPage != null){
                for (QUsers qUsers : qUsersPage.getResult()){
                    QuserResponse quserResponse = new QuserResponse();
                    quserResponse.setQuId(qUsers.getQuId());
                    quserResponse.setUserName(qUsers.getUsername());
                    quserResponse.setPhoneNumber(qUsers.getPhone());
                    quserResponse.setRegisterTime(DateTimeUtil.formatDate(qUsers.getRegisterTime()));
                    quserResponse.setCustomeName(qUsers.getCertName());
                    quserResponse.setUserType(qUsers.getUserTypeId());
                    list.add(quserResponse);
                }
            }
            Page<QuserResponse> page = new Page<>();
            page.setPageindex(qUsersPage.getPageindex());
            page.setPagesize(qUsersPage.getPagesize());
            page.setTotal(qUsersPage.getTotal());
            page.setResult(list);
            return page;
        } catch (DatabaseException e) {
            LOG.error("fetchQuserInfoPage exception",qUsersRequest);
            throw new YCException(YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getCode(), YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getDesc());
        }
    }

    /**
     * 获取用户详情
     * @param id
     * @return
     * @throws YCException
     */
    public QUsers fetchQusersDetail(Integer id) throws YCException {
        Validator.isEmpty(id,"用户主键ID不能为空");
        QUsersRequest qUsersRequest = new QUsersRequest();
        qUsersRequest.setId(id);
        try {
            QUsers qUsers = companyLineService.fetchQUsersDetail(qUsersRequest);
            return qUsers;
        } catch (DatabaseException e) {
            LOG.error("fetchQusersDetail exception",id);
            throw new YCException(YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getCode(), YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getDesc());
        }
    }

    /**
     * 用户登录限制信息入库
     * @param id
     * @param stopTime
     * @param type
     * @throws YCException
     */
    public void addLimitInfo(Integer id,String stopTime,Integer type) throws YCException {
        QLoginLimit qLoginLimit = new QLoginLimit();
        qLoginLimit.setQuserId(id);
        qLoginLimit.setLoginTypeId(type);
        qLoginLimit.setIsCar(0);
        //若添加平台限制信息则可登录，否则不可登录，设置一个默认时间
        if (StringUtils.isNoneBlank(stopTime)){
            qLoginLimit.setEnabled(1);
            qLoginLimit.setStopTime(DateTimeUtil.convertDate(stopTime));
        }else {
            qLoginLimit.setEnabled(0);
            qLoginLimit.setStopTime(new Date());
        }
        try {
            cUsersService.insertLimit(qLoginLimit);
        } catch (DatabaseException e) {
            LOG.error("addLimitInfo exception",qLoginLimit);
            throw new YCException(YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getCode(), YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getDesc());
        }
    }


    /**
     * 校验用户是否已存在
     * @param type
     * @param userName
     * @return
     * @throws YCException
     */
    public boolean verifyQuser(Integer type,String userName) throws YCException {
        QUsersRequest qUsersRequest = new QUsersRequest();
        qUsersRequest.setUserType(type);
        qUsersRequest.setUserName(userName);
        try {
            QUsers qUsers = companyLineService.fetchQUsersDetail(qUsersRequest);
            if (qUsers != null){
                return true;
            }else {
                return false;
            }
        } catch (DatabaseException e) {
            LOG.error("verifyQuser exception",type);
            throw new YCException(YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getCode(), YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getDesc());
        }
    }
}
