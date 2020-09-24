package day_2020_09_09;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.EmptyFileFilter;

import java.io.File;
import java.util.Collection;

/**
 * @Auther: ccy
 * @Date: 2020/9/14 - 19:18
 * @Description:
 * @version: 1.0
 */
public class FileUtilsDemo {
    public static void main(String[] args) {
        long aaa = FileUtils.sizeOf(new File("baidu.html"));
        System.out.println("size:"+aaa);
        //打印目录,空的不进行显示
        Collection<File> files = FileUtils.listFiles(new File("c:"), EmptyFileFilter.NOT_EMPTY, null);
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
