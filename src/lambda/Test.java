package lambda;

import java.util.ArrayList;

/**
 * @Auther: ccy
 * @Date: 2020/8/27 - 08 - 27 - 19:29
 * @Description:
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("zhangsan",14,67));
        list.add(new Student("lisi",13,89));
        list.add(new Student("wangwu",15,97));
        list.add(new Student("maliu",12,63));
        list.add(new Student("zhaoqi",17,75));
        //查找年龄大于14的学生
        findByAge(list);
        //查找分数大于75的学生
        findByScore(list);

        //代码重构一
        getByFilter(list,new AgeFilter());
        getByFilter(list,new ScoreFilter());

        //代码重构二,匿名内部类,不需要再创建对应的类了
        getByFilter(list, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getAge()>14;
            }
        });
        getByFilter(list, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getScore()>75;
            }
        });

        //代码重构三,将匿名内部类进行改版
        getByFilter(list,(e)->e.getAge()>14);
        getByFilter(list,(e)->e.getScore()>75);
    }

    /**
     * 其下面的方法是重复的,可以复用的
     * @param students
     */
    public static void findByAge(ArrayList<Student> students){
        ArrayList<Student> list =new ArrayList<>();
        for(Student stu:students){
            if(stu.getAge()>14){
                list.add(stu);
            }
        }
        for(Student student :list){
            System.out.println(student);
        }
    }
    public static void findByScore(ArrayList<Student> students){
        ArrayList<Student> list =new ArrayList<>();
        for(Student stu:students){
            if(stu.getScore()>75){
                list.add(stu);
            }
        }
        for(Student student :list){
            System.out.println(student);
        }
    }

    /**
     * 以下是代码重构的(一)
     */
    public static void getByFilter(ArrayList<Student> students,StudentFilter filter){
        ArrayList<Student> list=new ArrayList<>();
        for (Student student:students){
            if(filter.compare(student)){
                list.add(student);
            }
        }
        for (Student student : list) {
            System.out.println(student);
        }
    }

}
