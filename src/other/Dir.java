package other;

import java.io.File;

public class Dir {
    public static void main(String[] args){
        File dir = new File("C:\\Users\\920848\\Desktop\\LeetCode");
        System.out.println("当前路径为：" + dir.getAbsolutePath());
        dfs(dir);
    }

    public static void dfs(File dir){
        if(dir.isDirectory()){
            System.out.println("当前是目录：" + dir.getName());
            for(File f : dir.listFiles()){
                dfs(f);
            }
        }else {
            System.out.println("当前是文件：" + dir.getName());
            System.out.println(dir.getName());
        }
    }
}
