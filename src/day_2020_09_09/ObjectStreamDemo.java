package day_2020_09_09;

import day_2020_09_02.Person;
import org.junit.Test;

import java.io.*;

/**
 * @Auther: ccy
 * @Date: 2020/9/13 - 19:16
 * @Description:
 * 将java对象写入到输出流中
 *
 * 1 如果需要将对象通过io流进行传输,那么必须要实现序列化接口
 * 2 当前类中必须要声明一个序列化值
 * 3 transient(瞬时):使用此关键字修改是的变量,在进行序列化的时候,不会被序列化
 * @version: 1.0
 */
public class ObjectStreamDemo {
    /**
     * 输入到文件中的是乱码的,我们肉眼是没有办法识别的,所以用对应的input流读入程序内看一下
     */
    @Test
    public void test1(){
        ObjectOutputStream objectOutputStream=null;
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=new FileOutputStream("aaa");
            objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(new Person("张三",12,"123456"));
            objectOutputStream.writeUTF("www.mashibing.com");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test2(){
        ObjectInputStream objectInputStream=null;
        FileInputStream fileInputStream=null;
        try {
            fileInputStream=new FileInputStream("aaa");
            objectInputStream=new ObjectInputStream(fileInputStream);

            Person o = (Person)objectInputStream.readObject();
            System.out.println(objectInputStream.readUTF());
            System.out.println(o);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                objectInputStream.close();
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
