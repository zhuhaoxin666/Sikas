package com.zhx.sikasoftware.mapper;

import com.zhx.sikasoftware.bean.Machinery;
import com.zhx.sikasoftware.dao.MachineryDao;
import com.zhx.sikasoftware.dto.MachineryDo;
import com.zhx.sikasoftware.mapper.machine.MachineryMapper;
import com.zhx.sikasoftware.service.MachineryService;
import com.zhx.sikasoftware.utils.PictureUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Slf4j
@SpringBootTest
public class MachineryMapperTest {

    @Autowired
    MachineryMapper machineryMapper;

    @Autowired
    MachineryDao machineryDao;

    @Autowired
    MachineryService machineryService;

    @Test
    void test0000(){
        MachineryDo machineryDo = machineryMapper.selectOneMachine(11);
        log.debug("{}",machineryDo.toString());
    }


    @Test
    void test01() throws IOException {
        Machinery machinery = new Machinery();
        machinery.setMName("挖掘机");
        machinery.setMType("重型机械");
        machinery.setMModel("X-10");
        machinery.setPurchaser("东北农业大学");
        LocalDate date = LocalDate.of(2019,06,25);
        machinery.setPurchaserDate(date);
        machinery.setPurchaserPrice(30000);
        machinery.setContractNumber("13056489311");
        machinery.setProvider("红星拖拉机厂");

//        File picture = new File("C:\\Users\\ZHX\\Desktop\\需求\\资源管理模块\\images\\caishou-xiangqing\\caishou-xiangqing_06.png");
//        File picture = new File("C:\\Users\\ZHX\\Desktop\\需求\\资源管理模块\\images\\shouye\\shouye_03.png");
        File picture = new File("C:\\Users\\ZHX\\Desktop\\需求\\资源管理模块\\images\\images\\76c3108f90740ed297a2da91e612964.jpg");
        Byte[] picByte = PictureUtils.getPicByte(picture);

        machinery.setOfficeId(002);
        machinery.setDelFlag(0); // 1 表示已删除
        machinery.setRemark("备注：拖拉机一定要帅");
        machinery.setCreator(1001);
        log.debug("{}",machinery.toString());
        machineryService.insertMachine(machinery);
    }

    @Test
    void selectAllMachinery(){
        List<MachineryDo> machinery = machineryMapper.selectAllMachine();
        for (MachineryDo m : machinery) {
            log.debug("查询所有的machine----->>>{}",m.toString());
        }
    }



    @Test
    void selectOneMachinery(){
        List<MachineryDo> machineryDos = machineryService.selectAllMachine();
        for (MachineryDo machineryDo : machineryDos) {
            log.debug("--{}--",machineryDo.toString());
        }
    }

    @Test
    void updateMachinery(){
        Machinery machinery = new Machinery();
        machinery.setMId(1);
        machinery.setDelFlag(0);
        boolean i =machineryDao.updateMachine(machinery);
        log.debug("update返回值----->>>>>{}",i);
    }

    @Test
    void deleteMachinery(){
        boolean b = machineryMapper.deleteMachine(1);
        log.debug("删除是否成功------>>>>>{}",b);
    }

    @Test
    void outputPicture() throws IOException {
        List<MachineryDo> machineryDos = machineryService.selectAllMachine();
        log.debug("{}",machineryDos.size());
        for (int i = 0; i < machineryDos.size(); i++) {
            File file = new File("D:\\SikaSoftware\\src\\main\\resources\\static\\userimages\\"+machineryDos.get(i).getMId()+".png");
            MachineryDo machineryDo =  machineryDos.get(i);
            OutputStream os = new FileOutputStream(file);

        }
    }

}
