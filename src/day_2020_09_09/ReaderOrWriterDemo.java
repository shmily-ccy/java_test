package day_2020_09_09;

import org.junit.Test;

import java.io.*;

/**
 * @Auther: ccy
 * @Date: 2020/9/13 - 15:29
 * @Description:
 *
 * 字符流可以直接读取中文汉字,而字节流在处理的时候会出现中文乱码(中文不一定是两个字节,中:就有三个字节)
 * @version: 1.0
 */
public class ReaderOrWriterDemo {
    @Test
    public void test1(){
        Reader reader=null;
        try {
             reader=new FileReader("aaa");
            int read = reader.read();
            System.out.println(read);
            System.out.println((char)read);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test2(){
        Reader reader=null;
        try {
            reader=new FileReader("aaa");
            int read=0;
            while ((read=reader.read())!=-1){
                System.out.print((char)read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test3(){
        Reader reader=null;
        try {
            reader=new FileReader("aaa");
            char[] buffers=new char[1024];
            int length=0;
            while ((length=reader.read(buffers))!=-1){
                /*for (char buffer : buffers) {
                    System.out.print(buffer);
                }*/
                System.out.println(new String(buffers,0,length));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 什么时候加flush,什么时候不加flush:
     *    最保险的方式,在输出流关闭之前每次都先flush,然后再close:如果流内不带缓冲区,close相当于完成了缓冲操作,而如果带缓冲区的话,必须要用flush
     *    当某一个输出流的对象中带有缓冲区的时候,就需要进行flush,不建议大家记住每个输出流的分类,
     */
    @Test
    public void test4(){
        File file=new File("writer.txt");
        Writer writer=null;
        try {
            writer=new FileWriter(file);//如果文件不存在,会自动创建此文件
            writer.write("www.mashibing.com");
            writer.write("马士兵教育");
            writer.flush();//flush强制将数据刷到内存中,加上flush,没有加close,writer.txt中也会写入数据,如果没有flush和close就不会有数据
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();//如果这里不写close,我们会发现writer.txt中没有数据,加上close,没有加flush,也会有数据
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
