package qr_code.javalearning02;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Text {
    //java绘制一个二维码
    public static void main(String[] args) throws WriterException, IOException {

        //画者MultiFormantWriter操纵虚拟二维码对象
        MultiFormatWriter mfw = new MultiFormatWriter();
        //BitMatrix(虚拟二维码对象)
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的内容，即将帮你生成二维码：");
        String s = sc.next();
        String var1 = s;
        BarcodeFormat var2 = BarcodeFormat.QR_CODE;
        int width = 500;
        int height = 500;
        Map map = new HashMap();
        //        字符集
        map.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        //纠错i等级
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        //二维码边距
        map.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = mfw.encode(var1, var2, width, height, map);
        //  I/O流
        int red = Color.red.getRGB();
        int white = Color.white.getRGB();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //循环绘制二维码
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                img.setRGB(x, y, bitMatrix.get(x, y) ? white : red);
            }
        }
        //文件图片
        System.out.println("输入你的二维码名称，即将生成二维码");
        String i = sc.next();
        File desktopDir= FileSystemView.getFileSystemView().getHomeDirectory();
        String desktopPath=desktopDir.getAbsolutePath();
        String pathname = desktopPath+"//" + i + ".jpg";
        System.out.println(pathname);
        File file = new File(pathname);
        ImageIO.write(img, "jpg", file);
    }
}
