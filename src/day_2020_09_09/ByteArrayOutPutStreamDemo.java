package day_2020_09_09;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Auther: ccy
 * @Date: 2020/9/13 - 17:52
 * @Description:
 * @version: 1.0
 */
public class ByteArrayOutPutStreamDemo {
    public static void main(String[] args) {
        ByteArrayOutputStream byteArrayOutPutStream=new ByteArrayOutputStream();
        byteArrayOutPutStream.write(123);
        try {
            byteArrayOutPutStream.write("www.mashibing.com".getBytes());
            System.out.println(byteArrayOutPutStream.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                byteArrayOutPutStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
