package day_2020_08_31$09_01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ccy
 * @Date: 2020/9/3 - 19:56
 * @Description:
 * @version: 1.0
 */
public class DogListTest {
    @Test
    public void test(){
        List list=new ArrayList();
        Dog d1=new Dog("大黄","red");
        Dog d2=new Dog("二黄","block");
        Dog d3=new Dog("三黄","red");
        list.add(d1);
        list.add(d2);
        list.add(d3);
        System.out.println(list);
        System.out.println(list.size());
        list.remove(d1);
        System.out.println(list);
        Dog d4=new Dog("二黄","block");
        System.out.println(list.contains(d4));//重写equals和hashCode,判断具体值
    }
}
