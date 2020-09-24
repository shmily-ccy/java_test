package day_2020_09_09;

import java.io.*;
import java.net.URL;

/**
 * @Auther: ccy
 * @Date: 2020/9/13 - 21:22
 * @Description:
 * 练习访问百度链接获取页面数据,只要经过网络传输的一般都是字节
 * @version: 1.0
 */
public class BaiDuTest {
    public static void main(String[] args) {
        BufferedReader bufferedReader=null;
        BufferedWriter bufferedWriter=null;
        try {
            bufferedReader=new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8"));
            bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html")));
            String msg=null;
            while ((msg=bufferedReader.readLine())!=null){
                bufferedWriter.write(msg);
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
