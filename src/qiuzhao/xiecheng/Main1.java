package qiuzhao.xiecheng;

import java.text.DecimalFormat;
import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        while(reader.hasNext()){
            int n = reader.nextInt();
            int k = reader.nextInt();
            float cha = Float.MAX_VALUE;
            float ans = (float)n * n;
            for(int i = 0; i <= k; i++){
                float chang = i == 0 ? n : (float)n / (i + 1);
                float kuan = i == k ? n : (float)n / (k - i + 1);
                //System.out.println("长为: " + chang + " 宽为: " + kuan);
                if(Math.abs(chang - kuan) < cha){
                    cha = Math.abs(chang - kuan);
                    ans = chang * kuan;
                }
            }
            String res = decimalFormat.format(ans);
            System.out.println(res);
        }
    }
}
