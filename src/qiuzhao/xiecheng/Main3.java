package qiuzhao.xiecheng;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int t = Integer.parseInt(reader.nextLine());
        for(int k = 0; k < t; k++) {
            int n = Integer.parseInt(reader.nextLine());
            int[] arr = new int[n];
            char[] color = new char[n];
            String[] arrStr = reader.nextLine().split(" ");
            String colorStr = reader.nextLine();
            for(int i = 0; i < n; i++){
                arr[i] = Integer.valueOf(arrStr[i]);
                color[i] = colorStr.charAt(i);
            }
            int[] ans = new int[]{Integer.MAX_VALUE};
            dfs(arr, color, 0, ans, n);
            System.out.println(ans[0]);
        }
    }
    public  static void dfs(int[] arr, char[] color, int layer, int[] ans, int n){
        if(layer == 10){
            return;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //所有红色加一
        int[] arr1 = Arrays.copyOf(arr, n);
        for(int i = 0; i < n; i++){
            if(color[i] == 'R'){
                arr1[i]++;
            }
            max = max < arr1[i] ? arr1[i] : max;
            min = min > arr1[i] ? arr1[i] : min;
        }
        if(max - min < ans[0]){
            ans[0] = max - min;
        }
        dfs(arr1, color, layer + 1, ans, n);

        //所有绿色-1
        int[] arr2 = Arrays.copyOf(arr, n);
        for(int i = 0; i < n; i++){
            if(color[i] == 'B'){
                arr2[i]--;
            }
            max = max < arr2[i] ? arr2[i] : max;
            min = min > arr2[i] ? arr2[i] : min;
        }
        if(max - min < ans[0]){
            ans[0] = max - min;
        }
        dfs(arr2, color, layer + 1, ans, n);
    }
}
