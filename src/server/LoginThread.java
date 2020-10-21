package server;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @Auther: ccy
 * @Date: 2020/10/21
 * @Description:
 */
public class LoginThread implements Runnable{
    //每次一个新的客户端连接进来后,都会开启一个socket
    private Socket socket;

    public LoginThread(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        //ObjectInputStream
    }
}
