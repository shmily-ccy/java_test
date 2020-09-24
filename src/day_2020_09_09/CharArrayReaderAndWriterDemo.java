package day_2020_09_09;

import org.junit.Test;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * @Auther: ccy
 * @Date: 2020/9/13 - 20:26
 * @Description:
 * @version: 1.0
 */
public class CharArrayReaderAndWriterDemo {
    @Test
    public void test1() {
        char[] buffer="马士兵教育".toCharArray();
        CharArrayReader charArrayReader=new CharArrayReader(buffer);
        try {
            int read=0;
            while ((read=charArrayReader.read())!=-1){
                System.out.print((char)read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            charArrayReader.close();
        }
    }
    @Test
    public void test2() {
        CharArrayWriter charArrayWriter=new CharArrayWriter();
        try {
            charArrayWriter.write(97);
            charArrayWriter.write(98);
            charArrayWriter.write(99);
            System.out.println(charArrayWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            charArrayWriter.close();
        }
    }
}
