package qiuzhao.webank;

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()){
            int n = reader.nextInt();
            Integer[] nums = new Integer[n];
            for(int i = 0; i < n; i++){
                nums[i] = Integer.valueOf(reader.nextInt());
            }
            boolean[] visited = new boolean[n];
            Arrays.sort(nums, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    String s1 = String.valueOf(o1);
                    String s2 = String.valueOf(o2);
                    if(s1.length() > s2.length()){
                        return -1;
                    }else if(s1.length() < s2.length()){
                        return 1;
                    }else{
                        return (s2 + s1).compareTo((s1 + s2));
                    }

                }
            });
            Integer[] res = new Integer[]{Integer.valueOf(nums[0]), Integer.valueOf(nums[1]), Integer.valueOf(nums[2])};
            Arrays.sort(res, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    String s1 = String.valueOf(o1);
                    String s2 = String.valueOf(o2);
                    return (s2 + s1).compareTo((s1 + s2));

                }
            });
            String ans = String.valueOf(res[0]) + String.valueOf(res[1]) + String.valueOf(res[2]);
            System.out.println(ans);
        }
    }
}
