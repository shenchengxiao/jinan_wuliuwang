package com.ontime.service;

import com.ontime.pojo.QUsers;
import com.ontime.request.QUsersRequest;
import com.ontime.utils.Page;

/**
 * Created by shencx on 2017/5/19.
 */
public interface CompanyLineService {

    Integer addQUsersInfo(QUsers qUsers);

    boolean updateQUsersInfo(QUsers qUsers);

    Page<QUsers> fetchQUsersPage(QUsersRequest qUsersRequest);


}
