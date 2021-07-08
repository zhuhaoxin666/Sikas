package com.zhx.sikasoftware.mapper.machine;

import com.zhx.sikasoftware.bean.Company;
import com.zhx.sikasoftware.dto.CompanyDo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper {
    int insertComInfo(Company company);
    CompanyDo selectInfo();
    Company selectAll();
    int updateComInfo(Company company);
    int deleteComInfo();
}
