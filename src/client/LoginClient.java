package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownServiceException;

/**
 * @Auther: ccy
 * @Date: 2020/10/20
 * @Description:登录客户端
 */
public class LoginClient {
    public static void main(String[] args) throws Exception {
        Socket client=new Socket("localhost",10000);
        OutputStream outputStream = client.getOutputStream();
        //需要完成登录功能,需要传输一个user对象
        User user=new User("msd","msd");
        //传输对象,需要使用objectOutputStream
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(user);
        //调用shutdown方法,告诉对象传输完成
        client.shutdownOutput();

    }
}
