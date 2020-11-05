import org.junit.Test;

/**
 * @Auther: ccy
 * @Date: 2020/8/24 - 08 - 24 - 15:47
 * @Description: hashCode:31转为2进制是:11111在进行乘积运算的时候,就好比都是移位操作,因为位运算就是左位移乘以2,右位移就是除以2
 * @version: 1.0
 */
public class HashCodeDemo {

    //位移运算的举例
    @Test
    public void test1(){
        System.out.println(Integer.toBinaryString(3 ));
        System.out.println(Integer.toBinaryString(3 << 5));
        System.out.println(3 << 5);

    }
    @Test
    public void test(){
        int hash=0;
        char value[]={'a','b','c'};
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                System.out.println("val["+i+"]="+val[i]);
                h = 31 * h + val[i];//value中每一个字符与31进行相乘
                System.out.println("val["+i+"]的h="+h);
            }
            hash = h;
        }
        System.out.println(h);
        System.out.println('a' + 0);
    }

}
