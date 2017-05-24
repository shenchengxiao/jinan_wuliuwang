package com.ontime.service.impl;

import com.ontime.enums.YesNoEnum;
import com.ontime.exception.DatabaseException;
import com.ontime.interceptor.PageMybatisInterceptor;
import com.ontime.mapper.AdminInfoMapper;
import com.ontime.pojo.AdminInfo;
import com.ontime.pojo.AdminInfoExample;
import com.ontime.request.BaseQuery;
import com.ontime.response.AdminInfoResponse;
import com.ontime.service.LoginService;
import com.ontime.utils.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by shencx on 2017/5/18.
 */
@Service
public class LoginServiceImpl implements LoginService{

    Logger LOG = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Resource
    private AdminInfoMapper adminInfoMapper;

    /**
     * 用户登录
     * @param adminInfo
     * @return
     * @throws DatabaseException
     */
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

    /**
     * 添加用户
     * @param adminInfo
     * @return
     * @throws DatabaseException
     */
    @Override
    public Integer addAdminInfo(AdminInfo adminInfo) throws DatabaseException {
        try {
            if (adminInfo == null){
                LOG.error("addAdminInfo 信息为空",adminInfo);
                return Integer.valueOf(0);
            }
            adminInfo.setBeUsed(YesNoEnum.YES);
            adminInfo.setCreateTime(new Date());
            int val = adminInfoMapper.insert(adminInfo);
            if (val > 0){
                return adminInfo.getId();
            }else {
                return Integer.valueOf(0);
            }
        } catch (Throwable e) {
            LOG.error("addAdminInfo 发生异常",e);
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * 修改用户信息
     * @param adminInfo
     * @return
     * @throws DatabaseException
     */
    @Override
    public boolean updateAdminInfo(AdminInfo adminInfo) throws DatabaseException {
        try {
            if (adminInfo == null){
                LOG.error("updateAdminInfo 信息为空",adminInfo);
                return false;
            }
            int val = adminInfoMapper.updateByPrimaryKeySelective(adminInfo);
            return val>0?true:false;
        } catch (Throwable e) {
            LOG.error("updateAdminInfo 发生异常",e);
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * 获取用户信息列表
     * @param query
     * @return
     * @throws DatabaseException
     */
    @Override
    public Page<AdminInfo> fetchAdminInfoPage(BaseQuery query) throws DatabaseException {
        try {
            AdminInfoExample example = new AdminInfoExample();
            example.setOrderByClause("create_time desc");
            PageMybatisInterceptor.startPage(query.getPageNum(),query.getPageSize());
            adminInfoMapper.selectByExample(example);
            Page<AdminInfo> page = PageMybatisInterceptor.endPage();
            return page;
        } catch (Throwable e) {
            LOG.error("fetchAdminInfoPage 发生异常",e);
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * 启用禁用
     * @param id
     * @param status
     * @return
     * @throws DatabaseException
     */
    @Override
    public boolean modifyStatus(Integer id, Integer status) throws DatabaseException {
        try {
            AdminInfo adminInfo = new AdminInfo();
            adminInfo.setId(id);
            adminInfo.setBeUsed(YesNoEnum.create(status));
            int val = adminInfoMapper.updateByPrimaryKeySelective(adminInfo);
            return val>0?true:false;
        } catch (Throwable e) {
            LOG.error("modifyStatus 发生异常",e);
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * 获取帐号详情
     * @param id
     * @return
     * @throws DatabaseException
     */
    @Override
    public AdminInfo fetchAdminInfoDetail(Integer id) throws DatabaseException {
        try {
            if (id == null){
                LOG.error("fetchAdminInfoDetail 信息为空",id);
                return null;
            }
            AdminInfo adminInfo = adminInfoMapper.selectByPrimaryKey(id);
            return adminInfo;
        }  catch (Throwable e) {
            LOG.error("fetchAdminInfoDetail 发生异常",e);
            throw new DatabaseException(e.getMessage());
        }
    }
}
