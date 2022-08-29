package qiuzhao.xiaohongshu;

import java.util.*;

public class Main2 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()) {
            int n = reader.nextInt();
            long K = reader.nextLong();
            long[] arr = new long[n];
            for(int i = 0; i < n; i++){
                arr[i] = reader.nextLong();
            }

            int ans = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i == j){
                        continue;
                    }
                    long res = arr[i] * arr[j];
                    if(res >= K){
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
