package day_2020_09_09;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.*;

/**
 * @Auther: ccy
 * @Date: 2020/9/10 - 17:53
 * @Description:
 * 文件输入流
 * @version: 1.0
 */
public class FileInputStreamAndOutPutStreamDemo {

    @Test
    public void test1(){
        FileInputStream fileInputStream=null;
        try {
            fileInputStream=new FileInputStream("aaa");
            int read = 0;
            System.out.println(read=fileInputStream.read());
            //读取的是字节
            while ((read=fileInputStream.read())!=-1){
                System.out.print((char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test2(){
        FileInputStream fileInputStream=null;
        try {
            fileInputStream=new FileInputStream("aaa");
            byte[] buffer=new byte[1029];
            //首先会对aaa文件中的字符长度与buffer的长度做对比,如果aaa的长度大于buffer,就会将aaa中1024的字符放入buffer中,然后进行下一轮的取字符,放入buffer中,第二次取的字符会
            //覆盖1024数组中的数据,所以,每次转为string的时候,转的都是剩余读取的字符数,不然会将buffer中存的上一次的字符数一同输出
            int length=fileInputStream.read(buffer) ;
            while (length!=-1){
                System.out.println(length);
                System.out.println(new String(buffer,0,length));
                length=fileInputStream.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test3(){
        FileInputStream fileInputStream=null;
        try {
            fileInputStream=new FileInputStream("ccc");
            byte[] buffer=new byte[1024];
            int length = 0;
            while ((length=fileInputStream.read(buffer, 10, 3))!=-1){
                //System.out.println(length);
                System.out.println(new String(buffer,7,length));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * for循环的执行过程
     * 每一次循环的时候,都会用i++对i的值进行修改,然后判断i<arr.length是否满足条件,进入循环体
     */
    @Test
    public void test4(){
        String[] arr=new String[]{"a","b","c"};
        int j=0;
        for(int i=0;i<arr.length;i++){
            System.out.println(i);
            System.out.println(arr[i]);
            j=i;
        }
    }

    @Test
    public void test5(){
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        try {
            fileInputStream=new FileInputStream("图片文本.doc");
            fileOutputStream=new FileOutputStream("图片文本3.doc");
            byte[] buffer=new byte[1024];
            int length = 0;
            while ((length=fileInputStream.read(buffer))!=-1){
                //System.out.println(length);
                fileOutputStream.write(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test6(){
        File file=new File("ddd");
        OutputStream outputStream=null;
        try {
            outputStream=new FileOutputStream(file);
            outputStream.write(99);
            outputStream.write("\r\nmashibing".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将aaa中的数据写到ddd中
     */
    @Test
    public void test7(){
        FileInputStream inputStream=null;
        FileOutputStream outputStream=null;
        try {
            inputStream=new FileInputStream("ccc");
            outputStream=new FileOutputStream(new File("eee"));
            byte[] buffer=new byte[1024];
            int length=0;
            while ((length=inputStream.read(buffer))!=-1){
                outputStream.write(buffer);
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
