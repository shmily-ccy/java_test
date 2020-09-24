package day_2020_09_09;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * @Auther: ccy
 * @Date: 2020/9/9 - 20:19
 * @Description:
 * @version: 1.0
 */
public class FileDemo {
    @Test
    public void test() {
        File file=new File("src/abc.txt");
        try {
            //创建文件
            file.createNewFile();
            //返回文件绝对路径的规范格式
            System.out.println(file.getCanonicalPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //判断文件的属性,都会返回boolean类型的值
        file.canExecute();
        file.canRead();
        file.canWrite();
        //判断当前文件是否存在
        System.out.println(file.exists());
        //获取文件的名称 abc.txt
        System.out.println(file.getName());
        //获取文件的绝对路径  D:\ccy\study\test_java\abc.txt
        System.out.println(file.getAbsolutePath());
        //获取文件的父路径名称,如果文件的路径中只有文件名称,则显示为空
        System.out.println(file.getParent());//null,将创建file类的后面改为src/abc.txt
        //操作系统的文件分隔符
        System.out.println(file.separator);

        //无论当前文件是否存在,只要给定具体的文件路径,都可以返回相应的路径名称
        File file1=new File("c:/a/b/c");
        System.out.println(file1.getAbsolutePath());
        //是文件,或者文件夹
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());

       /* String[] list = file1.list();
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("==========================");
        File[] files = file1.listFiles();
        for (File file2 : files) {
            System.out.println(file2);
        }
        System.out.println("===========================");
        //打印当前文件系统的盘符
        File[] files1 = File.listRoots();
        for (File file2 : files1) {
            System.out.println(file2);
        }*/
        //创建单级目录
        boolean mkdir = file1.mkdir();
        boolean mkdirs = file1.mkdirs();
    }

    public void test2(){
        //循环遍历输出c盘中的所有绝对路径
        File file2=new File("c:/");
        File[] files = file2.listFiles();
        for (File file3 : files) {
            if(file3.isDirectory()){
                getFields(file3);
            }else {
                System.out.println(file3.getAbsolutePath());
            }
        }
    }
    private void getFields(File file3) {
        File[] files = file3.listFiles();
        if(files!=null && files.length>0){
            for (File file : files) {
                if(file.isDirectory()){
                    getFields(file);
                }else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }

    }
    @Test
    public void test3() throws IOException {
        File file = new File("d:/a");
        printFile(file);
    }
    public void printFile(File file){
        if(file!=null){
            File[] files = file.listFiles();
            if(files!=null && files.length>0){
                for (File file1 : files) {
                    if(file1.isDirectory()){
                        printFile(file1);
                    }else {
                        System.out.println(file1.getAbsolutePath());
                    }
                }
            }
        }
    }
}
