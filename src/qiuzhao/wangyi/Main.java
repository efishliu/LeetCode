package qiuzhao.wangyi;
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()){
            int n = reader.nextInt();
            int m = reader.nextInt();
            int[][] arr = new int[n][2];
            for(int i = 0; i < n; i++){
                arr[i][0] = reader.nextInt();//个数
                arr[i][1] = reader.nextInt();//单价
            }
            //按价格递增排序
            Arrays.sort(arr, (a, b) -> (a[1] - b[1]));
            int minPrices = 0;
            int sumCount = 0;
            for(int i = 0; i < n; i++){
                int count = arr[i][0];
                int price = arr[i][1];
                if(sumCount + count >= m){
                    //买了这家商店就够了m个
                    minPrices += ((m - sumCount) * price);
                    break;
                }else{
                    //这家店全部买完也不够m个，全买
                    minPrices += (count * price);
                    sumCount += count;
                }
            }
            System.out.println(minPrices);
        }
    }
}
