package thread;

/**
 * @Auther: ccy
 * @Date: 2020/9/15 - 19:08
 * @Description:
 * @version: 1.0
 */
public class MyRun implements Runnable{
    @Override
    public void run() {
        for( int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"---------"+i);
        }
    }
}
