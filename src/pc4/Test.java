package pc4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Auther: ccy
 * @Date: 2020/9/24 - 15:42
 * @Description:
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        BlockingQueue blockingQueue=new ArrayBlockingQueue(5);//表示一开始就可以放5个生产者到我的队列中
        ProducerQueue producerQueue=new ProducerQueue(blockingQueue);
        ConsumerQueue consumerQueue=new ConsumerQueue(blockingQueue);
        new Thread(producerQueue).start();
        new Thread(consumerQueue).start();
    }
}
