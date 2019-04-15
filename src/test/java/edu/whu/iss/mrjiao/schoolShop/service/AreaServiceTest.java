package edu.whu.iss.mrjiao.schoolShop.service;

import edu.whu.iss.mrjiao.schoolShop.BaseTest;
import edu.whu.iss.mrjiao.schoolShop.vo.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaServiceTest extends BaseTest {
    //此处通过Autowired初始化AreaService接口时，AreaService会自动向其中注入其实现类AreaServiceImpl，
    //因为已经在AreaServiceImpl中加入了@Service注解，将该组件交给SpringIOC容器托管
    @Autowired
    private AreaService areaService;

    @Test
    public void getAreaList(){
        List<Area> areaList = areaService.getAreaList();
        assertEquals("樱花大厦", areaList.get(1).getAreaName());
    }
}
