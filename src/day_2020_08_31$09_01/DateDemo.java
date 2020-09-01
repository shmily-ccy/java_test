package day_2020_08_31$09_01;

import org.junit.Test;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: ccy
 * @Date: 2020/9/1 - 20:02
 * @Description:
 * @version: 1.0
 */
public class DateDemo {
    @Test
    public void test01() throws Exception {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getYear());//输出119:按照1900年基准计算
        //Calendar:日历类操作时间:格林日志的日期类
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(new Date()));
        Date parse = dateFormat.parse("2020-10-10");
        System.out.println();
        //获取的是当前系统的时间
        Calendar calendar=Calendar.getInstance();//其构造方法是protected修饰的,只能是本包或者是子类使用
        System.out.println(calendar);
        //设置指定时间的日历类
        calendar.setTime(parse);
        System.out.println(calendar);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONDAY));//从0开始计算的
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

    }
}
