package com.ontime.service.impl;

import com.ontime.exception.DatabaseException;
import com.ontime.interceptor.PageMybatisInterceptor;
import com.ontime.mapper.QUsersMapper;
import com.ontime.pojo.QUsers;
import com.ontime.pojo.QUsersExample;
import com.ontime.request.QUsersRequest;
import com.ontime.service.CompanyLineService;
import com.ontime.utils.Page;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by shencx on 2017/5/19.
 */
@Service
public class CompanyLineServiceImpl implements CompanyLineService{

    Logger LOG = LoggerFactory.getLogger(CompanyLineServiceImpl.class);

    @Resource
    private QUsersMapper qUsersMapper;

    /**
     * 添加企业专线用户
     * @param qUsers
     * @return
     * @throws DatabaseException
     */
    @Override
    public Integer addQUsersInfo(QUsers qUsers) throws DatabaseException {
        try {
            if (qUsers == null){
                LOG.error("addQUsersInfo 信息为空",qUsers);
                return Integer.valueOf(0);
            }
            qUsers.setRegisterTime(new Date());
            int val = qUsersMapper.insert(qUsers);
            if (val > 0){
                return qUsers.getQuId();
            }else {
                return Integer.valueOf(0);
            }
        } catch (Throwable e) {
            LOG.error("addQUsersInfo 异常",e);
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * 更新信息
     * @param qUsers
     * @return
     * @throws DatabaseException
     */
    @Override
    public boolean updateQUsersInfo(QUsers qUsers) throws DatabaseException {
        try {
            if(qUsers == null){
                LOG.error("updateQUsersInfo 信息为空",qUsers);
                return false;
            }
            int val = qUsersMapper.updateByPrimaryKey(qUsers);
            return (val>0)?true:false;
        } catch (Throwable e) {
            LOG.error("updateQUsersInfo 异常",e);
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * 获取企业专线用户列表
     * @param qUsersRequest
     * @return
     * @throws DatabaseException
     */
    @Override
    public Page<QUsers> fetchQUsersPage(QUsersRequest qUsersRequest) throws DatabaseException {
        try {
            if (qUsersRequest == null){
                LOG.error("fetchQUsersPage 信息为空",qUsersRequest);
                return null;
            }
            QUsersExample example = new QUsersExample();
            QUsersExample.Criteria criteria = example.createCriteria();
            if (StringUtils.isNoneBlank(qUsersRequest.getAccountName())){
                StringBuffer sb = new StringBuffer();
                String account = qUsersRequest.getAccountName();
                sb.append("%");
                sb.append(account);
                sb.append("%");
                criteria.andUsernameEqualTo(sb.toString());
            }
            if (StringUtils.isNoneBlank(qUsersRequest.getUserName())){
                StringBuffer stringBuffer = new StringBuffer();
                String userName = qUsersRequest.getUserName();
                stringBuffer.append("%");
                stringBuffer.append(userName);
                stringBuffer.append("%");
                criteria.andUsernameEqualTo(stringBuffer.toString());
            }
            if (StringUtils.isNoneBlank(qUsersRequest.getPhoneNumber())){
                criteria.andPhoneEqualTo(qUsersRequest.getPhoneNumber());
            }
            example.setOrderByClause("register_time desc");
            PageMybatisInterceptor.startPage(qUsersRequest.getPageNum(),qUsersRequest.getPageSize());
            qUsersMapper.selectByExample(example);
            Page<QUsers> page = PageMybatisInterceptor.endPage();
            return page;
        } catch (Throwable e) {
            LOG.error("fetchQUsersPage 异常",e);
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public QUsers fetchQUsersDetail(Integer id) throws DatabaseException {
        try {
            if (id == null){
                LOG.error("fetchQUsersDetail id 为空",id);
                return null;
            }
            QUsers qUsers = qUsersMapper.selectByPrimaryKey(id);
            return qUsers;
        } catch (Throwable e) {
            LOG.error("fetchQUsersDetail 异常",e);
            throw new DatabaseException(e.getMessage());
        }
    }
}
