package thread;

/**
 * @Auther: ccy
 * @Date: 2020/8/17 - 08 - 17 - 20:52
 * @Description: 模拟卖票
 * @version: 1.0
 */
public class TicketThread extends Thread{
    private static int ticket=5;//一共有5张票

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+"正在出售第"+(ticket--)+"张票");
            }
        }

    }

    /**
     * 数据同步问题
     * @param args
     */
    public static void main(String[] args) {
        TicketThread ticketThread=new TicketThread();
        TicketThread ticketThread2=new TicketThread();
        TicketThread ticketThread3=new TicketThread();
        TicketThread ticketThread4=new TicketThread();
        ticketThread.start();
        ticketThread2.start();
        ticketThread3.start();
        ticketThread4.start();
    }
}
