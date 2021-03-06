package com.zhx.sikasoftware.dao.impl;

import com.zhx.sikasoftware.bean.Machinery;
import com.zhx.sikasoftware.dao.MachineryDao;
import com.zhx.sikasoftware.dto.MachineryDo;
import com.zhx.sikasoftware.mapper.machine.MachineryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MachineryDaoImpl implements MachineryDao {

    @Autowired
    MachineryMapper machineryMapper;

    @Override
    public boolean insertMachine(Machinery machinery) {
        int i = machineryMapper.insertMachine(machinery);
        if (i > 0)
            return true;
        return false;
    }

    @Override
    public List<MachineryDo> selectAllMachine() {
        List<MachineryDo> machineryDos = machineryMapper.selectAllMachine();
        return machineryDos;
    }

    @Override
    public boolean updateMachine(Machinery machinery) {
        int i = machineryMapper.updateMachine(machinery);
        if (i > 0)
            return true;
        return false;
    }

    @Override
    public boolean deleteMachine(Integer mId) {
        return machineryMapper.deleteMachine(mId);
    }

    @Override
    public List<MachineryDo> pageSelect(Integer page, Integer pageSize) {
        return machineryMapper.pageSelect(page,pageSize);
    }

    @Override
    public int countAll() {
        return machineryMapper.countAll();
    }

    @Override
    public int countSearch(String searchStr) {
        return machineryMapper.countSearch(searchStr);
    }

    @Override
    public List<MachineryDo> pageSearch(Integer page, Integer pageSize, String searchStr) {
        return machineryMapper.pageSearch(page,pageSize,searchStr);
    }

    @Override
    public MachineryDo selectOneMachine(Integer mId) {
        return machineryMapper.selectOneMachine(mId);
    }
}
