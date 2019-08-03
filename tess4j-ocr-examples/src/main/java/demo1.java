import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author zhudg39@gmail.com
 * @description 使用tess4j识别无干扰线无扭曲无交叠数字英文类图形验证码
 * @date 2019/8/3 12:29
 */
public class demo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("D://tesseract/test1.png");
        //首先使用ImageIO读取文件,一些jpg文件会损坏无法识别
        BufferedImage bufferedImage = ImageIO.read(file);
        Tesseract tesseract = new Tesseract();
        //tessdata目录放在src同一级目录,否则就需要调用setDatapath()
        try {
            System.out.println("识别结果:" + tesseract.doOCR(bufferedImage));
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
