package day_2020_09_09;

import org.junit.Test;

import java.io.*;

/**
 * @Auther: ccy
 * @Date: 2020/9/13 - 16:20
 * @Description:
 * @version: 1.0
 */
public class OutPutStreamWriterDemo {
    @Test
    public void test(){
        File file=new File("aaa");
        OutputStreamWriter outputStreamWriter=null;
        FileOutputStream fileOutputStream=null;
        try {
            long startTime=System.currentTimeMillis();
            fileOutputStream=new FileOutputStream(file);
            //按照自己需要存储的编码设置编码,英文是没有问题的,中文是根据编码不同改变的
            //字符流比字节流快,我们将字符流包装了字节流,图片只能用字节流,我们可以在内部用字节流处理图片,外部加上字符进行处理,这样提升了速度,灵活性就是体现在编码上
            outputStreamWriter=new OutputStreamWriter(fileOutputStream,"utf-8");
            outputStreamWriter.write(99);
            outputStreamWriter.write("马士兵教育");
            outputStreamWriter.write("abcdefg",0,5);
            long endTime=System.currentTimeMillis();
            System.out.println(endTime-startTime);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭流对象的时候,建议按照创建时顺序的逆序进行关闭
            try {
                outputStreamWriter.close();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
