package edu.whu.iss.mrjiao.schoolShop.utils;

public class PathUtil {
    //获取系统的路径分隔符
    private static String separator = System.getProperty("file.separator");

    /**
     * 获取存放图片的文件夹的根路径
     * @return 存放图片的文件夹的根路径
     */
    public static String getImageBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase() == "win"){
            basePath = "D:/schoolShop/image/";
        } else{
            basePath = "/home/schoolShop/image/";
        }
        basePath = basePath.replace("/", separator);
        return basePath;
    }

    /**
     * 根据shopId返回项目图片的子路径
     * @param shopId
     * @return
     */
    public static String getShopImagePath(long shopId){
        String imagePath = "upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", separator);
    }
}
