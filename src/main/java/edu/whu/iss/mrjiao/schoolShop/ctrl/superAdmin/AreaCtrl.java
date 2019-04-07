package edu.whu.iss.mrjiao.schoolShop.ctrl.superAdmin;

import edu.whu.iss.mrjiao.schoolShop.service.AreaService;
import edu.whu.iss.mrjiao.schoolShop.vo.Area;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/superadmin")      //RequestMapping中的url路径默认都使用小写，不采用驼峰命名或者下划线分割
public class AreaCtrl {
    Logger logger = LoggerFactory.getLogger(AreaCtrl.class);
    @Autowired
    private AreaService areaService;


    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    //自动将 Map 转换成json数据返回给前端
    @ResponseBody
    private Map<String, Object> listArea(){
        logger.info("============ start ==============");
        long startTime = System.currentTimeMillis();

        Map<String, Object> modelMap = new HashMap<>();
        List<Area> list = new ArrayList<>();
        try {
            list = areaService.getAreaList();
            modelMap.put("rows", list);
            modelMap.put("total", list.size());
        }catch (Exception e){
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }

        long endTime = System.currentTimeMillis();

        //logger中一般使用info信息来记录方法的启动和结束
        logger.info("============ end ==============");
        //logger中加入debug信息方便做调试，一般涉及到调优，包含程序执行时间
        logger.debug("costTime:[{}ms]", endTime-startTime);
        logger.error("test error");

        return modelMap;
    }
}
