package thread;

/**
 * @Auther: ccy
 * @Date: 2020/8/17 - 08 - 17 - 20:45
 * @Description: 实现runnable接口,重写run方法,通过thread.start启动
 * 使用了代理设计模式,因为runnable接口中没有start方法,thread类中有该方法
 * 推荐使用这种方法:因为java是单继承多实现,将继承关系留给需要的类
 * @version: 1.0
 */
public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        //具体执行的代码逻辑
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"--------"+i);
        }
    }


    public static void main(String[] args) {
        RunnableDemo runnableDemo=new RunnableDemo();
        Thread thread=new Thread(runnableDemo);
        //先启动线程,让两个线程并行走,然后再执行该线程需要执行的功能
        thread.start();
        for (int i = 0; i <5 ; i++) {
            System.out.println(Thread.currentThread().getName()+"=============="+i);
        }
    }
}
