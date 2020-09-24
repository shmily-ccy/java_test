package day_2020_09_02;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Auther: ccy
 * @Date: 2020/9/3 - 19:26
 * @Description:
 * 1 底层是treeMap,采用二叉树(红黑树)的存储结构(树:有根节点,有叶子,要求的就是数据结构要一样),最多只能有两个分支,左子树的节点小于根节点数,右
 * 子树的节点数大于根节点进行排序,所以说底层涉及到树结构的都会排序
 * 2 treeSet和hashSet的区别:
 *   优点:有序(排序后的升序),查询速度比list快
 *   缺点:查询速度没有hashSet快,hashSet是hash表存储,根据索引下标直接获取值
 * 3 树中的元素是要默认进行排序操作的,如果是基本数据类型,自动比较,如果是引用类型,需要自己自定义比较器
 * 4 比较器分类:
 *      内部比较器:定义在元素的类中,通过实现comparanle接口来实现
 *                只有在存储当前对象的时候才可以使用
 *      外部比较器:定义在当前类中,通过实现comparator接口来实现,但是要将该比较器传递到集合中,告诉集合我必须要使用这个比较器,我们的TreeSetDemo实现了比较器接口,所以,就是比较器的一个子类
 *                可以定义成一个工具类,此时所有需要比较的,规则如果一致的话,可以复用
 *      如果两者同时存在,使用外部的比较器
 *
 *      当使用比较器的时候,不会调用equals方法
 *
 * @version: 1.0
 */
public class TreeSetDemo_比较器 implements Comparator<Person> {
    @Test
    public void test(){
        TreeSet<Person> treeSet = new TreeSet<>(new TreeSetDemo_比较器());//当前set集合默认使用这个比较器了,不会再使用类中定义的比较器了

        Person p1=new Person("zhangsan",12);
        Person p2=new Person("zhangsan",12);
        Person p3=new Person("lisi",13);
        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);

      /*  HashSet<Object> treeSet = new HashSet<>();
        Dog d1=new Dog("大黄","red");
        Dog d2=new Dog("二黄","block");
        Dog d3=new Dog("二黄","block");
        treeSet.add(d1);
        treeSet.add(d2);
        treeSet.add(d3);*/

       // System.out.println(treeSet.ceiling(4));
        System.out.println(treeSet);
    }

    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getAge()>o2.getAge()){
            return -1;
        }else if(o1.getAge()<o2.getAge()){
            return 1;
        }
        return 0;
    }
}
