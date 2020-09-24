package thread;

/**
 * @Auther: ccy
 * @Date: 2020/9/15 - 15:32
 * @Description:
 * 介绍线程类的api方法
 * @version: 1.0
 */
public class ThreadApiDemo implements Runnable{
    //主函数也是一个线程
    public static void main(String[] args) {
        //获取当前线程的对象
        Thread thread = Thread.currentThread();
        //获取当前线程的名称 main
        System.out.println(thread.getName());
        //获取线程的id 1
        System.out.println(thread.getId());
        //获取线程的优先级 5(在一般系统中范围是0-10的值,如果没有经过设置的话,就是默认值5,有些系统是0-100)
        System.out.println(thread.getPriority());
        //设置线程池的优先级 10
        /**
         * 优先级越高,一定越先执行吗?不一定,只是执行的概率比较大而已
         */
        /**
         * 注:在主线程内的子线程,主线程设置的优先级会影响子线程设置的优先级
         */
        thread.setPriority(6);
        System.out.println(thread.isAlive());
        System.out.println("主线程:"+thread.getPriority());
        ThreadApiDemo threadApiDemo=new ThreadApiDemo();
        Thread thread1 = new Thread(threadApiDemo);
        thread1.start();
        System.out.println(thread1.isAlive());
        System.out.println("非主线程:"+thread1.getPriority());
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+"------"+i);
        }
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"------"+i);
        }
    }
}
