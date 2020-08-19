package thread;

/**
 * @Auther: ccy
 * @Date: 2020/8/17 - 08 - 17 - 21:06
 * @Description:
 *
 * @version: 1.0
 */
public class TicketRunnable implements Runnable{
    private  int ticket=5;
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+"正在出售第"+(ticket--)+"张票");
            }
        }
    }
    public static void main(String[] args) {
        //使用runnable接口不需要给共享变量添加static关键字,每次创建一个对象,作为共享对象即可
        TicketRunnable ticketThread=new TicketRunnable();//对象只有一个,所以ticket在堆内只能在一份,多个线程访问
        new Thread(ticketThread).start();
        new Thread(ticketThread).start();
        new Thread(ticketThread).start();
        new Thread(ticketThread).start();
    }
}
