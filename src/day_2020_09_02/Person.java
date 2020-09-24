package day_2020_09_02;

import java.io.Serializable;
import java.net.ServerSocket;
import java.util.Objects;

/**
 * @Auther: ccy
 * @Date: 2020/9/3 - 21:02
 * @Description:
 *
 * @version: 1.0
 */
public class Person implements Comparable, Serializable {
    private static final long serialVersionUID = -5399588620141502319L;
    private String name;
    private  int age;
    transient  private String pwd;

    public Person(String name, int age, String pwd) {
        this.name = name;
        this.age = age;
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Person(){};
    public Person(String name,int age){
        this.name=name;
        this.age=age;
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

    /**
     * 此比较器按照name的长度来进行比较
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        Person p=(Person)o;
        if(p.name.length()>this.name.length()){
            return 1;
        }else if(p.name.length()<this.name.length()){
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
