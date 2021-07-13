package com.zhx.sikasoftware.dao;

import com.zhx.sikasoftware.bean.Machinery;
import com.zhx.sikasoftware.dto.MachineryDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineryDao {
    boolean insertMachine(Machinery machinery);
    List<MachineryDo> selectAllMachine();
    MachineryDo selectOneMachine(Integer mId);
    boolean updateMachine(Machinery machinery);
    boolean deleteMachine(Integer mId);
    List<MachineryDo> pageSelect(Integer page,Integer pageSize);
    int countAll();
    int countSearch(String searchStr);
    List<MachineryDo> pageSearch(Integer page,Integer pageSize,String searchStr);

}
