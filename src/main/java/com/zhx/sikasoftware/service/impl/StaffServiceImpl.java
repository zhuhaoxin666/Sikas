package com.zhx.sikasoftware.service.impl;

import com.zhx.sikasoftware.bean.Machinery;
import com.zhx.sikasoftware.bean.Staff;
import com.zhx.sikasoftware.dao.MachineryDao;
import com.zhx.sikasoftware.dao.StaffDao;
import com.zhx.sikasoftware.dto.MachineryDo;
import com.zhx.sikasoftware.dto.StaffDo;
import com.zhx.sikasoftware.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;

    @Override
    public boolean insertStaff(Staff staff) {
        return staffDao.insertStaff(staff);
    }

    @Override
    public List<StaffDo> selectAllStaff() {
        List<StaffDo> staffDos = staffDao.selectAllStaff();
        return staffDos;
    }

    @Override
    public boolean updateStaff(Staff staff) {
        return staffDao.updateStaff(staff);
    }

    @Override
    public boolean deleteStaff(Integer sId) {
        return staffDao.deleteStaff(sId);
    }

    @Override
    public Staff selectOneStaff(int sId) {
        return staffDao.selectOneStaff(sId);
    }


}
