package dynamicProgramming;
/*
    题目：买卖股票的最佳时机 IV
    难度：hard
    给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 */
public class LC188_MaxProfitIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n == 0)  return  0;
        int[][][] dp = new int[n][k + 1][2];
        for(int i = 1; i <= k; i++){
            dp[0][i][1] = - prices[0];
        }
        dp[0][0][1] = Integer.MIN_VALUE;

        for(int i = 1; i < n; i++){
            for(int j = 1; j <= k; j++){
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
}
