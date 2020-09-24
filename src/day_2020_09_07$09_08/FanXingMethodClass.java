package day_2020_09_07$09_08;

/**
 * @Auther: ccy
 * @Date: 2020/9/7 - 20:05
 * @Description:
 * @version: 1.0
 */
public class FanXingMethodClass<T> {
    private T t;

    public <Q> void showQ(Q q){
        System.out.println(q);
        System.out.println(t);
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

