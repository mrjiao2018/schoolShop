package edu.whu.iss.mrjiao.schoolShop.service;

import edu.whu.iss.mrjiao.schoolShop.vo.ShopCategory;

import java.util.List;

public interface ShopCategoryService {
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
