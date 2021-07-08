package com.zhx.sikasoftware.dao;

import com.zhx.sikasoftware.bean.Company;
import com.zhx.sikasoftware.dto.CompanyDo;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao {
    CompanyDo selectInfo();
    boolean insertInfo(Company company);
    boolean updateInfo(Company company);
    boolean deleteInfo();
}
