package com.zhx.sikasoftware.controller;

import com.zhx.sikasoftware.bean.Machinery;
import com.zhx.sikasoftware.dto.MachineryDo;
import com.zhx.sikasoftware.service.MachineryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class MachineController {


    @Autowired
    MachineryService machineryService;

    /**
     * @description: 进入 “农机管理页面” , 进行数据库分页查询 , 回显到 dealmachine.html页面
     * @param: Machinery machinery , @RequestParam(defaultValue = "1") Integer page
     * @return: dealmachine.html
     * @throws: IOException
     * @author: HaoXin
     * @date 2021/7/9 8:56
     */

    @RequestMapping(value = {"/todealmachine","/"})
    public ModelAndView toDMachine(Machinery machinery, @RequestParam(value = "page", defaultValue = "1") Integer page) {
        log.debug("页码：{}", page);
        ModelAndView modelAndView = new ModelAndView();
        log.debug("进入控制器");
        int sumPage = machineryService.countAll() / 6 + 1;
        List<Integer> sumFooter = new ArrayList<>();
        for (int i = 1; i <= sumPage; i++) {
            sumFooter.add(i);
        }
        List<MachineryDo> machineryDos = machineryService.pageSelect(page, 6);
        modelAndView.addObject("sumPage", sumPage);
        modelAndView.addObject("sumFooter",sumFooter);
        modelAndView.setViewName("dealmachine");
//        for (MachineryDo machineryDo : machineryDos) {
//            log.debug("MDO--->>>{}", machineryDo);
//        }
        modelAndView.addObject("machineryDos", machineryDos);
        return modelAndView;
    }


    /**
     * @description: 完成查询功能,实现了对查询结果的分页
     * @param: ModelAndView modelAndView,@RequestParam(value = "search",defaultValue = "") String search,@RequestParam(value = "page", defaultValue = "1") Integer page
     * @return: dealsearch.html
     * @throws:
     * @author: HaoXin
     * @date 2021/7/13 15:00
     */

    @RequestMapping("/tosearch")
    public ModelAndView toSh(ModelAndView modelAndView,@RequestParam(value = "search",defaultValue = "") String search,@RequestParam(value = "page", defaultValue = "1") Integer page){
        log.debug("查询条件：{}",search);
        if (!search.equals("")){
            int sumPage = machineryService.countSearch(search) / 6 + 1;
            List<Integer> sumFooter = new ArrayList<>();
            for (int i = 1; i <= sumPage; i++) {
                sumFooter.add(i);
            }
            List<MachineryDo> machineryDos = machineryService.pageSearch(page, 6, search);
            modelAndView.addObject("sumPage", sumPage);
            modelAndView.addObject("sumFooter",sumFooter);
            modelAndView.addObject("machineryDos", machineryDos);
        }
        modelAndView.setViewName("dealsearch");
        modelAndView.addObject("searchName",search);
        return modelAndView;
    }




    @RequestMapping("/toaddmachine")
    public ModelAndView toMachine(ModelAndView modelAndView) {
        modelAndView.setViewName("addmachine");
        return modelAndView;
    }




    /**
     * @description: 完成 “添加农机”, 将农机信息插入数据库 ,跳转至 “农机管理页面”
     * @param: ModelAndView modelAndView, Machinery machinery, @RequestParam("pic")MultipartFile file
     * @return: 跳转至 dealmachine.html页面
     * @throws:
     * @author: HaoXin
     * @date 2021/7/9 8:52
     */
    @RequestMapping("/toadd")
    public ModelAndView addMachine(ModelAndView modelAndView, Machinery machinery, @RequestParam("pic") MultipartFile file) {
        log.debug("FILE--->>>{}", file);

        String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        String fileName = file.getOriginalFilename();
        String urlPath = "userimages" + File.separator + fileName;
        String savePath = staticPath + File.separator + urlPath;

        log.debug("文件保存在---->>>>{}", savePath);
        // 访问路径=静态资源路径+文件目录路径
        String visitPath = urlPath;

        machinery.setPicture(urlPath);
        machinery.setDelFlag(0);
        machinery.setCreator(1001);

        log.debug("图片访问uri：{}", visitPath);

        File saveFile = new File(savePath);
        if (!saveFile.exists()) {
            saveFile.mkdirs();
        }
        try {
            file.transferTo(saveFile);  //将临时存储的文件移动到真实存储路径下
        } catch (IOException e) {
            e.printStackTrace();
        }

        machineryService.insertMachine(machinery);

        log.debug("machinery---->>>{}", machinery.toString());
        modelAndView.setViewName("redirect:/todealmachine");
        return modelAndView;
    }

    /**
     * @description: 处理删除操作，删除之后跳转到 “农机管理” 主页
     * @param: @RequestParam("mid") Integer mid
     * @return: redirect:/todealmachine
     * @throws:
     * @author: HaoXin
     * @date 2021/7/9 16:40
     */

    @RequestMapping("/todeleteMC")
    public ModelAndView toDelete(ModelAndView modelAndView, @RequestParam("mid") Integer mid) {

        machineryService.deleteMachine(mid);

        modelAndView.setViewName("redirect:/todealmachine");
        return modelAndView;
    }


    /**
     * @description: 跳转到 “修改农机页面”, 根据传递参数的mid值查询该条农机信息, 回显到 “修改页面”
     * @param: @RequestParam("mid") Integer mid
     * @return: modifymachine.html
     * @throws:
     * @author: HaoXin
     * @date 2021/7/9 16:41
     */
    @RequestMapping("/tomodifyMC")
    public ModelAndView toMDY(ModelAndView modelAndView, @RequestParam("mid") Integer mid) {
        log.debug("{}", mid);
        modelAndView.setViewName("modifymachine");
        MachineryDo machineryDo = machineryService.selectOneMachine(mid);
        modelAndView.addObject("updateMC", machineryDo);
        return modelAndView;
    }


    /**
     * @description: 根据传递参数mid, 修改“农机”数据, 对图片的路径的更新
     * @param: Machinery machinery,@RequestParam("mid") Integer mId,@RequestParam("pic") MultipartFile file
     * @return: redirect:/todealmachine
     * @throws:
     * @author: HaoXin
     * @date 2021/7/9 16:44
     */

    @RequestMapping("/modifyMC")
    public ModelAndView MDY(ModelAndView modelAndView, Machinery machinery, @RequestParam("mid") Integer mId, @RequestParam("pic") MultipartFile file) {

        log.debug("file--->>>{}", file.getOriginalFilename());

        if (!file.getOriginalFilename().equals("")) {
            String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
            String fileName = file.getOriginalFilename();
            String urlPath = "userimages" + File.separator + fileName;
            String savePath = staticPath + File.separator + urlPath;

            log.debug("文件保存在---->>>>{}", savePath);
            // 访问路径=静态资源路径+文件目录路径
            String visitPath = urlPath;
            machinery.setPicture(urlPath);

            File saveFile = new File(savePath);
            if (!saveFile.exists()) {
                saveFile.mkdirs();
            }
            try {
                file.transferTo(saveFile);  //将临时存储的文件移动到真实存储路径下
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        machinery.setMId(mId);
        //更新图片存储路径
        modelAndView.setViewName("redirect:/todealmachine");
        //更新机械信息
        machineryService.updateMachine(machinery);
        return modelAndView;
    }
}
