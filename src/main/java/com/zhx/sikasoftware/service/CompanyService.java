package com.zhx.sikasoftware.service;

import com.zhx.sikasoftware.bean.Company;
import com.zhx.sikasoftware.dto.CompanyDo;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {
    CompanyDo selectInfo();
    boolean insertInfo(Company company);
    boolean updateInfo(Company company);
    boolean deleteInfo();
}
