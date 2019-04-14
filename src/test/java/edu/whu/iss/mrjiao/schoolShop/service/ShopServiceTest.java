package edu.whu.iss.mrjiao.schoolShop.service;

import edu.whu.iss.mrjiao.schoolShop.BaseTest;
import edu.whu.iss.mrjiao.schoolShop.dto.ShopExecution;
import edu.whu.iss.mrjiao.schoolShop.enums.ShopStateEnum;
import edu.whu.iss.mrjiao.schoolShop.vo.Area;
import edu.whu.iss.mrjiao.schoolShop.vo.PersonInfo;
import edu.whu.iss.mrjiao.schoolShop.vo.Shop;
import edu.whu.iss.mrjiao.schoolShop.vo.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop() throws FileNotFoundException {

        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1l);
        area.setAreaId(1);
        shopCategory.setShopCategoryId(1l);
        File shopImg = new File("/Users/mrjiao/IdeaProjects/schoolShop/src/main/resources/tom.jpeg");
        InputStream inputStream = new FileInputStream(shopImg);

        Shop shop = new Shop();
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("testAddShop");
        shop.setShopDesc("testDesc");
        shop.setShopAddr("testAddr");
        shop.setPhone("testPhone");
        shop.setPriority(1);
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("testAdvice");

        //CommonsMultipartFile imgFile = new CommonsMultipartFile();
        ShopExecution shopExecution = shopService.addShop(shop, inputStream, shopImg.getName());

        assertEquals(ShopStateEnum.CHECK.getState(), shopExecution.getState());
    }

    @Test
    public void testModifyShop() throws IOException{
        Shop shop = new Shop();
        shop.setShopId(7l);
        shop.setShopName("修改后的名称");
        File shopImg = new File("/Users/mrjiao/IdeaProjects/schoolShop/src/main/resources/16123.jpg");
        InputStream inputStream = new FileInputStream(shopImg);
        ShopExecution shopExecution = shopService.modifyShop(shop, inputStream, shopImg.getName());
    }
}
