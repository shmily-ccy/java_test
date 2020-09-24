package thread;

/**
 * @Auther: ccy
 * @Date: 2020/9/14 - 21:02
 * @Description:创建一个新的线程Thread
 * 实现多线程: 1 需要继承thread类
 *            2 必须重写run方法,指的是核心执行逻辑
 *            3  线程在启动的时候,通过start方法进行调用
 *            4 每次运行相同的代码,出来的结果可能不一样,原因在于多线程谁先抢占资源无法进行人为控制
 * @version: 1.0
 */
public class ThreadDemo2 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println(Thread.currentThread().getName()+"======"+i);
        }
    }

    /**
     * 主线程程序
     * @param args
     */
    public static void main(String[] args) {
        ThreadDemo2 threadDemo2=new ThreadDemo2();
        threadDemo2.start();
        for(int i=0;i<30;i++){
            System.out.println(Thread.currentThread().getName()+"======"+i);
        }

    }
}
