package edu.whu.iss.mrjiao.schoolShop.dao;

import edu.whu.iss.mrjiao.schoolShop.vo.Shop;

public interface ShopDao {
    /**
     * 新增shop
     * @param shop
     * @return 影响的行数
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
