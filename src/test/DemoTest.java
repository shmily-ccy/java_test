package test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

/**
 * @Auther: ccy
 * @Date: 2020/10/30
 * @Description:
 */
public class DemoTest {
    @Test
    public void test(){

        JSONArray arr=new JSONArray();
        JSONObject obj=new JSONObject();
        obj.put("age",2);

        JSONObject obj2=new JSONObject();
        obj2.put("age",6);
        JSONObject obj3=new JSONObject();
        obj3.put("age",9);

        arr.add(obj);
        arr.add(obj2);
        arr.add(obj3);
        arr = arr.stream().sorted(Comparator.comparing(o -> ((JSONObject) o).getInteger("age")).reversed()).limit(10).collect(Collectors.toCollection(JSONArray::new));
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.getJSONObject(i).getInteger("age"));
        }
    }
    @Test
    public void test1(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }

        list.forEach(l-> System.out.println(l));

    }

    @Test
    public void test2(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }

        list.forEach(l-> System.out.println(l));
    }

    @Test
    public void test3(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for (int i = list.size() - 1; i >= 0; i--) {
            list.remove(i);
        }

        list.forEach(l-> System.out.println(l));
    }

    @Test
    public void test4(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(4);
        ListIterator<Integer> iterator= list.listIterator();
        while (iterator.hasNext()){
            int next = iterator.next().intValue();
            if(2==next){
                iterator.remove();
            }
            if(4==next){
                iterator.remove();
            }
        }

        list.forEach(l-> System.out.println(l));
    }
    @Test
    public void test5(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(4);
        ListIterator<Integer> iterator= list.listIterator();
        while (iterator.hasNext()){
            if(2==iterator.next()){
                iterator.remove();
            }
        }

        list.forEach(l-> System.out.println(l));
    }
}
