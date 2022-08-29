package qiuzhao.jd;
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        while(reader.hasNext()) {
            int n = reader.nextInt();
            if(n < 6){
                //不可能有漂亮串
                System.out.println(0);
                continue;
            }
            if(n == 6){
                System.out.println(1);
                continue;
            }
            int maxpl = n / 3;
            long ans = 0;
            for(int i = 2; i <= maxpl; i++){
                int res = n - 3 * i;
                long temp = 1;
                for(int j = 0; j < res; j++){
                    temp = temp * 26;
                }
                long temp2 = 1;
                for(int j = 1; j <= res; j++){
                    temp2 = temp2 * j;
                }
                ans += ((i + 1) * temp * temp2) % 1000000007;
            }
            System.out.println(ans);

        }
    }
}
