package edu.whu.iss.mrjiao.schoolShop.service.impl;

import edu.whu.iss.mrjiao.schoolShop.dao.ShopCategoryDao;
import edu.whu.iss.mrjiao.schoolShop.service.ShopCategoryService;
import edu.whu.iss.mrjiao.schoolShop.vo.ShopCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }
}
