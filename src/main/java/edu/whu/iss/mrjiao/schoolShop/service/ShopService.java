package edu.whu.iss.mrjiao.schoolShop.service;

import edu.whu.iss.mrjiao.schoolShop.dto.ShopExecution;
import edu.whu.iss.mrjiao.schoolShop.vo.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


public interface ShopService {
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);
}
