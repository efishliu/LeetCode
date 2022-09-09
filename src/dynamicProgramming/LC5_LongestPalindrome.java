package dynamicProgramming;
/*
    题目：最长回文子串
    难度：medium
    给你一个字符串 s，找到 s 中最长的回文子串。
    链接：https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
/*

 */
public class LC5_LongestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n < 2)   return s;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0;i < n;i++){
            dp[i][i] = true;
        }
        int maxLen = 1;
        int leftIndex = 0;
        for(int k = 2;k <= n;k++){
            for(int i = 0;i < n;i++){
                int j = i + k - 1;
                if(j < n){
                    if(s.charAt(i) == s.charAt(j)){
                        if(k == 2){
                            dp[i][j] = true;
                        }else{
                            dp[i][j] = dp[i+1][j-1];
                        }
                    }else{
                        dp[i][j] = false;
                    }
                    if(dp[i][j] && k > maxLen){
                        maxLen = k;
                        leftIndex = i;
                    }
                }

            }
        }
        return s.substring(leftIndex,leftIndex+maxLen);
    }
}
