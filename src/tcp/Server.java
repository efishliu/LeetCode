package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);//绑定端口号
        while (true){
            System.out.println("等待客户端进行连接......");
            Socket connect = serverSocket.accept();
            System.out.println("客户端: "+connect.getInetAddress().getHostAddress()+" 已连接.");
            //获取客户端的输入
            InputStream input = connect.getInputStream();
            int len = 0;
            byte[] buffer = new byte[1024];
            len = input.read(buffer);
            System.out.println("客户端: "+connect.getInetAddress().getHostAddress()+" 发送的数据为:");
            System.out.println(new String(buffer,0,len,"UTF-8"));

            //发送数据给客户端
            OutputStream output = connect.getOutputStream();
            String message = "hello client!\n";
            byte[] msg = message.getBytes(StandardCharsets.UTF_8);
            output.write(msg);
            System.out.println("服务器端发送的数据为：" + message);
            input.close();
            output.close();
        }

    }
}