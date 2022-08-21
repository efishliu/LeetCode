package qiuzhao.byteDance;

import java.util.*;
public class Main1 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        while(reader.hasNext()){
            int n = Integer.parseInt(reader.nextLine());
            String[] strs = new String[n];
            for(int i = 0; i < n; i++){
                strs[i] = reader.nextLine();
                if(isFuYin(strs[i])){
                    //存在连续5个辅音
                    //System.out.println("连续5个辅音");
                    System.out.println("yes");
                    continue;
                }else if(isExist(strs, strs[i], i)){
                    //存在最近的10句发过一样的话
                    //System.out.println("存在相同的话");
                    System.out.println("yes");
                    continue;
                }else {
                    System.out.println("no");
                }
            }
        }
    }

    //判断是否存在连续5个辅音
    public static boolean isFuYin(String str){
        int len = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == 'q' || c == 'w' || c == 'k' || c == 'h' || c == 'j'
            || c == 'Q' || c == 'W' || c == 'K' || c == 'H' || c == 'J'){
                len++;
            }else{
                len = 0;
            }
            if(len >= 5){
                return true;
            }
        }
        return false;
    }

    //判断最近10句是否出现相同的话
    public static boolean isExist(String[] strs, String str, int index){
        for(int i = index - 1; i >= 0 && i >= index - 10; i--){
            if(strs[i].equals(str)){
                return true;
            }
        }
        return false;
    }
}
