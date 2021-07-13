package com.zhx.sikasoftware.mapper;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhx.sikasoftware.bean.Machinery;
import com.zhx.sikasoftware.dto.MachineryDo;
import com.zhx.sikasoftware.mapper.machine.MachineryMapper;
import com.zhx.sikasoftware.service.MachineryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class DivideInPageTest {

    @Autowired
    MachineryService machineryService;

    @Autowired
    MachineryMapper machineryMapper;

    @Test
    void test(){
        Page<Machinery> page = new Page<Machinery>(1,2);
        Page<Machinery> page1 = machineryService.page(page);
        long total = page1.getTotal();
        log.debug("{}",total);
    }

    @Test
    void test01(){
        Integer page,pageSize;
        pageSize = 6;
        List<MachineryDo> machineryDos = machineryService.pageSelect(2, 6);
        for (MachineryDo machineryDo : machineryDos) {
            log.debug("分页 =: {}",machineryDo.toString());
        }
    }

    @Test
    void test02(){
        int i = machineryService.countAll();
        log.debug("{}",i);
    }

    @Test
    void test03(){
        List<MachineryDo> dos = machineryMapper.pageSearch(0, 2, "郑晓伟");
        for (MachineryDo machineryDo : dos) {
            log.debug("--{}",machineryDo.toString());
        }

    }

    @Test
    void test04(){
        List<MachineryDo> dos = machineryService.pageSearch(1, 2, "郑晓伟");
        for (MachineryDo machineryDo : dos) {
            log.debug("--{}",machineryDo.toString());
        }

    }


}
