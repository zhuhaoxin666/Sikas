package com.zhx.sikasoftware.controller;


import com.zhx.sikasoftware.bean.Company;
import com.zhx.sikasoftware.dto.CompanyDo;
import com.zhx.sikasoftware.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@Slf4j
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/insertComInfo",method = RequestMethod.POST)
    public String insert(Company company){
        log.debug("{}",company.toString());
        company.setCreator(1001);
        companyService.insertInfo(company);
        return "comInfo";
    }

    @RequestMapping("/tocomInfo")
    public ModelAndView comInfo(ModelAndView modelAndView){
        modelAndView.setViewName("comInfo");
        CompanyDo companyDo = companyService.selectInfo();
        modelAndView.addObject("companyDo",companyDo);
        return modelAndView;
    }

    @RequestMapping(value = "/updateComInfo",method = RequestMethod.POST)
    public ModelAndView updateComInfo(Company company, @RequestParam("comLogo")MultipartFile file, ModelAndView modelAndView, HttpServletRequest request) throws IOException {
        log.debug("UPDATE COMINFO---->>>{}, FILE_NAME---->>>>{}",company.toString(),file.getOriginalFilename());
        String realPath = ResourceUtils.getURL("classpath:").getPath()+"static/images/logo1.png";
        log.debug("REAL PATH---->>>{}",realPath);

        file.transferTo(new File(realPath));
        modelAndView.setViewName("redirect:/tocomInfo");
        company.setId(1);
        companyService.updateInfo(company);
        return modelAndView;
    }

}
