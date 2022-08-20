package dynamicProgramming;

/*
    题目：编辑距离
    难度：hard
    给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数。
    你可以对一个单词进行如下三种操作：
        插入一个字符
        删除一个字符
        替换一个字符
    链接：https://leetcode-cn.com/problems/edit-distance
 */
/*
    动态规划问题：
    1.确定状态：s1一种状态，s2一种状态，故dp为二维
    2.确定dp[i][j]的含义：s1的[0,i)的字符到s2[0,j)字符的最小编辑距离
    3.确定状态转移方程 dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1，
    其中若s1(i-1)==s2(j-1),则dp[i-1][j-1]不加1
    4.边界值和初始值：dp[0][0] = 0;dp[i][0] = i;dp[0][j] = j;
 */
public class LC72_MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m == 0 || n == 0){
            return m == 0 ? n : m;
        }
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;

        for(int i = 1; i <= m; i++){
            dp[i][0] = i;
            for(int j = 1;j <= n; j++){
                dp[0][j] = j;
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j - 1]) + 1,dp[i - 1][j - 1]);
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j - 1]) + 1,dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
