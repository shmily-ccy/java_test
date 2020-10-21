package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.util.Scanner;

/**
 * @Auther: ccy
 * @Date: 2020/10/20
 * @Description:登录客户端
 */
public class LoginClient {
    private DataInputStream dataInputStream;

    public static void main(String[] args) throws Exception {
        Socket client = new Socket("localhost", 12000);
        OutputStream outputStream = client.getOutputStream();
        //需要完成登录功能,需要传输一个user对象
        User user = getUser();
        //传输对象,需要使用objectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(user);
        //调用shutdown方法,告诉对方传输完成
        client.shutdownOutput();
        //接收服务器的响应
        DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
        String s = dataInputStream.readUTF();
        System.out.println(s);
        //关闭流操作
        dataInputStream.close();
        objectOutputStream.close();
        outputStream.close();

        client.close();
    }

    private static User getUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String userName = scanner.nextLine();
        System.out.println("请输入密码:");
        String password = scanner.nextLine();
        return new User(userName, password);
    }
}
