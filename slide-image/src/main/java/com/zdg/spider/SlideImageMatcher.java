package com.zdg.spider;

import org.opencv.core.*;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhudg39@gmail.com
 * @description 匹配拼图类滑块验证码:根据你的系统在启动参数中添加-Djava.library.path=$PROJECT_DIR$\opencv\x64
 * @date 2019/6/23 15:52
 */
public class SlideImageMatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(SlideImageMatcher.class);
    /**
     * 图片所在根路径
     */
    private static final String IMAGE_ROOT_PATH = "D://";

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    /**
     * 将模板图片的空白部分裁剪掉
     * @return
     */
    private static Mat trim(Mat mat){
        //找到所有非黑像素点
        MatOfPoint result = new MatOfPoint();
        Core.findNonZero(mat,result);
        Rect rect = Imgproc.boundingRect(result);
        int x = rect.x,w = rect.width,y=rect.y,h=rect.height;
        return new Mat(mat,new Range(y + 20,y + h - 20),new Range(x,x + w - 20));
    }


    /**
     * 展示
     * @param targetImage
     * @param templateImage
     */
    public static Double match(String targetImage,String templateImage) {
        long startTime = System.currentTimeMillis();
        Double x = 0.0;
        try {
            //加载原始RGB图像
            Mat targetImageMat = Highgui.imread(targetImage);
            //创建一个原始图像的灰度版本，所有操作在灰度版本中处理，然后在RGB图像中使用相同坐标还原
            Mat targetImageGray = new Mat();
            Imgproc.cvtColor(targetImageMat, targetImageGray,Imgproc.COLOR_RGB2GRAY);

            //加载将要搜索的图像模板
            Mat templateImageMat = Highgui.imread(templateImage, 0);
            //java中imshow()方法被阉割掉,使用imwrite代替
            Highgui.imwrite(IMAGE_ROOT_PATH + "img_gray.png",targetImageGray);

            Mat newTemplateImageMat = trim(templateImageMat);

            //使用matchTemplate对原始灰度图像和图像模板进行匹配
            Mat result = new Mat();
            Imgproc.matchTemplate(targetImageGray, newTemplateImageMat, result, Imgproc.TM_CCOEFF_NORMED);

            //获取矩阵
            Core.MinMaxLocResult resultLoc = Core.minMaxLoc(result);
            Point topLeft = resultLoc.maxLoc;
            x = topLeft.x;
        } catch (Exception e) {
            LOGGER.error("targetImage -> {} templateImage -> {} 匹配滑块失败", targetImage, templateImage, e);
            return x;
        }
        long endTime = System.currentTimeMillis();
        LOGGER.info("匹配滑块验证码耗时:{}", (endTime - startTime) + "ms");
        return x;
    }

    public static void main(String[] args) {
        Double x = match(IMAGE_ROOT_PATH + "ba.png",IMAGE_ROOT_PATH + "bu.png");
        LOGGER.info("匹配后得到的值:{}",x);
    }
}