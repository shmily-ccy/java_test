package thread.proxy;

/**
 * @Auther: ccy
 * @Date: 2020/9/15 - 11:49
 * @Description:
 * 代理人(与被代理要实现同一个接口)
 * @version: 1.0
 */
public class WangPo implements KindWoman{
    private KindWoman kindWoman;
    //王婆的构造方法
    public WangPo(){
        this.kindWoman=new PanJinLian();
    }
    public WangPo(KindWoman kindWoman){
        this.kindWoman=kindWoman;
    }
    @Override
    public void makeEyesWithMen() {
        this.kindWoman.makeEyesWithMen();
    }

    @Override
    public void playWithMen() {
        this.kindWoman.playWithMen();
    }
}
