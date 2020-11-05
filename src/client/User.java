package client;

import java.io.Serializable;

/**
 * @Auther: ccy
 * @Date: 2020/10/20
 * @Description:因为要将对象进行网络传输,所以需要序列化
 */
public class User implements Serializable {
    private static final long serialVersionUID = -2723799252788240971L;
    private String  userName;
    private String passWord;
    private Integer age;

    public User() {
    }

    public User(Integer age) {
        this.age = age;
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPassWord(String passWord) {

        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", age=" + age +
                '}';
    }
}
