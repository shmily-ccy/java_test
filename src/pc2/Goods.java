package pc2;

/**
 * @Auther: ccy
 * @Date: 2020/9/22 - 11:26
 * @Description:产品
 * @version: 1.0
 */
public class Goods {
    private String brand;//品牌
    private String name;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //使用同步方法进行多线程的同步控制:解决了生产者品牌和名称对应不上的问题
    /**
     * 消费者获取商品
     */
    public synchronized  void get(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者取走了"+this.getBrand()+"-------"+this.getName());
    }

    /**
     * 生产者生产商品
     */
    public synchronized void set(String brand,String name){
        this.setBrand(brand);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        System.out.println("生产者生产了"+this.getBrand()+"===="+this.getName());
    }

}
