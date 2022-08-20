package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IOStream {
    public static void main(String[] args) throws IOException {
        String s  = "hello world";
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        //创建一个输出流对象
        OutputStream os = new FileOutputStream("io_test.txt");
        os.write(bytes);

        //创建一个输入流对象
        InputStream is = new FileInputStream("io_test.txt");
        byte[] b = new byte[1024];
        int len = is.read(b);
        System.out.println(new String(b, 0, len, "utf-8"));



    }
}
