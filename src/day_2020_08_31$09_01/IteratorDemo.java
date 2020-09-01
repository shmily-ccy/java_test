package day_2020_08_31$09_01;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Auther: ccy
 * @Date: 2020/8/31 - 08 - 31 - 20:52
 * @Description:
 * @version: 1.0
 */
public class IteratorDemo {
    /**
     * 所有的集合类都默认实现了iterable接口,实现此接口意味着就可以使用增强foreach的循环,增强foreach的循环使用的是iterator
     * iterable中的方法: foreach-->default修饰,有方法体
     *                  iterator(迭代器)-->抽象方法(属于iterable)
     *  iterator方法中,要求返回一个Iterator的接口子类实例对象,此接口中包含了方法hashNext()    next()
     *  arrayList,linkedList的方法体内包含有对iterator方法的重写,具体的实现在每个距离的实体类中
     */
    @Test
    public void test1(){
        ArrayList<Object> list = new ArrayList<>();
    }

}
