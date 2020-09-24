package day_2020_09_07$09_08;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: ccy
 * @Date: 2020/9/7 - 21:14
 * @Description:(集合这块,底层结构也就是数组,链表,红黑树)
 * 1 hashMap原理:hash表结构,比如有一个8(默认值是16,也就是16取模)个长度的数组(内存中连续的存储空间,其数据中的每一个元素就是Entry,Entry包含key,value,hash,next:指向下一个节点),取k值,然后根据hash进行取模(比如说除以8的长度进行取模),然后放入对应的数组中,针对于取模后数据
 * 相等的,以链表的形式串起来,k_v取值,拿到k,取hashCode的值,然后模8的余数,可是判断数据在哪个单元格,然后再进行equals的对比
 * 2 map存储的是k_v键值对映射的数据
 *       2.1 map的实现子类:
 *          HashMap:数组+链表(JDK1.7),数组+链表+红黑树(JDK1.8)
 *          LinkedHashMap:链表
 *          TreeMap:红黑树
 *3 hashMap和hashTable:
 *    3.1 hashMap是线程不安全的,效率比较高,hashTable是线程安全的,效率低
 *    3.2 hashMap的键值可以为null,hashTable的键值都不允许为空
 *4除法散列法(哈希函数):用来设计散列函数的除法散列法,通过k除以m的余数,将关键字k映射到m个槽中的某一个上,即散列函数为h(k)=kmodm (取余),由于只需要做一次除法操作,所以除法散列法是非常快的,
 * m值的选择:一个不太接近2的整数幂的素数
 *5 JDK 1.7 (数组+链表)hashMap源码:
 *   5.1 static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
 *     5.1.1 hashMap是数组加链表,数组的默认容量(左移4位)2的4次方,与上面的除法散列法的m的选择是有悖的,其初始值为2的n次幂,是因为方便与&运算
 *        与运算的效率比取模运算的效率高,2的n次幂,也就是1111,1010&1111都是1010,所以计算的很快
 *     5.1.2 在进行扩容之后涉及到元素的迁移运算,迁移的时候,只需要判断二进制的前一位是0或者1即可,如果是0表示新数组和旧数组下标位置不变,如果是1,只需要将索引位置加上旧的数组长度值即为新数组的下标值
 *   5.2 static final int MAXIMUM_CAPACITY = 1 << 30; (左移30位)2的30次方
 *   最大容量
 *   5.3 static final float DEFAULT_LOAD_FACTOR = 0.75f;
 *   默认加载因子0.75,例如:默认容量是16,16乘以0.75是12,在容量达到12的时候,进行扩容操作(扩容操作涉及到老元素的移动,数据越多,就会越浪费时间),默认的扩容大小是2倍
 *   5.4 hashmapd的构造方法并没有在堆内开辟具体的空间,只是对加载因子,初始值是否合法的判断
 *   5.5 在put时进行空间的开辟,Entry的next中是存储下一个地址,hash:key的hash值
 *   inflateTable(threshold);
 *    h ^= (h >>> 20) ^ (h >>> 12);
 *         return h ^ (h >>> 7) ^ (h >>> 4);//减少hash碰撞的计算,
 *   5.6 h & (length-1):与运算的效率比取模运算的速度快,这个就是计算key要放在哪个位置上
 *   5.7 主要是put操作,主要有 1:设置值,计算hash  2:扩容操作   3:数据迁移
 *
 *6 JDK 1.8 (数组+链表+红黑树)hashMap源码:
 *      7.1 static final int TREEIFY_THRESHOLD = 8;//如果链表的长度大于等于7的时候了,会相应的转换为红黑树,链表转为红黑树提高检索效率
 *          TreeNode<K,V> prev;//标识当前为红节点或者黑节点
 *          resize//扩容方法
 *          threshold:初始值乘以扩载因子
 *          newCap:新数组的容量
 *          newThr:超过多少进行扩容,进行扩容判断的值
 *      7.2 (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);//在1.7的时候,计算数据下标位置的时候,只能取低位,不能取高位,而在1.8,进行右移的时候,会把数据推向高位,让高位参与运算,这样做来减少哈希碰撞,也叫扰动函数
 * @version: 1.0
 */
public class HashMapDemo_Hash存储原理 {
    @Test
    public void test(){
        Map<String,Integer> map=new HashMap<String,Integer>();
        //基本操作 1
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        map.put(null,null);
        System.out.println(map);
        //2
        System.out.println(map.isEmpty());
        //3
        System.out.println(map.size());
        //4:表示的是k_v组合的一种映射关系,k_v配对出现
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey()+"======="+next.getValue());
        }
    }
}
