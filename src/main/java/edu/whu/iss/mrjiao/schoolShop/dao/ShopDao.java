package edu.whu.iss.mrjiao.schoolShop.dao;

import edu.whu.iss.mrjiao.schoolShop.vo.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 通过 shop id 查询店铺
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);

    /**
     * 分页查询店铺，可输入的条件有：
     * 店铺名（模糊）、店铺状态、店铺类别、区域Id、owner
     * 使用mapper.xml时，接口中参数超过一个，必须用@Param来指定参数的唯一标识
     * @param shopCondition
     * @param rowIndex 从第几行开始取数据
     * @param pageSize 返回的条数
     * @return
     */
    List<Shop> queryShopList(@Param("shopCondition")Shop shopCondition,
                             @Param("rowIndex")int rowIndex,
                             @Param("pageSize")int pageSize);

    /**
     * 返回queryShopList的总数
     * 此处也可以不使用@Param注解
     * TODO 注意mapper文件中sql语句，涉及左查询右查询，如果shop表中的一条shop记录没有shop_category_id
     * TODO 或者area_id字段，则会查询不到
     * @param shopCondition
     * @return
     */
    int queryShopCount(@Param("shopCondition")Shop shopCondition);
}
