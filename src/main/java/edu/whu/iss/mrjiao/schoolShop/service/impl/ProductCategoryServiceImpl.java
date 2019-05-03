package edu.whu.iss.mrjiao.schoolShop.service.impl;

import edu.whu.iss.mrjiao.schoolShop.dao.ProductCategoryDao;
import edu.whu.iss.mrjiao.schoolShop.service.ProductCategoryService;
import edu.whu.iss.mrjiao.schoolShop.vo.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> getProductCategoryList(long shopId) {
        return productCategoryDao.queryProductCategoryList(shopId);
    }
}
