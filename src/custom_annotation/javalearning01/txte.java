package custom_annotation.javalearning01;

import box.ArrayBox;

import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class txte {
    public static void main(String[] args) {
        /**
         * 获取电脑桌面绝对路径
         */
        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
        String desktopPath = desktopDir.getAbsolutePath();
        System.out.println(desktopPath);
    }
}
