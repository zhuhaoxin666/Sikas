package com.zhx.sikasoftware.service;

import com.zhx.sikasoftware.bean.Machinery;
import com.zhx.sikasoftware.dto.MachineryDo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MachineryService {
    boolean insertMachine(Machinery machinery);
    List<MachineryDo> selectAllMachine();
    MachineryDo selectOneMachine(Integer mId);
    boolean updateMachine(Machinery machinery);
    boolean deleteMachine(Integer mId);
}
