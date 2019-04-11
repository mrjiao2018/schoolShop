package edu.whu.iss.mrjiao.schoolShop.utils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    //获取classPath的绝对路径
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    //设置日期格式
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyMMddHHmmss");

    //设置随机数
    private static final Random r = new Random();

    /**
     * 创建缩略图
     * 将用户上传的图片调整至指定规格、加上水印并重命名（用户上传文件可能会出现重名），最后保存
     * @param thumbnailInputStream 用户上传的图片
     * @param targetAddr 目标地址，此处为相对地址
     * @return
     */
    public static String generateThumbnail(InputStream thumbnailInputStream, String fileName, String targetAddr){
        String realFileName = getRandomFileName();
        String extension = getFileExtension(fileName);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr+realFileName+extension;
        String absoluteAddr = PathUtil.getImageBasePath() + relativeAddr;
        File destination = new File(absoluteAddr);
        try {
            //todo basePath问题？通过basePath无法正确加载水印图片
            //File waterMark = new File(basePath + "/watermark.jpeg");
            File waterMark = new File("/Users/mrjiao/IdeaProjects/schoolShop/src/main/resources/watermark.jpeg");
            BufferedImage bufferedImage = ImageIO.read(waterMark);
            Thumbnails.of(thumbnailInputStream).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, bufferedImage, 0.25f)
                    .outputQuality(0.8f).toFile(destination);
        } catch (IOException e){
            throw new RuntimeException("创建缩略图失败：" + e.toString());
        }
        return relativeAddr;
    }

    /**
     * 创建目标路径所涉及到的目录，
     * 如 /home/schoolShop/image/xxx.jpg，则home、schoolShop、image这三个目录都会自动创建
     * @param targetAddr 目标地址，此处为相对地址
     */
    private static void makeDirPath(String targetAddr) {
        String absoluteFilePath = PathUtil.getImageBasePath() + targetAddr;
        File dirPath = new File(absoluteFilePath);
        if(!dirPath.exists())
            dirPath.mkdirs();
    }

    /**
     * 获取输入文件的扩展名
     * @param fileName
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名，当前年月日小时分钟秒钟+五位随机数
     * @return
     */
    private static String getRandomFileName() {
        //获取随机五位数，范围为[10000, 99999]
        int randomNum = r.nextInt(89999) + 10000;
        String nowTime = simpleDateFormat.format(new Date());
        return nowTime + randomNum;
    }
}
