package day_2020_09_09;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: ccy
 * @Date: 2020/9/9 - 19:19
 * @Description:
 * @version: 1.0
 */
public class CollectionsDemo {
    @Test
    public void test(){
        List<String> list=new ArrayList<>();
        list.add("adad");
        list.add("bda");
        list.add("cdadad");
        list.add("ddadadaa");
        //将后面的元素添加到指定的集合中
        Collections.addAll(list,"ee","fwerw","grwrwr");
        System.out.println(list);
        System.out.println(Collections.binarySearch(list, "ddadadaa"));
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length()){
                    return 1;
                }else if(o1.length()<o2.length()){
                    return -1;
                }
                return 0;
            }
        });
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length()){
                    return 1;
                }else if(o1.length()<o2.length()){
                    return -1;
                }
                return 0;
            }
        });
        System.out.println(list);
        //二分查找的时候,需要先手动进行排序操作,如果没有排序的话, 是找不到指定元素的
        System.out.println(Collections.binarySearch(list, "ddadadaa"));

        Collections.fill(list,"mashibing");
        System.out.println(list);
    }
}
