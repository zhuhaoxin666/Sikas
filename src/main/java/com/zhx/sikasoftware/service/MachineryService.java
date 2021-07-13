package com.zhx.sikasoftware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhx.sikasoftware.bean.Machinery;
import com.zhx.sikasoftware.dto.MachineryDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MachineryService extends IService<Machinery> {
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
