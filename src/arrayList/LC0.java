package arrayList;

import java.util.Scanner;
/*
    给一个字符串，输出这个字符串的一个最短子串，
    这个子串重复拼接能形成整个字符串（如字符串ababab，求得子串ab）若无这种子串，则输出整个字符串；
 */
public class LC0 {
    public static void main(String[] args){

        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()){
            String str = reader.nextLine();
            System.out.println(minSubString(str));
        }
    }

    public static String minSubString(String str){
        int n = str.length();
        if(n == 0 || n == 1)    return str;
        for(int i = 1; i <= n / 2; i++){
            String subString = str.substring(0, i);
            if(check(str, subString, n, i)){
                return subString;
            }
        }
        return str;

    }

    public static boolean check(String str, String subString, int strLen, int substrLen){
        if(strLen % substrLen != 0){
            return false;
        }
        for(int i = 0; i < strLen / substrLen; i++){
            for(int j = 0; j < substrLen; j++){
                if(str.charAt(i * substrLen + j) != subString.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
