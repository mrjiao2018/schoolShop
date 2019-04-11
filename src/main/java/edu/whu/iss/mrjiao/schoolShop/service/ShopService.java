package edu.whu.iss.mrjiao.schoolShop.service;

import edu.whu.iss.mrjiao.schoolShop.dto.ShopExecution;
import edu.whu.iss.mrjiao.schoolShop.vo.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.InputStream;


public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName);
}
