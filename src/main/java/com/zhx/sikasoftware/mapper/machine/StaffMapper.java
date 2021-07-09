package com.zhx.sikasoftware.mapper.machine;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhx.sikasoftware.bean.Staff;
import com.zhx.sikasoftware.dto.StaffDo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface StaffMapper extends BaseMapper<Staff> {
    List<StaffDo> selectAllStaff();
    int insertStaff(Staff staff);
    int updateStaff(Staff staff);
    boolean deleteStaff(int sId);
    Staff selectOneStaff(int sId);
}
