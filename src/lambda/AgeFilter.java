package lambda;

/**
 * @Auther: ccy
 * @Date: 2020/8/27 - 08 - 27 - 19:32
 * @Description:
 * @version: 1.0
 */
public class AgeFilter implements StudentFilter{
    @Override
    public boolean compare(Student student) {
        return student.getAge()>14;
    }
}
