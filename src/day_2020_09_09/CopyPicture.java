package day_2020_09_09;

import org.junit.Test;

import java.io.*;
import java.util.zip.Inflater;

/**
 * @Auther: ccy
 * @Date: 2020/9/13 - 16:05
 * @Description:
 * @version: 1.0
 */
public class CopyPicture {
    /**
     * 结果会发现图片不支持打开:在处理纯文本的时候,字符流和字节流都可以,但是处理图片,视频及其他格式文件的时候的时候,字符流就会出错,使用字节流
     * 因为字节流是万能的
     */
    @Test
    public void test(){
        FileReader reader=null;
        FileWriter writer=null;
        try {
             reader=new FileReader("1.jpg");
             writer=new FileWriter("2.jpg");
             char[] buffers=new char[1024];
             int length=0;
             while ((length=reader.read(buffers))!=-1){
                 writer.write(buffers);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void test2(){
        FileInputStream inputStream=null;
        FileOutputStream outputStream=null;
        try {
            inputStream =new FileInputStream("1.jpg");
            outputStream=new FileOutputStream("3.jpg");
            byte[] buffers=new byte[1024];
            int length=0;
            while ((length=inputStream.read(buffers))!=-1){
                outputStream.write(buffers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
