package day_2020_08_31$09_01;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Auther: ccy
 * @Date: 2020/9/1 - 19:18
 * @Description:
 *
 * arraylist的初始化长度是10,当长度不够的时候会自动扩容(grow)
 * int newCapacity = oldCapacity + (oldCapacity >> 1):右移一位表示除以2,也就是原来的长度加上一半的长度,1.5倍的长度
 * @version: 1.0
 */
public class ArrayListDemo {
    @Test
    public void test(){
        ArrayList demo=new ArrayList();
        demo.add("1");
        demo.add("2");
        demo.add("3");
        demo.add("4");
        demo.add("5");
        System.out.println(demo);
    }

}
