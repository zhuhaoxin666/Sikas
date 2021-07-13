package com.zhx.sikasoftware.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhx.sikasoftware.bean.Machinery;
import com.zhx.sikasoftware.dao.MachineryDao;
import com.zhx.sikasoftware.dto.MachineryDo;
import com.zhx.sikasoftware.mapper.machine.MachineryMapper;
import com.zhx.sikasoftware.service.MachineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineryServiceImpl extends ServiceImpl<MachineryMapper,Machinery> implements MachineryService {

    @Autowired
    private MachineryDao machineryDao;

    @Override
    public boolean insertMachine(Machinery machinery) {

        return machineryDao.insertMachine(machinery);
    }

    @Override
    public List<MachineryDo> selectAllMachine() {
        List<MachineryDo> machineryDos = machineryDao.selectAllMachine();
        return machineryDos;
    }

    @Override
    public MachineryDo selectOneMachine(Integer mId) {
        return machineryDao.selectOneMachine(mId);
    }

    @Override
    public boolean updateMachine(Machinery machinery) {
        return machineryDao.updateMachine(machinery);
    }

    @Override
    public boolean deleteMachine(Integer mId) {
        return machineryDao.deleteMachine(mId);
    }

    @Override
    public List<MachineryDo> pageSelect(Integer page, Integer pageSize) {
        return machineryDao.pageSelect(pageSize*(page-1),pageSize);
    }

    @Override
    public int countAll() {
        return machineryDao.countAll();
    }

    @Override
    public int countSearch(String searchStr) {
        return machineryDao.countSearch(searchStr);
    }

    @Override
    public List<MachineryDo> pageSearch(Integer page, Integer pageSize, String searchStr) {
        return machineryDao.pageSearch(pageSize*(page-1),pageSize,searchStr);
    }
}
