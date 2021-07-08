package com.zhx.sikasoftware.dao.impl;

import com.zhx.sikasoftware.bean.Company;
import com.zhx.sikasoftware.dao.CompanyDao;
import com.zhx.sikasoftware.dto.CompanyDo;
import com.zhx.sikasoftware.mapper.machine.CompanyMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Slf4j
@Repository
public class CompanyDaoImpl implements CompanyDao {

    @Autowired
    CompanyMapper companyMapper;

    @Override
    public CompanyDo selectInfo() {
        CompanyDo companyDo = companyMapper.selectInfo();
        return companyDo;
    }

    @Override
    public boolean insertInfo(Company company) {
        int result = companyMapper.insertComInfo(company);
        log.debug("INSERT_COMINFO---result--->>>{}", result);
        if (result > 0)
            return true;
        return false;
    }

    @Override
    public boolean updateInfo(Company company) {
        int result = companyMapper.updateComInfo(company);
        if (result > 0)
            return true;
        return false;
    }

    @Override
    public boolean deleteInfo() {
        int result = companyMapper.deleteComInfo();
        if(result>0)
            return true;
        return false;
    }
}
