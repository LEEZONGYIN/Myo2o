package com.lzy.o2o.util;

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

    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHss");
    private static final Random r = new Random();

     public static String generateThumbnail(CommonsMultipartFile thumbnail,String targetAddr){
         String realFileName = getRandomFileName();
         String extension = getFileExtension(thumbnail);
         makeDirPath(targetAddr);
         String relativeAddr = targetAddr+realFileName+extension;
         File dest = new File(PathUtil.getImgBasePath()+relativeAddr);

         try {
             Thumbnails.of(thumbnail.getInputStream()).size(200,200)
                     .outputQuality(0.8f).toFile(dest);
         } catch (IOException e) {
             e.printStackTrace();
         }
         return relativeAddr;
     }

    /**
     * 创建目标路径所涉及到的目录，即/home/work/image/xxx.jpg
     * 那么home work image这些文件夹都要自动创建出来
     * @param targetAddr
     */

    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath()+targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输入文件流的扩展名，即是jpg还是png
     * @param cFile
     * @return
     */
    private static String getFileExtension(CommonsMultipartFile cFile) {
        String originalFileName = cFile.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名，当前年月日小时分钟秒+五位随机数
     * @return
     */
    private static String getRandomFileName() {
        //获取随机五位数
        int randomNum = r.nextInt(89999)+10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr+randomNum;
    }

    public static void main(String[] args) throws IOException {
        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        Thumbnails.of(new File("D:/code/image/xiaohuangren.jpg")).size(200,200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("D:/code/myo2o/src/main/resources/watermark.jpg")),0.1f)
                .outputQuality(0.8f).toFile("D:/code/image/xiaohuangrenNEW.jpg");

    }
}
