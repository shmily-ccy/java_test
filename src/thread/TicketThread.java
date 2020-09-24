package thread;

/**
 * @Auther: ccy
 * @Date: 2020/8/17 - 08 - 17 - 20:52
 * @Description: 模拟卖票
 * 因为要多线程实现,所以继承thread
 * 出现的问题:
 *          1.每次在启动线程对象的时候,都会创建自己对象的属性值,相当于每个线程操作自己,没有真正意义上实现共享
 *            解决方法:将共享对象,共享变量设置成static
 *          2.每次访问共享对象的时候,数据不一致了
 *            解决方法:使用线程同步
 * @version: 1.0
 */
public class TicketThread extends Thread {
    private static int ticket=5;//总共只有5个票

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+"正在出售第"+(ticket--)+"张票");
            }
        }

    }

    public static void main(String[] args) {
        TicketThread thread=new TicketThread();
        TicketThread thread2=new TicketThread();
        TicketThread thread3=new TicketThread();
        TicketThread thread4=new TicketThread();
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
