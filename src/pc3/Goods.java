package pc3;

/**
 * @Auther: ccy
 * @Date: 2020/9/22 - 11:26
 * @Description:产品
 * @version: 1.0
 */
public class Goods {
    private String brand;//品牌
    private String name;
    private Boolean flag = false;//默认不存在商品,如果值为true,代表有商品,可以解决生产了就消费,没有生产就不消费

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
    public synchronized void get() {
        /**
         * 如果flag等于false的话,意味着生产者没有生产商品,此时消费者无法消费,需要让消费者进入到阻塞状态,等待生产者生产,当有
         * 商品之后,再开始消费
         */
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者取走了" + this.getBrand() + "-------" + this.getName());
        flag=false;
        //唤醒生产者去进行生产
        notify();
    }

    /**
     * 生产者生产商品
     */
    public synchronized void set(String brand, String name) {
        //当生产者抢占到cpu资源后会判断当前对象是否有值,如果有的话,以为消费者还没有消费,同时当前
        //线程进入阻塞状态,等待消费者取走商品之后,再次生产,如果没有的话,不需要进入阻塞状态,直接生产即可
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setBrand(brand);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        System.out.println("生产者生产了" + this.getBrand() + "====" + this.getName());
        //如果代码执行到此处,以为着生成完成,需要将flag设置成true
        flag=true;
        //唤醒消费者去进行消费
        notify();
    }

}
