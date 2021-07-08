package com.zhx.sikasoftware.mapper.machine;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhx.sikasoftware.bean.Machinery;
import com.zhx.sikasoftware.dto.MachineryDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MachineryMapper{
    int insertMachine(Machinery machinery);
    List<MachineryDo> selectAllMachine();
    int updateMachine(Machinery machinery);
    boolean deleteMachine(Integer mId);
}
