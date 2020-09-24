package thread;

/**
 * @Auther: ccy
 * @Date: 2020/9/15 - 20:25
 * @Description:
 * @version: 1.0
 */
public class Yield$StopTest {
    public static void main(String[] args) {
        MyRun myRun=new MyRun();
        Thread thread=new Thread(myRun);
        thread.start();
        for (int i=0;i<10;i++){
            if(i==2){
                Thread.yield();//当前正在执行的线程暂停一次,允许其他线程执行,不阻塞,线程进入就绪状态,如果没有其他等待执行的线程,这个时候当前线程就会马上恢复执行
                //thread.stop();//强迫线程停止执行
                System.out.println(Thread.currentThread().getName()+"----------"+i+"礼让一次");
            }else {
                System.out.println(Thread.currentThread().getName()+"----------"+i);
            }
        }
    }


}
