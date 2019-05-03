package edu.whu.iss.mrjiao.schoolShop.ctrl.shopAdmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * shop相关view的转发控制器
 */
@Controller
@RequestMapping(value = "/shopadmin", method = {RequestMethod.GET})
public class ShopAdminCtrl {

    @RequestMapping(value = "/shopoperation")
    public String shopOperation(){
        // 返回至 WEB-INF 目录下的 html 界面，该部分界面外部不可以直接访问
        return "shop/shopoperation";
    }

    @RequestMapping(value = "/shoplist")
    public String shopList(){ return "shop/shoplist"; }

    @RequestMapping(value = "/shopmanagement")
    public String shopManagement(){ return "shop/shopmanage"; }
}
