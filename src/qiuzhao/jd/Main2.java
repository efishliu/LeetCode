package qiuzhao.jd;
/*
    力扣2170题
    链接：https://leetcode.cn/problems/minimum-operations-to-make-the-array-alternating
 */
import java.util.*;
public class Main2 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        while(reader.hasNext()) {
            int n = reader.nextInt();
            int[] arr  = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = reader.nextInt();
            }
            if(n == 1){
                System.out.println(0);
                continue;
            }
            if(n == 2){
                if(arr[0] == arr[1]){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
                continue;
            }
            if(n == 3){
                if(arr[0] == arr[1] && arr[1] == arr[2]){
                    System.out.println(1);
                }else if(arr[0] == arr[1]){
                    System.out.println(1);
                }else if(arr[2] == arr[1]){
                    System.out.println(1);
                }else if(arr[0] == arr[2]){
                    System.out.println(0);
                }else{
                    System.out.println(1);
                }
                continue;
            }
            int ans = 0;
            for(int i = 1; i < n; i++){
                if(arr[i] == arr[i - 1] || (i >= 2 && arr[i] != arr[i - 2])){
                    ans++;
                    if(i - 2 < 0){
                        arr[i] = arr[n - i];
                    }else {
                        arr[i] = arr[(i - 2) % n];
                    }
                }
            }
            int ans2 = 0;
            for(int i = n - 2; i >= 0; i--){
                if(arr[i] == arr[i + 1] || (i + 2 < n && arr[i] != arr[i + 2])){
                    ans2++;
                    if(i + 2 == n){
                        arr[i] = arr[0];
                    }else {
                        arr[i] = arr[(i + 2) % n];
                    }
                }
            }
            ans = Math.max(ans, ans2);
            System.out.println(ans);
        }
    }
}
