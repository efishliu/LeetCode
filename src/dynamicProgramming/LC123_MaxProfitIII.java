package dynamicProgramming;
/*
    题目：
    难度：hard
    给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 */
/*
    状态转移方程的含义
        dp[i][k][0]:在i出至多运行进行k次交易，当前为未持有状态
        dp[i - 1][k - 1][0]:因为dp[i][k][1]当前要完成一笔交易，所以在i-1时至多完成k-1笔交易
 */
public class LC123_MaxProfitIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;
        int[][][] dp = new int[n][k + 1][2];
        dp[0][0][1] = Integer.MIN_VALUE;
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = -prices[0];

        for(int i = 1; i < n; i++){
            for(int j = k; j >= 1; j--){
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
}
