package test.自定义注解;

import com.sun.deploy.util.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ccy
 * @Date: 2020/11/3
 * @Description:导出文件
 */
public class ExportDemo {
    public static void main(String[] args) {
        List<Person> personList=new ArrayList<>();
        Person person=new Person("小华",10);
        Person person2=new Person("小明",15);
        personList.add(person);
        personList.add(person2);
        List<String> annotationList=new ArrayList<>();
        List<String> names=new ArrayList<>();
        List<Integer> ages=new ArrayList<>();
        for (int i = 0; i < personList.size(); i++) {
            Field[] fields = personList.get(i).getClass().getDeclaredFields();
            names.add(personList.get(i).getName());
            ages.add(personList.get(i).getAge());
            for (Field field : fields) {
                Annotation[] annotations = field.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if(annotation instanceof ExportFieldAnnotation){
                        annotationList.add(((ExportFieldAnnotation) annotation).title());
                    }
                }
            }
        }
        System.out.println(StringUtils.join(annotationList,","));
        System.out.println(StringUtils.join(names,","));
        System.out.println(ages);
    }
}
