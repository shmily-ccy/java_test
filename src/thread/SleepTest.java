package thread;

import java.sql.SQLOutput;

/**
 * @Auther: ccy
 * @Date: 2020/9/15 - 19:28
 * @Description:
 * @version: 1.0
 */
public class SleepTest {
    public static void main(String[] args) {
        //myrun中有子线程的方法体
        MyRun myRun=new MyRun();
        Thread thread=new Thread(myRun);
        thread.start();
        //主线程的方法体
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"-----"+i);
            if(i==2){
                try {
                    thread.sleep(1000);//使用该方法的线程休眠,线程进入阻塞状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
