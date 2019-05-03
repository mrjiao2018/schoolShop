package edu.whu.iss.mrjiao.schoolShop.ctrl.shopAdmin;

import edu.whu.iss.mrjiao.schoolShop.dto.Result;
import edu.whu.iss.mrjiao.schoolShop.enums.ProductCategoryStateEnum;
import edu.whu.iss.mrjiao.schoolShop.service.ProductCategoryService;
import edu.whu.iss.mrjiao.schoolShop.vo.ProductCategory;
import edu.whu.iss.mrjiao.schoolShop.vo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shopadmin")
public class ProductCategoryManagementCtrl {
    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping(value = "/listproductcategories", method = RequestMethod.GET)
    @ResponseBody
    private Result<List<ProductCategory>> getProductCategoryList(HttpServletRequest request){
        Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
        List<ProductCategory> productCategoryList = null;
        if(currentShop != null && currentShop.getShopId() > 0){
            productCategoryList = productCategoryService.getProductCategoryList(currentShop.getShopId());
            return new Result<>(true, productCategoryList);
        }else {
            ProductCategoryStateEnum ps = ProductCategoryStateEnum.INNER_ERROR;
            return new Result<>(false, ps.getState(), ps.getStateInfo());
        }
    }
}
