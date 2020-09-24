package pc4;

import java.util.concurrent.BlockingQueue;

/**
 * @Auther: ccy
 * @Date: 2020/9/24 - 15:39
 * @Description:
 * @version: 1.0
 */
public class ConsumerQueue implements Runnable{
    /**
     * BlockingQueue完成了等待和替换的过程
     */
    private BlockingQueue<Goods> blockingQueue;

    public ConsumerQueue(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            try {
                Goods goods = blockingQueue.take();
                System.out.println("消费者消费的商品是:"+goods.getBrand()+"=="+i+"=="+goods.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
