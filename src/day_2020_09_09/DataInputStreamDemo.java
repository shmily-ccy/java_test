package day_2020_09_09;

import java.io.*;

/**
 * @Auther: ccy
 * @Date: 2020/9/13 - 19:09
 * @Description:
 * 写出的顺序与读取的顺序要一致,如果顺序不一致的话,就会报错
 * @version: 1.0
 */
public class DataInputStreamDemo {
    public static void main(String[] args) {
        FileInputStream fileInputStream=null;
        DataInputStream dataInputStream=null;
        DataOutputStream dataOutputStream=null;
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=new FileOutputStream("aaa");
            dataOutputStream=new DataOutputStream(fileOutputStream);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeChar(99);
            dataOutputStream.writeLong(8L);
            fileInputStream=new FileInputStream("aaa");
            dataInputStream=new DataInputStream(fileInputStream);
            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readChar());
            System.out.println(dataInputStream.readLong());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
