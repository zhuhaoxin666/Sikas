package com.zhx.sikasoftware.dao.impl;

import com.zhx.sikasoftware.bean.Staff;
import com.zhx.sikasoftware.dao.StaffDao;
import com.zhx.sikasoftware.dto.MachineryDo;
import com.zhx.sikasoftware.dto.StaffDo;
import com.zhx.sikasoftware.mapper.machine.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffDaoImpl implements StaffDao{
    @Autowired
    StaffMapper staffMapper;


    @Override
    public boolean insertStaff(Staff staff) {
        int i = staffMapper.insertStaff(staff);
        if (i > 0)
            return true;
        return false;
    }

    @Override
    public List<StaffDo> selectAllStaff() {
        List<StaffDo> staffDos = staffMapper.selectAllStaff();
        return staffDos;
    }

    @Override
    public boolean updateStaff(Staff staff) {
        int i = staffMapper.updateStaff(staff);
        if (i > 0)
            return true;
        return false;
    }

    @Override
    public boolean deleteStaff(Integer sId) {
        return staffMapper.deleteStaff(sId);
    }

    @Override
    public Staff selectOneStaff(int sId) {
        return staffMapper.selectOneStaff(sId);
    }

    @Override
    public List<StaffDo> dividepagestaff(Integer page, Integer pageSize) {
        return staffMapper.dividepagestaff(page,pageSize);
    }

    @Override
    public int countAll() {
        return staffMapper.countAll();
    }

}
