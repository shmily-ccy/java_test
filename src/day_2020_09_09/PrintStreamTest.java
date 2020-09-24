package day_2020_09_09;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @Auther: ccy
 * @Date: 2020/9/13 - 21:39
 * @Description:
 * @version: 1.0
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        PrintStream printStream=null;
        try {
            printStream=new PrintStream(System.out);
            printStream.write("hello mashibing".getBytes());
            printStream.println("true");
            //格式化输出,进行占位符的替换,在打印日志的时候有用,使用占位符,然后替换占位符
            /**
             * %s:表示字符串
             * %d:表示整数
             * %f:浮点数
             */
            System.out.printf("%s--%d---%.2f","abc",123,111.111);
            //err:错误输出,在进行错误输出的时候,换成err
            System.err.println("mashibing");
        } catch (Exception e) {
            e.printStackTrace();
        }
        printStream.close();
    }
}
