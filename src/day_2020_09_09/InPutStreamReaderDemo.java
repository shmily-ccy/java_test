package day_2020_09_09;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: ccy
 * @Date: 2020/9/13 - 16:38
 * @Description:
 * @version: 1.0
 */
public class InPutStreamReaderDemo {
    @Test
    public void test(){

        File file=new File("aaa");
        InputStreamReader inputStreamReader=null;
        FileInputStream fileInputStream=null;
        try {
            //我们在通过web前端传文件到后台的时候,获都是只能获取字节流,获取不到字符流,所以,为了提高字节流的操作,就会将获取到的字节流就行包装
            ServerSocket serverSocket=new ServerSocket(10086);
            Socket accept = serverSocket.accept();
            accept.getInputStream();
            accept.getOutputStream();

            fileInputStream=new FileInputStream(file);
            inputStreamReader=new InputStreamReader(fileInputStream);
            //为什么没有用循环的方式,因为数据比较少,无法全部占用1024个缓冲区,只需要读取一次即可
            char[] buffer=new char[1024];
            int length=inputStreamReader.read(buffer);
            System.out.println(new String(buffer,0,length));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test2(){
        InputStreamReader inputStreamReader=null;
        FileInputStream fileInputStream=null;
        OutputStreamWriter outputStreamWriter=null;
        OutputStream outputStream=null;
        try {
            outputStream=new FileOutputStream("7.jpg");
            outputStreamWriter=new OutputStreamWriter(outputStream);
            fileInputStream=new FileInputStream("1.jpg");
            inputStreamReader=new InputStreamReader(fileInputStream);
            //为什么没有用循环的方式,因为数据比较少,无法全部占用1024个缓冲区,只需要读取一次即可
            char[] buffer=new char[1024];
            int length=0;
            while((length=inputStreamReader.read(buffer))!=-1){
                outputStreamWriter.write(buffer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                //按照上面new时的倒叙进行关流操作
                inputStreamReader.close();
                fileInputStream.close();
                outputStreamWriter.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
