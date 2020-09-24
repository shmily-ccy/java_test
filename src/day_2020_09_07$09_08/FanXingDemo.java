package day_2020_09_07$09_08;

import day_2020_09_02.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ccy
 * @Date: 2020/9/7 - 18:48
 * @Description:
 *
 *
 * @version: 1.0
 */
public class FanXingDemo {
    @Test
    public void test(){
        //List list=new ArrayList<>();
        List<String> list=new ArrayList<String>();
        list.add("c");
        //list.add(1);  list中放入的是对象,所以这里放入的是new Integer(1);
        //list.add(true);  这里放入的就是new Boolean(true);
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        /**
         * 1 泛型:限制为某一固定类型(类中存储数据类型的一种规范)
         * 2 这里会报错:java.lang.ClassCastException: java.lang.String cannot be cast to day_2020_09_02.Person
         * 所以在做集合的操作的时候,集合的类型要统一,可以通过泛型来统一集合的类型(入参为泛型,意思是可以传任意类型,但是在使用该类的时候,传入一个固定的类型,任何对象都得是固定的一个类型),
         * 创建list的时候,会让输入类型new ArrayList<String>()
         * 给集合中的元素设置相同的类型就是泛型的基本需求
         * 3 泛型的高阶应用
         *    1 泛型类 在定义类名的时候,可以在类名的后面添加<里面写一些字母 E,K,A,B等>,起到占位的 作用类中的方法返回值类型和参数的类型都可以使用
         *    2 泛型接口  在定义接口的时候,在接口的名称添加<里面写一些字母 E,K,A,B等>
         *               1 子类在进行实现的时候,可以不填写泛型的类型,此时在创建具体的子类对象的时候才决定具体的类型
         *               2 子类在实现泛型接口的时候,只在实现父类接口的时候,指定父类泛型类型即可,此时,在用子类的时候,传的类型与父类的一致
         *    3 泛型方法  在定义方法的时候,指定方法的返回值和参数是自定义的占位符,可以是类名中的T,也可以是自定义的Q,只不过在使用Q的时候,需要使用<Q>,
         *               只有括起来才能识别,定义在返回值的前面
         *    4 (参数之间的继承关系,基本数据类型都是没有继承关系,自定义的类中会涉及继承关系)
         *    泛型的上限:如果父类确定了,所有的子类都可以直接使用
         *    new ArrayList(Collection<? extends E>):表示的是我这里需要的是传递collection集合,该集合的类型是E,? extends E:表示:只要是该E的子类也可以传进来
         *    5 泛型的下限:如果子类确定了,子类的所有父类都可以直接传递参数使用
         *    removeIf(Predicate<? super E>):只要是该E的父类,也可以进行参数传递
         */
        for (Object o : list) {
            Person p=(Person)o;
            System.out.println(p);
        }
    }
    @Test
    public void fanXingClassTest(){
        FanXingClass<String> fxc=new FanXingClass<>();
        fxc.setA("mashibing");
        fxc.setId(1);
        fxc.show();

        FanXingClass<Integer> fxc2=new FanXingClass<>();
        fxc2.setA(2);
        fxc2.setA(2);
        fxc2.show();

        FanXingClass<Person> fxc3=new FanXingClass<>();
        fxc3.setA(new Person("aa",123));
        fxc3.setId(123);
        fxc3.show();
        System.out.println(fxc3.get());
        fxc3.set(new Person("hehe",123));
    }
    @Test
    public void fanXingInterfaceTest(){
        FanXingInterfaceImpl fanXingInterface=new FanXingInterfaceImpl();
        fanXingInterface.getB("abc");
    }
    @Test
    public void fanXingMethod(){
        FanXingMethodClass<String> methodClass=new FanXingMethodClass();
        methodClass.setT("sss");
        methodClass.showQ(123);
        methodClass.showQ(true);
    }
}
