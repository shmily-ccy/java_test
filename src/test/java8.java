package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: ccy
 * @Date: 2020/11/2
 * @Description:java8 新特性
 */
public class java8 {
    /**
     * 排序
     */
    @Test
    public void test(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(9);
        list = list.stream().sorted().collect(Collectors.toList());
        list.forEach(l-> System.out.println(l));
    }
}
