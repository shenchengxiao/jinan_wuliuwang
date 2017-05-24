package com.ontime.service;

import com.ontime.exception.DatabaseException;
import com.ontime.pojo.AdminInfo;
import com.ontime.request.BaseQuery;
import com.ontime.response.AdminInfoResponse;
import com.ontime.utils.Page;

/**
 * Created by shencx on 2017/5/18.
 */
public interface LoginService {

    AdminInfo loginByNameAndPassword(AdminInfo adminInfo) throws DatabaseException;

    Integer addAdminInfo(AdminInfo adminInfo) throws DatabaseException;

    boolean updateAdminInfo(AdminInfo adminInfo) throws DatabaseException;

    Page<AdminInfo> fetchAdminInfoPage(BaseQuery query) throws DatabaseException;

    boolean modifyStatus(Integer id,Integer status) throws DatabaseException;

    AdminInfo fetchAdminInfoDetail(Integer id) throws DatabaseException;
}
