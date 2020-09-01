package day_2020_08_31$09_01;

/**
 * @Auther: ccy
 * @Date: 2020/9/1 - 21:10
 * @Description:
 * 所有的枚举类型隐性的继承Enum,枚举类实质上还是类,而每个被枚举的成员实质上就是一个枚举类型的实例,默认都是public static final修饰的,可以直接通过枚举类型名直接使用
 * @version: 1.0
 */
public enum EventEnum {
    L("l"),C("c");//相当于具体的对象,new EventEnum(l),所以  EventEnum enum=Event.L  就是获取到了当前的对象
    private String name;
    EventEnum(String name){
        this.name=name;
    }

}
