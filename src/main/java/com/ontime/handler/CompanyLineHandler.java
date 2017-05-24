package com.ontime.handler;

import com.ontime.core.ActionContext;
import com.ontime.enums.BusinessStatusEnum;
import com.ontime.exception.DatabaseException;
import com.ontime.exception.ValidationException;
import com.ontime.exception.YCException;
import com.ontime.pojo.QUsers;
import com.ontime.request.QUsersRequest;
import com.ontime.response.QuserResponse;
import com.ontime.service.CompanyLineService;
import com.ontime.utils.DateTimeUtil;
import com.ontime.utils.Page;
import com.ontime.utils.Validator;
import com.ontime.utils.YCSystemStatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shencx on 2017/5/22.
 */
@Service
public class CompanyLineHandler {

    Logger LOG = LoggerFactory.getLogger(CompanyLineHandler.class);

    @Resource
    private CompanyLineService companyLineService;

    /**
     * 添加修改
     * @param qUsers
     * @throws YCException
     */
    public void addCompanyLineUser(QUsers qUsers) throws YCException {
        /** 参数校验 */
        Validator.isEmpty(qUsers, BusinessStatusEnum.PARAM_EMPTY);
        Validator.isEmpty(qUsers.getUsername(),"帐号不能为空");
        Validator.isEmpty(qUsers.getPassword(),"用户密码不能为空");
        Validator.isEmpty(qUsers.getCertName(),"用户姓名不能为空");
        Validator.isEmpty(qUsers.getPhone(),"联系方式不能为空");
        Validator.isEmpty(qUsers.getCertNumber(),"身份证号码不能为空");
        /** 操作人 ID */
        qUsers.setAdminId(ActionContext.getActionContext().currentUser().getId().intValue());
        try {
            if (qUsers.getQuId() == null){
                companyLineService.addQUsersInfo(qUsers);
            }else {
                companyLineService.updateQUsersInfo(qUsers);
            }
        }  catch (DatabaseException e) {
            LOG.error("addCompanyLineUser exception",qUsers);
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
        try {
            QUsers qUsers = companyLineService.fetchQUsersDetail(id);
            return qUsers;
        } catch (DatabaseException e) {
            LOG.error("fetchQusersDetail exception",id);
            throw new YCException(YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getCode(), YCSystemStatusEnum.INVOKE_API_RETURN_EXCEPTION.getDesc());
        }
    }
}
