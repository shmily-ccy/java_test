package day_2020_09_09;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Auther: ccy
 * @Date: 2020/9/13 - 18:12
 * @Description:
 * 带缓冲的流,每次都是将数据读取到自带的缓冲区中
 * @version: 1.0
 */
public class BufferInputStreamDemo {
    public static void main(String[] args) {
        //其构造方法中需要inputstream,所以也是属于处理流
        FileInputStream fileInputStream=null;
        BufferedInputStream bufferedInputStream=null;
        try {
            fileInputStream=new FileInputStream("aaa");
             bufferedInputStream=new BufferedInputStream(fileInputStream);
            int read = 0;
            while ((read = bufferedInputStream.read())!=-1){
                bufferedInputStream.skip(4);//因为有缓冲区所以可以进行跳动
                System.out.print((char)read);//会出现中文乱码:因为一个中文占多个字节
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedInputStream.close();
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
