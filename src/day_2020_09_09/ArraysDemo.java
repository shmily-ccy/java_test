package day_2020_09_09;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: ccy
 * @Date: 2020/9/9 - 19:38
 * @Description:
 * arrays提供了数据操作的工具类,集合和数组之间的转换
 * @version: 1.0
 */
public class ArraysDemo {
    @Test
    public void test(){
        int[] arr=new int[]{1,2,3,4};
        //数组转换成list
        //把当前整体对象转换成一个集合,集合是一个int数组类型
        List<int[]> ints = Arrays.asList(arr);
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        //list转换成数组
        Object[] objects = integers.toArray();

    }
}
