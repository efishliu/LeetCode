package qiuzhao.mayi;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()) {
            String str = reader.nextLine();
            int n = str.length();
            int ans = 0;
            for(int i = 0; i < n; i++){
                for(int j = i + 1; j <= n; j++){
                    String s = str.substring(i, j);
                    if(isGoodStr(s)){
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
    public static boolean isGoodStr(String s){
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        int jiCount = 0;
        for(int i = 0; i < 26; i++){
            if(count[i] % 2 == 1){
                jiCount++;
            }
        }
        if(jiCount == 1){
            return  true;
        }else{
            return false;
        }
    }
}
