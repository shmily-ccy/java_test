package day_2020_08_31$09_01;

import org.junit.Test;

/**
 * @Auther: ccy
 * @Date: 2020/9/1 - 19:29
 * @Description:可变字符串
 * stringbuffer是容器,在初始化(构造方法)的时候是16的值,2的n次方
 * value = new char[capacity]:字符数组,比如说传的是true,4个字符占得就是4个长度
 *
 * StringBuffer:线程安全,效率低
 * StringBuilder:线程不安全,效率高
 *
 * @version: 1.0
 */
public class StringBufferDemo {
    @Test
    public void test01(){
        StringBuffer sb=new StringBuffer();
        sb.append(1).append("abc").append(true).append(2).append(3).append(4).append(5).append(6).append(7).append(8).append(9).append(10).append(11).append(12).append(13);
        System.out.println(sb);
        System.out.println(sb.length());//8:整体占用的实际长度
        System.out.println(sb.capacity());//16:初始化的长度
    }


}
