package com.zhx.sikasoftware.dao;

import com.zhx.sikasoftware.bean.Staff;
import com.zhx.sikasoftware.dto.StaffDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffDao {
    boolean insertStaff(Staff staff);
    List<StaffDo> selectAllStaff();
    boolean updateStaff(Staff staff);
    boolean deleteStaff(Integer sId);
    Staff selectOneStaff(int sId);
    List<StaffDo> dividepagestaff(@Param("page") Integer page, @Param("pageSize") Integer pageSize);
    int countAll();
}
