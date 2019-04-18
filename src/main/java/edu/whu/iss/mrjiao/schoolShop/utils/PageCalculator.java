package edu.whu.iss.mrjiao.schoolShop.utils;

public class PageCalculator {

    /**
     * 将页号转换为行号
     * 前端传过来的是页号，而数据库操作部分只记录行号，从而需要将前端传过来的页号转为行号
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public static int calculateRowIndex(int pageIndex, int pageSize){
        return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
    }
}
