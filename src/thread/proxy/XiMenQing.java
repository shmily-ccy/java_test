package thread.proxy;

/**
 * @Auther: ccy
 * @Date: 2020/9/15 - 11:54
 * @Description:
 * @version: 1.0
 */
public class XiMenQing {
    public static void main(String[] args) {
        WangPo wangPo=new WangPo();
        wangPo.makeEyesWithMen();
        wangPo.playWithMen();

        WangPo wangPo1=new WangPo(new JiaShi());
        wangPo1.makeEyesWithMen();
        wangPo1.playWithMen();

    }
}
