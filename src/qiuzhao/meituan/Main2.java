package qiuzhao.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        while(reader.hasNext()){
            //读取数据
            int n = reader.nextInt();

            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = reader.nextInt();
            }

            int[] init = new int[n];
            boolean place[] = new boolean[n];
            int i = 0;//指向arr
            int j = -1;//指向init
            while(i < n - 1){
                //跳三步
                for(int skip = 0; skip <= 2;){
                    j = (j + 1) % n;
                    if(!place[j]){
                        skip++;
                    }
                }
                init[j] = arr[i];
                place[j] = true;
                i++;
            }
            for(int k = 0; k < n; k++){
                if(place[k] == false){
                    init[k] = arr[n - 1];
                    break;
                }
            }
            for(int k = 0; k < n; k++){
                System.out.print(init[k] + " ");
            }


        }
    }
}
