package com.zhx.sikasoftware.mapper;

import com.zhx.sikasoftware.bean.Company;
import com.zhx.sikasoftware.dto.CompanyDo;
import com.zhx.sikasoftware.mapper.machine.CompanyMapper;
import com.zhx.sikasoftware.utils.PictureUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

@Slf4j
@SpringBootTest
public class CompanyMapperTest {

    @Autowired
    CompanyMapper companyMapper;


    Company company = new Company();

    @Test
    void insert() throws IOException {
        company.setName("香坊区高新科技有限公司");
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

        companyMapper.insertComInfo(company);
    }

    @Test
    void selectInfo(){
        CompanyDo companyDo = companyMapper.selectInfo();
        log.debug("DO---Company--->>>{}",companyDo.toString());
    }


    @Test
    void selectAll(){
        Company company = companyMapper.selectAll();
        log.debug("Company--->>>{}",company.toString());
    }

    @Test
    void update(){
        company.setId(1);
        company.setName("haha");
        company.setWebsite("www.baikkk.com");
        company.setContact("朱彦林");
        company.setUpdater(123456);
        companyMapper.updateComInfo(company);
    }

    @Test
    void delete(){
        companyMapper.deleteComInfo();
    }
}
