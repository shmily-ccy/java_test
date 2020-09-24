package day_2020_09_09;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: ccy
 * @Date: 2020/9/9 - 21:12
 * @Description:
 * 1 在java中需要读写文件中的数据,需要使用流的概念:
 *    流表示从一个文件将数据发送到另一个文件,包含一个流向的问题,最终需要选择一个参照物,当前程序作为参照物(我们用程序在堆文件的数据进行传输,通过程序将一个文件的内容传送到另一个文件中)
 *        输入流(程序读数据):从一个文件(文件在硬盘中)中读取数据到程序(程序在内存中):源数据源------>程序
 *        输出流(程序往外写数据):从程序输出数据到另一个文件中:程序------>目标数据源
 * 2  数据源:凡是可以存储数据的就可以叫数据源:数据库,文件,其他程序,内存,网络连接,IO设备
 * 3  java流按照流向分:输入流,输出流
 *          按照处理数据单元划分:字节流(8位),字符流(16位的unicode)//字节流是物理概念,字符流是逻辑概念,物理上没有叫做字符的
 *          纯文本的时候,当做字符存储多,图片的话,是字节流
 *    java流按照功能分为:节点流,处理流
 *          1 节点流:直接从数据源目或目的源读写数据(从一个节点到目的节点只有一根管道,一个流处理的).
 *          2 处理流(包装流):在当前流的对象上套一个对象,不直接连接到数据源或目的地,是其他流进行封装,目的主要是简化操作和提高性能,
 *          3 节点流和处理流的关系:  io操作的第一线所有操作必须通过节点流进行,处理流是对其他流进行处理(提高效率或操作灵活性)
 *             数据源----节点流--->程序          数据源----处理流(将节点流进行了无数次包装的)-->程序
 *
 * 4  字节流:inputStream
 *  *       outputStream
 *    字符流:render
 *          writer
 *
 * 注意:io程序一定要进行关闭流
 *      原因:linux是有文件数量的限制的,1G最多有10万个文件,一个进程最多打开1024个文件,打开文件个数与资源是挂钩的,不关闭流就一直占用着系统资源
 * @version: 1.0
 */
public class StreamDemo {
    @Test
    public void test(){
        //从文件中读取数据
        InputStream inputStream=null;
        try {
             inputStream=new FileInputStream("aaa");
             //第一种方法,读取一个字节,read是读取的是当前字母所表示的字节
            /*int read = inputStream.read();
            System.out.println(read);
            System.out.println((char) read);*/
            //第二种方式:每次读取一个字节,循环读,效率比较低,read是读取的是当前字母所表示的字节,字节可以当成整数进行运算,读取的是字节所表示的ascii码值
            /*int read=0;
            while ((read=inputStream.read())!=-1){
                System.out.println(read);
                System.out.println((char) read);
            }*/
            //第三种方式:添加缓冲区的方式,每次会将数据添加到缓冲区中,当缓冲区满了之后,一次读取,而不是每一个字节进行读取
            /*byte[] buffer=new byte[1024];//每次在读取的时候,读的就是1024个字节
            int length=0;//此时的length表示的是读取到缓冲区的总字节数
            while ((length=inputStream.read(buffer))!=-1){//io流在进行读取的时候记录的长度,总共是26个字母
                System.out.println(new String(buffer,0,length));//读取缓冲区buffer里的数据,从0开始,读length的长度
            }*/
            //第四种方式:
            byte[] buffer=new byte[1024];
            int length=0;
            while ((length=inputStream.read(buffer,5,20))!=-1){
                System.out.println(length);
                System.out.println(new String(buffer,0,length));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
