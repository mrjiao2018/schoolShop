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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
        owner.setUserId(2018l);
        area.setAreaId(2018);
        shopCategory.setShopCategoryId(2018l);
        File shopImg = new File("/Users/mrjiao/IdeaProjects/schoolShop/src/main/resources/tom.jpeg");
        InputStream inputStream = new FileInputStream(shopImg);

        Shop shop = new Shop();
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("testAddShop");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("test");

        //CommonsMultipartFile imgFile = new CommonsMultipartFile();
        ShopExecution shopExecution = shopService.addShop(shop, inputStream, shopImg.getName());

        assertEquals(ShopStateEnum.CHECK.getState(), shopExecution.getState());
    }
}
