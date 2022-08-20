package qiuzhao.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        while(reader.hasNext()){
            //读取数据
            int n = reader.nextInt();
            int t = reader.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = reader.nextInt();
            }
            //递增排序
            Arrays.sort(arr);
            int total = 0;
            int ans = 0;
            for(int i = 1; i <= n; i++){
                if(total + t > arr[i - 1]){
                    //超时，使用魔法
                    ans++;
                    continue;
                }else{
                    //未超时，直接配送
                    total += t;
                }
            }
            System.out.println(ans);
        }
    }
}
