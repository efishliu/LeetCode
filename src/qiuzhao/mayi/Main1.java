package qiuzhao.mayi;

import java.util.*;

public class Main1 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int[] count = new int[26];
        count[0] = 1;
        for(int i = 1; i < 26; i++){
            count[i] = 2 * count[i - 1];
        }
        while(reader.hasNext()){
            StringBuilder ans = new StringBuilder();
            int x = reader.nextInt();
            while(x > 0){
                int index = find(x, count);
                x = x - count[index];
                char c = (char) ('a' + index);
                ans.append(c);
            }
            System.out.println(ans.toString());
        }
    }
    public static int find(int x, int[] count){
        for(int i = 25; i >= 0; i--){
            if(count[i] <= x){
                return i;
            }
        }
        return 0;
    }

}
