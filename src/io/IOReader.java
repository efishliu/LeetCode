package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOReader {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\92084\\Desktop\\LeetCode\\src\\io\\dir_test\\hello.txt";
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write("hello world!");
        fileWriter.write("你好，工具人！");
        fileWriter.flush();

        FileReader fileReader = new FileReader(filePath);
        char[] readBuffer = new char[1024];
        fileReader.read(readBuffer);
        for(char c : readBuffer){
            System.out.print(c);
        }
    }
}
