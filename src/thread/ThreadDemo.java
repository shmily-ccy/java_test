package thread;

/**
 * @Auther: ccy
 * @Date: 2020/8/17 - 08 - 17 - 20:13
 * @Description:
 * 实现多线程的时候,必须要继承Thread类,必须要重写run方法,实现核心逻辑,启动线程的时候,必须通过start方法进行调用
 * 每次运行相同的代码,出来的结果可能不一样,原因在于多线程谁先抢占资源无法进行人为控制
 * 程序线程和电脑线程的区别:电脑4核8线程:超线程技术,一个cpu只能做一个事情,通过超线程技术(硬件)模拟出来的能同时执行多个线程:让一个cpu同时执行两个线程,所以是4核8线程
 * 程序最终还是要在cpu内运行的,4个cpu意味着同时只能有4个程序在并行执行.发明超线程的实现,让一个cpu做两件事情,与程序的多线程没有关系,程序的执行最终还是靠cpu执行的(cpu核数越高,程序代码运行越快)
 * @version: 1.0
 *
 */
public class ThreadDemo extends Thread{
    @Override
    public void run() {
        //具体执行的代码逻辑
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"--------"+i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo=new ThreadDemo();
        threadDemo.start();
        for (int i = 0; i <5 ; i++) {
            System.out.println(Thread.currentThread().getName()+"=============="+i);
        }
    }
}
