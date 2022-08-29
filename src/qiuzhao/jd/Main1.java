package qiuzhao.jd;
import java.util.*;
public class Main1 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        while(reader.hasNext()){
            String ts = reader.nextLine();
            String[] t = ts.split(" ");
            int n = Integer.parseInt(t[0]);
            int k = Integer.parseInt(t[1]);
            String str = reader.nextLine();
            StringBuilder ans = new StringBuilder();
            for(int i = 0; i < n; i++){
                if(i < k){
                    //前k个字母为大写
                    ans.append(Character.toUpperCase(str.charAt(i)));
                }else{
                    //后n-k个字母为小写
                    ans.append(Character.toLowerCase(str.charAt(i)));
                }
            }
            System.out.println(ans.toString());
        }
    }
}
