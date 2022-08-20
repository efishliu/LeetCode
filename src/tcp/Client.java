package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        while(true){
            Socket socket = new Socket("127.0.0.1",9999);
            Scanner scanner = new Scanner(System.in);
            //获得输出流
            OutputStream output = socket.getOutputStream();
            System.out.println("请输入发送的消息：");
            String sendMsg = scanner.nextLine();
            byte[] buffer = sendMsg.getBytes(StandardCharsets.UTF_8);
            output.write(buffer);
            System.out.println("客户端发送的消息为：" + sendMsg);

            //接收服务器端的消息
            InputStream input = socket.getInputStream();
            int len = 0;
            byte[] buf = new byte[1024];
            len = input.read(buf);
            System.out.println("服务器端发送的内容是：" + new String(buf,0,len,"UTF-8"));
        }
    }
}