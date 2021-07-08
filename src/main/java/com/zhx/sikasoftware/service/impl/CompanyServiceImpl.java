package com.zhx.sikasoftware.service.impl;

import com.zhx.sikasoftware.bean.Company;
import com.zhx.sikasoftware.dao.CompanyDao;
import com.zhx.sikasoftware.dto.CompanyDo;
import com.zhx.sikasoftware.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyDao companyDao;

    @Override
    public CompanyDo selectInfo() {
        CompanyDo companyDo = companyDao.selectInfo();
        return companyDo;
    }

    @Override
    public boolean insertInfo(Company company) {
        boolean result = companyDao.insertInfo(company);
        return result;
    }

    @Override
    public boolean updateInfo(Company company) {
        boolean result = companyDao.updateInfo(company);
        return result;
    }

    @Override
    public boolean deleteInfo() {
        boolean result = companyDao.deleteInfo();
        return result;
    }
}
