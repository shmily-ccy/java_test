package pc3;

/**
 * @Auther: ccy
 * @Date: 2020/9/24 - 13:57
 * @Description:
 * 多线程访问的时候出现了数据安全的问题
 * 1 生产者没有生产商品,消费者就可以获取
 * 2 商品的品牌和名称对应不上
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Goods goods=new Goods();
        Producer producer=new Producer(goods);
        Consumer consumer=new Consumer(goods);

        Thread t1=new Thread(producer);
        Thread t2=new Thread(consumer);
        t1.start();
        t2.start();
    }
}
/**
 * 生产者生产了娃哈哈====矿泉水
 * 消费者取走了娃哈哈-------矿泉水
 * 生产者生产了旺仔====小馒头
 * 消费者取走了旺仔-------小馒头
 * 生产者生产了娃哈哈====矿泉水
 * 消费者取走了娃哈哈-------矿泉水
 * 生产者生产了旺仔====小馒头
 * 消费者取走了旺仔-------小馒头
 * 生产者生产了娃哈哈====矿泉水
 * 消费者取走了娃哈哈-------矿泉水
 */
