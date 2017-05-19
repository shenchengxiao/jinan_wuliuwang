package com.ontime.service;

import com.ontime.exception.DatabaseException;
import com.ontime.pojo.AdminInfo;
import com.ontime.response.AdminInfoResponse;

/**
 * Created by shencx on 2017/5/18.
 */
public interface LoginService {

    AdminInfo loginByNameAndPassword(AdminInfo adminInfo) throws DatabaseException;
}
