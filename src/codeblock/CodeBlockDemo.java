package codeblock;

/**
 * @Auther: ccy
 * @Date: 2020/8/20 - 08 - 20 - 21:09
 * @Description:代码块
 * 分类:普通代码块:定义在方法中的,用{}括起来的
 *     构造代码块:定义在类中使用{}括起来的代码 (注意:每次代码运行的时候,会将构造代码块中的代码添加到构造方法的前面,构造代码块中的代码会添加到每一个构造方法中)
 *     静态代码块
 *
 * @version: 1.0
 */
public class CodeBlockDemo {

    int a;
    int b;

    static{
        System.out.println("静态代码块");
    }
    public CodeBlockDemo(int a,int b){
        this(a);//this表示的是当前对象,这里就是调用传参为a的构造方法,当使用this()调了构造方法的时候,这里就不会再有构造代码块了
        this.b=b;
    }

    public CodeBlockDemo(int a){
        this.a=a;
    }

    public CodeBlockDemo() {
        System.out.println("构造方法");//运行后,我们会发现,构造代码块先运行,构造方法后运行
    }

    {
        System.out.println("构造代码块");//该class文件文件经过反编译后,会发现构造代码块的与构造方法一样,在编译的时候,会加构造方法一样的结构
    }

    public  void test() {
        System.out.println("test");
        {
            System.out.println("我应该叫什么分类");
        }
    }

    public static void main(String[] args) {
        CodeBlockDemo codeBlockDemo=new CodeBlockDemo();
        codeBlockDemo.test();
        {
            System.out.println("main");
        }
    }
    /*构造代码块
    构造方法
    test
    我应该叫什么分类
    main*/

    //反编译后
    /**
     * package codeblock;
     *
     * import java.io.PrintStream;
     *
     * public class CodeBlockDemo
     * {
     *   int a;
     *   int b;
     *
     *   public CodeBlockDemo(int a, int b)
     *   {
     *     this(a);
     *     this.b = b;
     *   }
     *
     *   public CodeBlockDemo(int a)
     *   {
     *     System.out.println("构造代码块");this.a = a;
     *   }
     *
     *   public CodeBlockDemo()
     *   {
     *     System.out.println("构造代码块");
     *     System.out.println("构造方法");
     *   }
     *
     *   public void test()
     *   {
     *     System.out.println("test");
     *
     *     System.out.println("我应该叫什么分类");
     *   }
     *
     *   public static void main(String[] args)
     *   {
     *     CodeBlockDemo codeBlockDemo = new CodeBlockDemo();
     *     codeBlockDemo.test();
     *
     *     System.out.println("main");
     *   }
     * }
     */
}
