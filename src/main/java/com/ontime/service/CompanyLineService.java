package com.ontime.service;

import com.ontime.exception.DatabaseException;
import com.ontime.pojo.QUsers;
import com.ontime.request.QUsersRequest;
import com.ontime.utils.Page;

/**
 * Created by shencx on 2017/5/19.
 */
public interface CompanyLineService {

    Integer addQUsersInfo(QUsers qUsers) throws DatabaseException;

    boolean updateQUsersInfo(QUsers qUsers) throws DatabaseException;

    Page<QUsers> fetchQUsersPage(QUsersRequest qUsersRequest) throws DatabaseException;

    QUsers fetchQUsersDetail(Integer id) throws DatabaseException;

}
