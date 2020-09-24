package day_2020_09_02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @Auther: ccy
 * @Date: 2020/8/31 - 08 - 31 - 20:52
 * @Description:
 * @version: 1.0
 */
public class IteratorDemo {
    /**
     * 1 所有的集合类都默认实现了iterable接口,实现此接口意味着就可以使用增强foreach的循环,增强foreach的循环使用的是iterator
     * iterable中的方法: foreach-->default修饰,有方法体:该方法的本质实际上就是迭代器的实现
     *                  iterator(迭代器)-->抽象方法(属于iterable):迭代器是通过指针游标进行实现的
     *  iterator方法中,要求返回一个Iterator的接口子类实例对象,此接口中包含了方法hashNext()    next(),这两个也是抽象方法
     *
     *  arrayList,linkedList的方法体内包含有对iterator方法的重写,具体的实现在每个具体的实体类中
     *
     *  2 在使用iterator进行迭代的过程中,如果通过调用list集合中的remove方法删除其中的某个元素会报并发操作异常,因为内部元素位置会修改,下面的元素替代被删除元素的位置,
     *  导致iterator的指针错乱,不知道到底该指向哪一个元素,因此,如果遍历的同时修改元素,建议使用listIterator方法
     *  3 该迭代器提供了向前向后的遍历方式,始终通过curser和lastret的指针获取
     *  元素值及向下的遍历索引,当使用向前遍历的时候必须要保证指针在迭代器的结束,否则无法获取结果值
     *  */
    @Test
    public void test1(){
        ArrayList<Object> list = new ArrayList<>();
    }

    @Test
    public void test(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
/*

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
*/

        ListIterator<Integer> listIterator = list.listIterator();
        Iterator<Integer> iterator = list.iterator();
        //向后遍历
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if(next.equals(2)){
                //iterator.remove();   iterator的remove方法就是抛出异常
                //list.remove():错误的删除方式,会引起并发异常
                listIterator.remove();
            }
            System.out.println(iterator.next());
        }
        //向前遍历
       /* while (listIterator.hasPrevious()){
            System.out.println(listIterator.next());
        }

        for (Integer i : list){
            System.out.println(i);
        }*/
    }

}
