package codeblock;

/**
 * @Auther: ccy
 * @Date: 2021/1/19
 * @Description:
 */
public class CodeBlockTest {
    static{
        int a=0;
        test(a);
        System.out.println("静态代码块被执行了");
    }

    public CodeBlockTest(int a) {
        ++a;
        System.out.println("构造方法被执行了");
        System.out.println(a);
    }

    public static void test(int a){
        System.out.println(++a);
    }
    public static void main(String[] args) {
        CodeBlockTest demo=new CodeBlockTest(2);
    }

}
