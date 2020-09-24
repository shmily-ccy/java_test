package thread;

/**
 * @Auther: ccy
 * @Date: 2020/8/17 - 08 - 17 - 21:06
 * @Description: 创建使用接口逇方式, 每次只创建了一个共享对象, 所有的线程能够实现资源共享
 * 存在的问题:数据不一致的问题
 * 解决方法:线程同步
 *
 * @version: 1.0
 */
public class TicketRunnable$线程同步2 implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this){//this:表示当前对象
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + (ticket--) + "张票");
                }

            }
        }
    }

    public static void main(String[] args) {
        //使用runnable接口不需要给共享变量添加static关键字,每次创建一个对象,作为共享对象即可
        TicketRunnable$线程同步2 ticketThread = new TicketRunnable$线程同步2();//对象只有一个,所以ticket在堆内只能在一份,多个线程访问
        new Thread(ticketThread,"A").start();//四个线程随机抢占资源,这里用到了代理设计模式:看似我们是new了thred类,其实真正运行,真正干活的是runnable的run方法
        new Thread(ticketThread,"B").start();
        new Thread(ticketThread,"C").start();
        new Thread(ticketThread,"D").start();
    }

    /**
     * 输出结果:(并没有出现四个窗口交替执行的结果)
     * A正在出售第5张票
     * D正在出售第4张票
     * D正在出售第3张票
     * D正在出售第2张票
     * D正在出售第1张票
     */
}
