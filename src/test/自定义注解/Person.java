package test.自定义注解;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.junit.experimental.theories.DataPoint;

/**
 * @Auther: ccy
 * @Date: 2020/11/3
 * @Description:导出的类
 */

public class Person {
    @ExportFieldAnnotation(title = "姓名",column = 1)
    private String name;
    @ExportFieldAnnotation(title = "年龄",column = 2)
    private int age;
    @Info(isDelete = true)
    private Boolean isDelete;//是否有效

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
