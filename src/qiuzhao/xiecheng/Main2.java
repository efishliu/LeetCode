package qiuzhao.xiecheng;

import java.util.*;

public class Main2 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int t = reader.nextInt();
        for(int k = 0; k < t; k++){
            int[][] a = new int[2][2];
            int[][] b = new int[2][2];
            a[0][0] = reader.nextInt();
            a[0][1] = reader.nextInt();
            a[1][0] = reader.nextInt();
            a[1][1] = reader.nextInt();
            b[0][0] = reader.nextInt();
            b[0][1] = reader.nextInt();
            b[1][0] = reader.nextInt();
            b[1][1] = reader.nextInt();


            int ans = bfs(a, b);
            System.out.println(ans);
        }
    }
    public static int bfs(int[][] a, int[][] b){
        if(tostr(a).equals(tostr(b))){
            return 0;
        }
        int ans = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(tostr(a));
        set.add(tostr(a));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String at = queue.poll();

                if(at.equals(tostr(b))){
                    return ans;
                }else{
                    //开始转换
                    String s1 = transfer(at, 0,1);
                    if(!set.contains(s1)){
                        queue.offer(s1);
                        set.add(s1);
                    }

                    String s2 = transfer(at, 0,2);
                    if(!set.contains(s2)){
                        queue.offer(s2);
                        set.add(s2);
                    }

                    String s3 = transfer(at, 1,3);
                    if(!set.contains(s3)){
                        queue.offer(s3);
                        set.add(s3);
                    }

                    String s4 = transfer(at, 2,3);
                    if(!set.contains(s4)){
                        queue.offer(s4);
                        set.add(s4);
                    }

                }
            }
            ans++;
        }
        return -1;
    }

    public static String tostr(int[][] a){
        String s = "";
        s += a[0][0];
        s += a[0][1];
        s += a[1][0];
        s += a[1][1];
        return s;
    }

    public static String transfer(String a, int i, int j){
        char[] strs = a.toCharArray();
        char c = strs[i];
        strs[i] = strs[j];
        strs[j] = c;
        return "" + strs[0] + strs[1] + strs[2] + strs[3];
    }
}
