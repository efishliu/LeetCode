package qiuzhao.lenovo;
import java.util.*;
public class Main1 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()){
            //读取数据
            int n = reader.nextInt();
            int k = reader.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = reader.nextInt();
            }
            //开始模拟
            for(int j = 1; j <= k; j++){
                int[] temp = new int[n];
                Arrays.fill(temp, 0);
                for(int i = 0; i < n; i++){
                    temp[i] = arr[(i - 1 + n) % n] / 2 + arr[(i + 1 + n) % n] / 2;
                    //自身为奇数
                    if(arr[i] % 2 == 1){
                        temp[i] += 1;
                    }
                }
                for(int i = 0; i < n; i++){
                    arr[i] =  temp[i];
                }
            }
            for(int i = 0; i < n; i++){
                System.out.print(arr[i] + " ");
            }
        }
    }
}
