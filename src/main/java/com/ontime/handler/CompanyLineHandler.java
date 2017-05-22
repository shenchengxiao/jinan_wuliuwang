package com.ontime.handler;

import com.ontime.service.CompanyLineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by shencx on 2017/5/22.
 */
@Service
public class CompanyLineHandler {

    Logger LOG = LoggerFactory.getLogger(CompanyLineHandler.class);

    @Resource
    private CompanyLineService companyLineService;

//    public void addCompanyLineUser()
}
