package edu.whu.iss.mrjiao.schoolShop.service.impl;

import edu.whu.iss.mrjiao.schoolShop.dao.ShopDao;
import edu.whu.iss.mrjiao.schoolShop.dto.ShopExecution;
import edu.whu.iss.mrjiao.schoolShop.enums.ShopStateEnum;
import edu.whu.iss.mrjiao.schoolShop.service.ShopService;
import edu.whu.iss.mrjiao.schoolShop.utils.ImageUtil;
import edu.whu.iss.mrjiao.schoolShop.utils.PathUtil;
import edu.whu.iss.mrjiao.schoolShop.vo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    /**
     * 添加店铺
     * 方法为事务的，因为其包含四个步骤，只要有一个步骤失败就回滚，四个步骤如下：
     * 1. 向数据库中插入shop信息
     * 2.
     * 3.
     * 4.
     * @param shop
     * @param shopImginputStream
     * @return
     */
    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImginputStream, String fileName) {
        //特殊情况判断
        if(shop == null)
            return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);

        try {
            //初始化shop中部分信息
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //向数据库中插入shop
            int effectedNum = shopDao.insertShop(shop);
            if(effectedNum <= 0){
                throw new RuntimeException("店铺创建失败");
            } else {
                if(shopImginputStream != null){
                    //存储图片
                    try {
                        addShopImg(shop, shopImginputStream, fileName);
                    }catch (Exception e){
                        throw new RuntimeException("addShopImg error:" + e.getMessage());
                    }
                    //更新店铺的图片地址
                    effectedNum = shopDao.updateShop(shop);
                    if(effectedNum <= 0){
                        throw new RuntimeException("更新店铺图片地址失败");
                    }
                }
            }
        } catch (Exception e){
            throw new RuntimeException("addShop Error" + e.getMessage());
        }


        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    /**
     * 将用户上传的店铺图片加上水印后存储在本地，并初始化shop对象中的shop_img属性值
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     */
    private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
        //获取shop图片目录的相对值路径
        String destination = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream, fileName, destination);
        shop.setShopImg(shopImgAddr);
    }
}
