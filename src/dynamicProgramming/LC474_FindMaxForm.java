package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/*
    题目：一和零
    难度：medium
    给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
    请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
    如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
    链接：https://leetcode-cn.com/problems/ones-and-zeroes
 */
public class LC474_FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        Map<String,int[]> map = new HashMap<>();
        for(String str : strs){
            int one = 0;
            int zero = 0;
            for(char c : str.toCharArray()){
                if(c == '1')    one++;
                else if(c == '0')   zero++;
            }
            map.put(str, new int[]{zero, one});
        }

        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        //dp[0][0][0] = 1; 这里dp代表子集的长度，所以这里应该为0
        dp[0][0][0] = 0;
        for(int i = 1; i <= strs.length; i++){
            int[] t = map.get(strs[i - 1]);
            for(int j = 0; j <= m; j++){
                for(int k = 0; k <= n; k++){
                    if(t[0] <= j && t[1] <= k){
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - t[0]][k - t[1]] + 1);
                    }else{
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        Map<String,int[]> map = new HashMap<>();
        for(String str : strs){
            int one = 0;
            int zero = 0;
            for(char c : str.toCharArray()){
                if(c == '1')    one++;
                else if(c == '0')   zero++;
            }
            map.put(str, new int[]{zero, one});
        }

        int[][] dp = new int[m + 1][n + 1];

        for(String str : strs){
            int[] t = map.get(str);
            int zero = t[0];
            int one = t[1];
            for(int i = m; i >= zero; i--){
                for(int j = n; j >= one; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
