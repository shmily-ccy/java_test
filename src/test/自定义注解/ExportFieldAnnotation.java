package test.自定义注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: ccy
 * @Date: 2020/11/3
 * @Description:文件导出注解,文件导出时,只导出带注解的字段
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExportFieldAnnotation {
    public String title();//导出excel的列明
    public int column();//列号


}
