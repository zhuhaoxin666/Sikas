package com.zhx.sikasoftware.controller;

import com.fasterxml.jackson.databind.util.ClassUtil;
import com.zhx.sikasoftware.bean.Staff;
import com.zhx.sikasoftware.dto.MachineryDo;
import com.zhx.sikasoftware.dto.StaffDo;
import com.zhx.sikasoftware.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.webresources.ClasspathURLStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class StaffController {
    @Autowired
    StaffService staffService;
    /**
         * @description: 进入员工管理界面，进行数据库查询 , 回显到 dealstaff.html页面
         * @param:  Staff staff
         * @return: dealstaff.html
         * @throws:  ioexception
         * @author: Ten Wen Sheng
         * @date: 2021/7/9 16:25
         */
    @RequestMapping("/toaddstaff")
    public ModelAndView toStaff(){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("addstaff");
        return modelAndView;
    }
    @RequestMapping("/begin")
    public ModelAndView beginStaff(@RequestParam(value = "page",defaultValue="1") Integer page){
        ModelAndView modelAndView= new ModelAndView();
        int sumPage=staffService.countAll()/6+1;
        List<Integer> sumFooter= new ArrayList<>();
        for (int i = 1; i <=sumPage;i++){
            sumFooter.add(i);
        }

        List<StaffDo> staffDos = staffService.dividepagestaff(page,8);
        modelAndView.addObject("staffDos",staffDos);
        modelAndView.addObject("sumFooter",sumFooter);
        modelAndView.addObject("sumPage",sumPage);
        modelAndView.setViewName("dealstaff");
        return modelAndView;
    }

    @RequestMapping("/addstaff")
    public ModelAndView addStaff(Staff staff, @RequestParam("sp") MultipartFile file){
        log.debug("-->{}",staff);
        log.debug("file--->>>{}",file);
        ModelAndView modelAndView= new ModelAndView();
        String staticPath= ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        String fileName=file.getOriginalFilename();
        String urlPath="userimages"+ File.separator+fileName;
        String savePath = staticPath+File.separator+urlPath;
        String visitPath=urlPath;
        staff.setSUserPicture(urlPath);
        File saveFile=new File(savePath);
        if(!saveFile.exists()) {
            saveFile.mkdirs();
        }
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        staffService.insertStaff(staff);
        modelAndView.setViewName("redirect:/begin");
        return modelAndView;
    }

    @RequestMapping("/updatestaff")
    public ModelAndView updateStaff(Staff staff,@RequestParam("sp") MultipartFile file){
        log.debug("-->{}",staff);
        ModelAndView modelAndView= new ModelAndView();
        String staticPath= ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        String fileName=file.getOriginalFilename();
        String urlPath="userimages"+ File.separator+fileName;
        String savePath = staticPath+File.separator+urlPath;
        String visitPath=urlPath;
        staff.setSUserPicture(urlPath);
        File saveFile=new File(savePath);
        if(!saveFile.exists()) {
            saveFile.mkdirs();
        }
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        staffService.updateStaff(staff);
        modelAndView.setViewName("redirect:/begin");
        return modelAndView;
    }
    @RequestMapping("/toupdatestaff")
    public ModelAndView toupdateStaff(@RequestParam("sid") Integer sid){
        log.debug("-->{}",sid);
        Staff staff = staffService.selectOneStaff(sid);
        log.debug("-->{}",staff);
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.addObject("staff",staff);
        modelAndView.setViewName("updatestaff");
        return modelAndView;
    }
    @RequestMapping("/todelstaff")
    public ModelAndView delStaff(@RequestParam("sid") Integer sid){
        ModelAndView modelAndView= new ModelAndView();
        log.debug("---***{}",sid);
        staffService.deleteStaff(sid);
        modelAndView.setViewName("redirect:/begin");
        return modelAndView;
    }
}
