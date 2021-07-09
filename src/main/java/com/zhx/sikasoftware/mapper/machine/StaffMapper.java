package com.zhx.sikasoftware.mapper.machine;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhx.sikasoftware.bean.Staff;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface StaffMapper extends BaseMapper<Staff> {
    List<Staff> selectAllStaff();
    int insertStaff(Staff staff);
    int updateStaff(Staff staff);
    int deleteStaff(int sId);
}
