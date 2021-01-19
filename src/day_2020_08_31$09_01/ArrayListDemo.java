package day_2020_08_31$09_01;

import org.junit.Test;

import java.io.ObjectInputStream;
import java.lang.reflect.Field;
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
        getCapacity(demo);
        demo.add("1");
        demo.add("2");
        demo.add("3");
        demo.add("4");
        demo.add("5");
        demo.add("6");
        demo.add("7");
        demo.add("8");
        getCapacity(demo);
        demo.add("9");
        demo.add("10");
        System.out.println("超过初始容量10");
        getCapacity(demo);
        demo.add("11");
        demo.add("12");
        demo.add("13");
        demo.add("14");
        demo.add("15");
        getCapacity(demo);
        demo.add("16");
        demo.add("17");
        demo.add("18");
        demo.add("19");
        demo.add("20");
        System.out.println("超过初始容量两倍");
        getCapacity(demo);
        demo.add("21");
        demo.add("22");
        demo.add("23");
        demo.add("24");
        getCapacity(demo);
    }

    /**
     * 左移:右移一位是原来的基础除以2
     * 右移:左移一位是原来的基础乘以2
     */
    @Test
    public void test2(){
        int i=10;
        int i1 = i >> 1;
        int i2 = i << 1;
        System.out.println("右移一位后:"+i1);//5
        System.out.println("左移一位后:"+i2);//20
    }

    /**
     * 获取集合容量
     */
    public void getCapacity(ArrayList list){
        try {
            Class<ArrayList> arrayListClass = ArrayList.class;
            Field elementData = arrayListClass.getDeclaredField("elementData");//可查看源码中的elementData的解释
            elementData.setAccessible(true);
            Object[] objects = (Object[]) elementData.get(list);
            System.out.println("当前arrayList的容量:"+objects.length);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
