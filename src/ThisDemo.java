/**
 * @Auther: ccy
 * @Date: 2020/8/21 - 08 - 21 - 15:08
 * @Description:this测试代码
 * @version: 1.0
 */
public class ThisDemo {
    int a,b,c;//成员变量
    ThisDemo(){
        System.out.println("正要new一个hello对象");
    }
    ThisDemo(int a,int b){
        this();//this相当于对象的一个引用,所以这里就是表示调用无参构造方法,必须放在第一位
        this.a=a;
        this.b=b;
    }
    ThisDemo(int a,int b,int c){
        this(a,b);//调用其他的构造方法
        this.c=c;
        int d = 2;//局部变量必须初始化
        this.c=c+d;
    }
    void sing(){};
    void chifan(){
        this.sing();
        System.out.println("你妈妈喊你回家吃饭了");
    }

    public static void main(String[] args) {
        ThisDemo td=new ThisDemo(2,3);
        System.out.println(td.toString());
        td.chifan();
    }

    @Override
    public String toString() {
        return "ThisDemo{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
/*正要new一个hello对象
ThisDemo{a=2, b=3, c=0}
你妈妈喊你回家吃饭了*/
