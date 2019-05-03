package edu.whu.iss.mrjiao.schoolShop.dao;

import edu.whu.iss.mrjiao.schoolShop.BaseTest;
import edu.whu.iss.mrjiao.schoolShop.vo.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductCategoryTest extends BaseTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testQueryProductCategoryList(){
        long shopId = 7l;
        List<ProductCategory> productCategories = productCategoryDao.queryProductCategoryList(shopId);

    }
}
