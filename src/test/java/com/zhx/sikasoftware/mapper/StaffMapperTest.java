package com.zhx.sikasoftware.mapper;

import com.zhx.sikasoftware.bean.Staff;
import com.zhx.sikasoftware.dao.StaffDao;
import com.zhx.sikasoftware.dto.StaffDo;
import com.zhx.sikasoftware.mapper.machine.MachineryMapper;
import com.zhx.sikasoftware.mapper.machine.StaffMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Slf4j
public class StaffMapperTest {

    @Autowired
    StaffMapper staffMapper;

    @Autowired
    MachineryMapper machineryMapper;

    @Test
    public void test01(){
        Staff staff = new Staff();
        staff.setSName("孙郡阳42");
        staff.setSActor("管理员");
        staff.setSJobType("高级种植管理员");
        LocalDate date = LocalDate.of(2000,2,15);
        staff.setSBirthday(date);
        staff.setSJobTime(9);
        staff.setSDelFlag(0);
        staff.setSNotes("我很擅长种树，并且种的比滕文生好");
        staffMapper.insertStaff(staff);
    }
    @Test
    public void test02(){
        List<StaffDo> staffs= staffMapper.selectAllStaff();
        System.out.println(staffs);
    }
    @Test
    public void test03(){
        Staff staff = new Staff();
        staff.setSId(7);
        staff.setSName("朱浩鑫");
        staff.setSActor("高级管理员");
        staff.setSJobType("高级种植管理员");
        LocalDate date = LocalDate.of(2000,2,15);
        staff.setSBirthday(date);
        staff.setSJobTime(9);
        staff.setSDelFlag(0);
        staff.setSNotes("我很擅长种树，并且种的比滕文生好");
        staffMapper.updateStaff(staff);
    }
    @Test
    public void test04(){
        staffMapper.deleteStaff(9);
    }
}
