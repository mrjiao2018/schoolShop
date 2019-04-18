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
        return "shop/shopoperation";
    }

    @RequestMapping(value = "/shoplist")
    public String shopList(){ return "shop/shoplist"; }

    @RequestMapping(value = "/shopmanagement")
    public String shopManagement(){ return "shop/shopmanage"; }
}
