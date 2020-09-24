package day_2020_09_09;

import org.junit.Test;

import java.io.*;

/**
 * @Auther: ccy
 * @Date: 2020/9/13 - 20:43
 * @Description:
 * @version: 1.0
 */
public class BufferReaderAndBufferWriterDemo {
    @Test
    public void test() {
        BufferedReader bufferedReader=null;
        try {
            bufferedReader=new BufferedReader(new FileReader("bbb"));
            String read = null;
            while ((read=bufferedReader.readLine())!=null){
                System.out.println(read);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test2() {
        BufferedWriter bufferedWriter=null;
        try {
            bufferedWriter=new BufferedWriter(new FileWriter("bbb"));
            bufferedWriter.append("马士兵");
            bufferedWriter.newLine();//换行的操作
            bufferedWriter.append("mashibingjiaoyu");
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
