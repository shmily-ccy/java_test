package pc2;

/**
 * @Auther: ccy
 * @Date: 2020/9/22 - 11:24
 * @Description:从共享空间(内存缓冲区:list,map)中取走产品
 * @version: 1.0
 */
public class Consumer implements Runnable{
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            goods.get();
        }
    }
}
