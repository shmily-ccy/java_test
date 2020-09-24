package thread;

/**
 * @Auther: ccy
 * @Date: 2020/9/14 - 21:22
 * @Description:第二种方法创建多线程(使用了代理设计模式)
 * 1 实现runnable接口
 * 2 重写run方法
 * 3 创建thread对象,将刚刚创建好的runnable的子类实现,作为thread类的构造参数
 * 4 通过thread.start()进行启动
 *
 * 推荐使用第二种方式,原因是java是单继承多实现的
 * @version: 1.0
 */
public class RunnableDemo2 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println(Thread.currentThread().getName()+"======"+i);
        }
    }

    public static void main(String[] args) {

        RunnableDemo2 runnableDemo2=new RunnableDemo2();
        Thread thread=new Thread(runnableDemo2);
        thread.start();
        for(int i=0;i<30;i++){
            System.out.println(Thread.currentThread().getName()+"======"+i);
        }
    }
}
