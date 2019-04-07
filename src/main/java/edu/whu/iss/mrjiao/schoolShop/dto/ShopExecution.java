package edu.whu.iss.mrjiao.schoolShop.dto;

import edu.whu.iss.mrjiao.schoolShop.enums.ShopStateEnum;
import edu.whu.iss.mrjiao.schoolShop.vo.Shop;

import java.util.List;

public class ShopExecution {
    //结果状态
    private int state;

    //状态标识
    private String stateInfo;

    //店铺数量
    private int count;

    //操作的 shop（增删改店铺的时候用到）
    private Shop shop;

    // shop 列表
    private List<Shop> shopList;

    public ShopExecution(){}

    /**
     * 店铺操作失败时使用的构造器
     * @param stateEnum
     */
    public ShopExecution(ShopStateEnum stateEnum){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    /**
     * 店铺操作成功时使用的构造器，额外返回一个操作成功的Shop对象
     * @param stateEnum
     * @param shop
     */
    public ShopExecution(ShopStateEnum stateEnum, Shop shop){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }

    /**
     * 店铺操作成功时使用的构造器，额外返回多个操作成功的Shop对象
     * @param stateEnum
     * @param shopList
     */
    public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
