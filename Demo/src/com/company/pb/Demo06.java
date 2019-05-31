package com.company.pb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//TCP
public class Demo06 {
    /**
     * Socket-套接字，用于描述IP地址和端口,每个需要连接internet的软件都需要打开一个Socket,并绑在一个端口上，不同的端口对应不同的服务.
     * ServerSocket用于服务端，Socket在连接成功时，应用程序两端（客户端和服务器端）都会创建一个Socket实例，操作这个实例，即可进行网络通信。
     */

}

//客户端
class SocketClient {
    public static void main(String args[]) throws Exception {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 55533;
        // 与服务端建立连接
        Socket socket = new Socket(host, port);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好  pengb";
        //首先需要计算得知消息的长度
        byte[] sendBytes = message.getBytes("UTF-8");
        //然后将消息的长度优先发送出去
        outputStream.write(sendBytes.length >>8);
        outputStream.write(sendBytes.length);
        //然后将消息再次发送出去
        outputStream.write(sendBytes);
        outputStream.flush();
        //==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
        message = "第二条消息";
        sendBytes = message.getBytes("UTF-8");
        outputStream.write(sendBytes.length >>8);
        outputStream.write(sendBytes.length);
        outputStream.write(sendBytes);
        outputStream.flush();
        //==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
        message = "the third message!";
        sendBytes = message.getBytes("UTF-8");
        outputStream.write(sendBytes.length >>8);
        outputStream.write(sendBytes.length);
        outputStream.write(sendBytes);

        outputStream.close();
        socket.close();
    }
}
//服务端
class SocketServer {
    public static void main(String[] args) throws Exception {
        // 监听指定的端口
        int port = 55533;
        ServerSocket server = new ServerSocket(port);

        // server将一直等待连接的到来
        System.out.println("server将一直等待连接的到来");
        Socket socket = server.accept();
        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes;
        // 因为可以复用Socket且能判断长度，所以可以一个Socket用到底
        while (inputStream.read() != -1){
            bytes = new byte[inputStream.read()];
            inputStream.read(bytes);
            System.out.println("get message from client: " + new String(bytes, "UTF-8"));
        }

        inputStream.close();
        socket.close();
        server.close();
    }
}
