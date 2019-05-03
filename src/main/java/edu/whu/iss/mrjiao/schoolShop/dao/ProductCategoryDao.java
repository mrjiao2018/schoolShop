package edu.whu.iss.mrjiao.schoolShop.dao;

import edu.whu.iss.mrjiao.schoolShop.vo.ProductCategory;

import java.util.List;

public interface ProductCategoryDao {
    /**
     * 通过 shop id 查询商品类别
     *
     * @param shopId
     * @return
     */
    List<ProductCategory> queryProductCategoryList(long shopId);
}
