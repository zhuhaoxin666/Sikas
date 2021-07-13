package com.zhx.sikasoftware.service;

import com.zhx.sikasoftware.bean.Machinery;
import com.zhx.sikasoftware.bean.Staff;
import com.zhx.sikasoftware.dto.MachineryDo;
import com.zhx.sikasoftware.dto.StaffDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffService {
    boolean insertStaff(Staff staff);
    List<StaffDo> selectAllStaff();
    boolean updateStaff(Staff staff);
    boolean deleteStaff(Integer sId);
    Staff selectOneStaff(int sId);
    List<StaffDo> dividepagestaff(@Param("page") Integer page, @Param("pageSize") Integer pageSize);
    int countAll();
}
