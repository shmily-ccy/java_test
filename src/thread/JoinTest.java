package thread;

/**
 * @Auther: ccy
 * @Date: 2020/9/15 - 19:09
 * @Description:
 * @version: 1.0
 */
public class JoinTest {
    public static void main(String[] args) {
        MyRun myRun=new MyRun();
        Thread thread=new Thread(myRun);
        thread.start();
        //写for循环时为了能看到不同进程交替执行的效果
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"-------------"+i);
            if(i==3){
                try {
                    //调用该方法的线程强制执行,其他线程处于阻塞状态,该线程执行完毕后,其他线程再执行(所以在控制台,当main线程打印到3的时候,停止执行,执行threa线程,然后再继续执行main线程)
                    thread.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
