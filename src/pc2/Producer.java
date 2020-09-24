package pc2;

/**
 * @Auther: ccy
 * @Date: 2020/9/22 - 11:23
 * @Description:生产者生产产品,将产品放置在共享对象(共享空间)中
 * @version: 1.0
 */
public class Producer implements Runnable{
    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            if(i%2==0){
                goods.set("娃哈哈","矿泉水");
            }else {
               goods.set("旺仔","小馒头");
            }

        }
    }
}
