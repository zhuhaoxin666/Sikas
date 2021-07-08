package com.zhx.sikasoftware.dao;

import com.zhx.sikasoftware.bean.Machinery;
import com.zhx.sikasoftware.dto.MachineryDo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineryDao {
    boolean insertMachine(Machinery machinery);
    List<MachineryDo> selectAllMachine();
    boolean updateMachine(Machinery machinery);
    boolean deleteMachine(Integer mId);
}
