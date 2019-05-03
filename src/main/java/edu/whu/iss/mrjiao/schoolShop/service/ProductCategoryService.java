package edu.whu.iss.mrjiao.schoolShop.service;

import edu.whu.iss.mrjiao.schoolShop.vo.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    /**
     * 获得指定店铺下的商品类别信息
     *
     * @param shopId
     * @return
     */
    List<ProductCategory> getProductCategoryList(long shopId);
}
