package io;

import java.io.File;

public class Dir {
    public static void main(String[] args){
        //创建目录
        File file = new File("C:\\Users\\92084\\Desktop\\LeetCode\\src\\io\\dir_test");
        file.mkdirs();
        //读取目录
        if(file.isDirectory()){
            String[] s = file.list();
            for(String t : s){
                System.out.println(t);
            }
        }
        //删除文件
        File f = new File("C:\\Users\\92084\\Desktop\\LeetCode\\src\\io\\dir_test\\1.txt");
        f.delete();
    }
}
