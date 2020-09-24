package pc4;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * @Auther: ccy
 * @Date: 2020/9/24 - 15:35
 * @Description:
 * @version: 1.0
 */
public class ProducerQueue implements Runnable{
    private BlockingQueue<Goods> blockingQueue;//代替我们之前写的goods的资源

    public ProducerQueue(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    //生产者生产数据,往队列中放入数据
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            Goods goods=null;
            if(i%2==0){
                goods=new Goods("娃哈哈","矿泉水");
            }else {
                goods=new Goods("旺仔","小馒头");
            }
            System.out.println("生产者开始生产商品:"+goods.getBrand()+"--"+i+"--"+goods.getName());
            try {
                blockingQueue.put(goods);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
