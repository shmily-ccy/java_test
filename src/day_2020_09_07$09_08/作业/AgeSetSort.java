package day_2020_09_07$09_08.作业;

import java.util.Comparator;

/**
 * @Auther: ccy
 * @Date: 2020/9/7 - 20:48
 * @Description:
 * @version: 1.0
 */
public class AgeSetSort implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.getAge()>o2.getAge()){
            return 1;
        }else if(o1.getAge()<o2.getAge()){
            return -1;
        }
        return 0;
    }
}
