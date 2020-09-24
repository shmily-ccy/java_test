package thread.proxy;

/**
 * @Auther: ccy
 * @Date: 2020/9/15 - 11:52
 * @Description:
 * 被代理人
 * @version: 1.0
 */
public class PanJinLian implements KindWoman {
    @Override
    public void makeEyesWithMen() {
        System.out.println("潘金莲在抛媚眼");
    }

    @Override
    public void playWithMen() {
        System.out.println("潘金莲......");
    }
}
