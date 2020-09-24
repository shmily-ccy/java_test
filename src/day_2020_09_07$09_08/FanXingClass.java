package day_2020_09_07$09_08;

/**
 * @Auther: ccy
 * @Date: 2020/9/7 - 19:14
 * @Description:泛型类  A:占位的作用
 * @version: 1.0
 */
public class FanXingClass<A> {
    private int id;
    private A a;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
    public void show(){
        System.out.println("id:"+id+"===A:"+a);
    }
    public A get(){
        return a;
    }

    public void set(A a){
        System.out.println("执行set方法:"+a);
    }
}
