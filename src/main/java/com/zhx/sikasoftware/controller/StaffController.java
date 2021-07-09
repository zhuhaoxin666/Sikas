package com.zhx.sikasoftware.controller;

import com.zhx.sikasoftware.bean.Staff;
import com.zhx.sikasoftware.dto.MachineryDo;
import com.zhx.sikasoftware.dto.StaffDo;
import com.zhx.sikasoftware.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView beginStaff(){
        ModelAndView modelAndView= new ModelAndView();
        List<StaffDo> staffDos = staffService.selectAllStaff();
        modelAndView.addObject("staffDos",staffDos);
        modelAndView.setViewName("dealstaff");
        return modelAndView;
    }

    @RequestMapping("/addstaff")
    public ModelAndView addStaff(Staff staff){
        log.debug("-->{}",staff);
        ModelAndView modelAndView= new ModelAndView();
        staffService.insertStaff(staff);
        modelAndView.setViewName("redirect:/begin");
        return modelAndView;
    }

    @RequestMapping("/updatestaff")
    public ModelAndView updateStaff(Staff staff){
        log.debug("-->{}",staff);
        ModelAndView modelAndView= new ModelAndView();
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
