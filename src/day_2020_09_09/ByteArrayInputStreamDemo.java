package day_2020_09_09;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @Auther: ccy
 * @Date: 2020/9/13 - 17:29
 * @Description:
 * 该流中包含缓冲区,缓冲区中是从流中读取的字节
 * @version: 1.0
 */
public class ByteArrayInputStreamDemo {
    public static void main(String[] args) {
        String str="www.mashibing.com";
        byte[] buffer=str.getBytes();
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(buffer);//从buffer缓冲区里读数据,所以先要在buffer缓冲区中填入数据
        int read =0;
        while ((read = byteArrayInputStream.read())!=-1){
            byteArrayInputStream.skip(4);//每读一个字节就跳四个  waio
            System.out.print((char)read);
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
