package edu.whu.iss.mrjiao.schoolShop.utils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
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
     * @param thumbnail 用户上传的图片
     * @param targetAddr 目标地址，此处为相对地址
     * @return
     */
    public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr){
        String realFileName = getRandomFileName();
        String extension = getFileExtension(thumbnail);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr+realFileName+extension;
        String absoluteAddr = PathUtil.getImageBasePath() + relativeAddr;
        File destination = new File(absoluteAddr);
        try {
            Thumbnails.of(thumbnail.getInputStream()).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT,
                            ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
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
     * @param thumbnail
     * @return
     */
    private static String getFileExtension(CommonsMultipartFile thumbnail) {
        String originalFileName = thumbnail.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
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
