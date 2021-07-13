package com.zhx.sikasoftware.mapper.machine;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhx.sikasoftware.bean.Machinery;
import com.zhx.sikasoftware.dto.MachineryDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MachineryMapper extends BaseMapper<Machinery>{
    int insertMachine(Machinery machinery);
    List<MachineryDo> selectAllMachine();
    MachineryDo selectOneMachine(Integer mId);
    int updateMachine(Machinery machinery);
    boolean deleteMachine(Integer mId);
    List<MachineryDo> pageSelect(@Param("page") Integer page,@Param("pageSize") Integer pageSize);
    int countAll();
    List<MachineryDo> pageSearch(@Param("page") Integer page,@Param("pageSize") Integer pageSize,@Param("searchStr") String searchStr);
    int countSearch(String searchStr);
}
