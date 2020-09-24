package thread;

import java.sql.SQLOutput;

/**
 * @Auther: ccy
 * @Date: 2020/9/16 - 10:22
 * @Description:经典案例
 * 非主线程与主线程交替执行
 * @version: 1.0
 */
public class Test1 implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"======"+i);
            try {
                Thread.sleep(1001);//睡眠一秒钟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Test1 test1=new Test1();
        Thread thread=new Thread(test1);
        thread.start();
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"======"+i);
            try {
                Thread.sleep(1000);//两个交替的线程睡眠时间要有时间差,如果睡眠时间都是1毫秒,那样的话,两个会同时抢占资源,很有可能输出多次都是同一个线程抢占到资源,所以,有时间差,就会出现挨个轮循的结果
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
