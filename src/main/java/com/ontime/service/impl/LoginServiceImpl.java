package com.ontime.service.impl;

import com.ontime.enums.YesNoEnum;
import com.ontime.exception.DatabaseException;
import com.ontime.mapper.AdminInfoMapper;
import com.ontime.pojo.AdminInfo;
import com.ontime.pojo.AdminInfoExample;
import com.ontime.response.AdminInfoResponse;
import com.ontime.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shencx on 2017/5/18.
 */
@Service
public class LoginServiceImpl implements LoginService{

    Logger LOG = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Resource
    private AdminInfoMapper adminInfoMapper;

    @Override
    public AdminInfo loginByNameAndPassword(AdminInfo adminInfo) throws DatabaseException {
        try {
            if (adminInfo == null){
                LOG.error("loginByNameAndPassword 信息为空",adminInfo);
                return null;
            }
            AdminInfoExample example = new AdminInfoExample();
            AdminInfoExample.Criteria criteria = example.createCriteria();
            criteria.andUserNameEqualTo(adminInfo.getUserName());
            criteria.andPassWordEqualTo(adminInfo.getPassWord());
            criteria.andBeUsedEqualTo(YesNoEnum.YES);
            List<AdminInfo> list = adminInfoMapper.selectByExample(example);
            if (list == null || list.size() == 0){
                return null;
            }else {
                return list.get(0);
            }
        } catch (Throwable e) {
            LOG.error("loginByNameAndPassword 发生异常",e);
            throw new DatabaseException(e.getMessage());
        }

    }
}
