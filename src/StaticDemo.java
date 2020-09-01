/**
 * @Auther: ccy
 * @Date: 2020/8/21 - 08 - 21 - 15:22
 * @Description:静态变量使用测试类,使用static统计在类中一共产生多少个对象
 * @version: 1.0
 */
public class StaticDemo {
    static int count;//声明静态属性
    private static int cc;
    public StaticDemo(){
        count++;
        System.out.println("创建了" + count + "个对象");
    }

    public static void main(String[] args) {
        new StaticDemo();
        new StaticDemo();
        new StaticDemo();
        new StaticDemo();
        new StaticDemo();
    }
}
/*
    创建了1个对象
    创建了2个对象
    创建了3个对象
    创建了4个对象
    创建了5个对象
*/
