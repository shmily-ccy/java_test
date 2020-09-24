package day_2020_09_09;

import org.junit.Test;

import java.io.*;

/**
 * @Auther: ccy
 * @Date: 2020/9/13 - 21:04
 * @Description:
 * 控制台输入数据,直到输入exit退出
 * @version: 1.0
 */
public class ExitTest {
    @Test
    public void test1(){
        InputStreamReader inputStreamReader=new InputStreamReader(System.in);
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(System.out);
        BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        try {
            String str="";
            while (!str.equals("exit")){
                str=bufferedReader.readLine();
                bufferedWriter.write(str);
                bufferedWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
                outputStreamWriter.close();
                inputStreamReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 重构的第二种写法
     */
    @Test
    public void test2(){
        /**
         * 可以省略到关闭io流的操作
         */
        try(InputStreamReader inputStreamReader=new InputStreamReader(System.in);
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(System.out);
            BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);) {
            String str="";
            while (!str.equals("exit")){
                str=bufferedReader.readLine();
                bufferedWriter.write(str);
                bufferedWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
