package day_2020_09_02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @Auther: ccy
 * @Date: 2020/8/31 - 08 - 31 - 21:23
 * @Description:
 * 也是list接口的一个子类实现,与arraylist一样,底层都是用数组实现的
 * 与arraylist有区别:
 * 1 arraylist是线程不安全的,效率高
 *  vector是线程安全的,效率低
 * 2 arraylist:int newCapacity = oldCapacity + (oldCapacity >> 1);在进行扩容的时候,是扩容1.5倍
 *   vercot:int newCapacity = oldCapacity + ((capacityIncrement > 0) ? capacityIncrement : oldCapacity); 扩容为原来的两倍
 * @version: 1.0
 */
public class VertorDemo {
    @Test
    public void test(){
        ArrayList<Object> arrayList = new ArrayList<>();
        Vector vector=new Vector();
        vector.add(1);
        vector.add("abc");
        System.out.println(vector);
    }
}
