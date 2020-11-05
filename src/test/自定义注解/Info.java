package test.自定义注解;

import java.lang.annotation.*;

/**
 * @Auther: ccy
 * @Date: 2020/11/3
 * @Description:自定义注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE})
public @interface Info {
    String value() default "tracy";
    boolean isDelete();
}
