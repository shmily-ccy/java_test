package server;

import client.User;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: ccy
 * @Date: 2020/10/21
 * @Description:使用多线程的方式,使服务端在每次访问完之后不再自动停止
 */
public class LoginServer3 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket=new ServerSocket(12000);
        while (true){
            //接受服务端的套接字
            Socket server=serverSocket.accept();
            //获取输入流对象
            InputStream inputStream = server.getInputStream();
            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
            //读取到了对象
            User user=(User) objectInputStream.readObject();
            String str="";
            if("msd".equals(user.getUserName()) && "msd".equals(user.getPassWord())){
                System.out.println("欢迎你:"+user.getUserName());
                str="登录成功";
            }else {
                str="登录失败";
            }
            //给出了相关信息后,输入已经完成,截断输入流
            server.shutdownInput();
            //给客户端响应
            DataOutputStream outputStream=new DataOutputStream(server.getOutputStream());
            outputStream.writeUTF(str);
            server.shutdownOutput();

            outputStream.close();
            objectInputStream.close();
            inputStream.close();
        }
       // serverSocket.close();
    }
}
