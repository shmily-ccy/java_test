package day_2020_09_07$09_08.作业;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: ccy
 * @Date: 2020/9/7 - 20:40
 * @Description:
 * @version: 1.0
 */
public class DemoTest  {
    @Test
    public void test(){
        LinkedList<Employee> list=new LinkedList<>();
        //元素的增加
        list.add(new Employee(1,"a",15,Gender.女));
        list.add(new Employee(2,"b",12,Gender.女));
        list.add(new Employee(3,"c",30,Gender.女));
        list.add(new Employee(4,"c",0,Gender.女));
        //元素的删除
        /*ListIterator<Employee> iterator = list.listIterator();
        while (iterator.hasNext()){
            if(iterator.next().getName().equals("b")){
                iterator.remove();
            }
        }*/
        System.out.println(list);
    }

}
