package com.zhx.sikasoftware.controller;

import com.zhx.sikasoftware.dto.MachineryDo;
import com.zhx.sikasoftware.service.MachineryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class MachineController {


    @Autowired
    MachineryService machineryService;


    @RequestMapping("/todealmachine")
    public ModelAndView toDMachine(ModelAndView modelAndView) throws IOException {

        log.debug("进入控制器");

        List<MachineryDo> machineryDos = machineryService.selectAllMachine();

        log.debug("{}", machineryDos.size());

        Map<Integer, String> pathMap = new HashMap<>();

        String realPath = "D:\\SikaSoftware\\src\\main\\resources\\static\\userimages\\";

        for (int i = 0; i < machineryDos.size(); i++) {
            String path = realPath + machineryDos.get(i).getMId() + ".png";
            File file = new File(path);
            MachineryDo machineryDo = machineryDos.get(i);
            OutputStream os = new FileOutputStream(file);
            for (int j = 0; j < machineryDo.getPicture().length; j++) {
                os.write(machineryDo.getPicture()[j]);
            }
            pathMap.put(machineryDo.getMId(),path);
        }

        modelAndView.addObject("mapOfPath",pathMap);
        modelAndView.setViewName("dealmachine");
        for (MachineryDo machineryDo : machineryDos) {
            log.debug("MDO--->>>{}", machineryDo);
        }
        modelAndView.addObject("machineryDos", machineryDos);
        return modelAndView;
    }


    @RequestMapping("/toaddmachine")
    public ModelAndView toMachine(ModelAndView modelAndView) {
        modelAndView.setViewName("addmachine");

        return modelAndView;
    }


}
