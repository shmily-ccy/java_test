package day_2020_09_02;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Auther: ccy
 * @Date: 2020/9/2 - 21:51
 * @Description:
 *
 * 1 set中存放的是无序,唯一的数据
 * 2 接口的不同子类的实现,区别在于其底层的数据结构是有区别的
 * 3 hashset的底层是hashMap,hashSet采用的是哈希表的存储结构
 * 4 hashSet add方法的源码中:
 * putVal(hash(key), key, value, false, true);
 * 因为hashset中要求是无序的,所以就有散列的放在集合中,所以就需要定一个规则在集合中放数据,根据规则取余数,放在对应的元素要放入的
 * 下角标
 * 5 set不可以通过下标获取对应元素的值,因为无序的特点
 * 6 hashSet是如何保障元素的唯一性呢?
 * 是通过元素的hashCode和equals方法来完成,如果元素的hashCode相同(为了判断当前对象的值应该放在集合的哪个单元格里,因为hashSet是哈希表,里面有对应的hash值),才会判断equals是否为true
 *                                      如果元素的hashCode不同,不会调用equals方法
 *
 *
 *
 * @version: 1.0
 */
public class Set_hashSetDemo {
    @Test
    public void test(){
        Set set=new HashSet();
        set.add("123");
        set.add(1);
        set.add(1);
        set.add(true);
        System.out.println(set);

        Iterator iterator = set.iterator(); //该对象在整个类执行完才会被回收掉
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=====================");
        //将while循环改为for循环,推荐使用第二种:当for循环结束的时候就会被收掉
        for(Iterator itr=set.iterator();itr.hasNext();){
            System.out.println(itr.next());
        }
    }
}
