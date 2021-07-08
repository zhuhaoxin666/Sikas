package com.zhx.sikasoftware;

import com.zhx.sikasoftware.bean.Company;
import com.zhx.sikasoftware.dao.CompanyDao;
import com.zhx.sikasoftware.dto.CompanyDo;
import com.zhx.sikasoftware.service.CompanyService;
import com.zhx.sikasoftware.utils.PictureUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

@SpringBootTest
@MapperScan("com.zhx.sikasoftware.mapper")
@Slf4j
class SikaSoftwareApplicationTests {

    @Autowired
    CompanyService companyService;

    @Autowired
    Company company;
    @Test
    void contextLoads() throws IOException {
        company.setName("wd有限公司");
        company.setContact("周刚烈");
        company.setContactNumber("13154656781");
        company.setSina("xiangfang.sina.com");
        company.setTencent("xiangfang.weibo");
        company.setEmail("18654564@me.com");
        company.setWebsite("www.xiangfang.com");
        company.setCreator(1001);
        File picture = new File("D://1.png");
        Byte[] picByte = PictureUtils.getPicByte(picture);
        File pride = new File("D://pride.png");
        Byte[] picPride = PictureUtils.getPicByte(pride);
        company.setPicture(picByte);
        company.setPride(picPride);
        company.setRemark("这个公司不得了");

        companyService.insertInfo(company);

    }

    @Test
    void testServiceSelectInfo(){
        CompanyDo companyDo = companyService.selectInfo();
        log.debug("SERVICE SELECT INFO------------->>>>>>  {}",companyDo.toString());
    }

    @Test
    void testServUpdateInfo(){
        company.setId(4);
        company.setName("jjj");
        boolean result = companyService.updateInfo(company);
        log.debug("UPDATE____INFO------>>>>>>{}",result);
    }

    @Test
    void testServDelete(){
        boolean result = companyService.deleteInfo();
        log.debug("DELETE___INFO-------->>>>>>>{}",result);
    }

}
