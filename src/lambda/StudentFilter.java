package lambda;

/**
 * @Auther: ccy
 * @Date: 2020/8/27 - 08 - 27 - 19:31
 * @Description:注解是标识当前接口是否是函数式接口
 * @version: 1.0
 */
@FunctionalInterface
public interface StudentFilter {
    boolean compare(Student student);
}
