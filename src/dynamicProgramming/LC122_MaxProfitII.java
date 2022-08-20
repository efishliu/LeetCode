package dynamicProgramming;
/*
    题目：买卖股票的最佳时机 II
    难度：medium
    给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。
    在每一天，你可能会决定购买和/或出售股票。你在任何时候最多只能持有 一股 股票。
    你也可以购买它，然后在 同一天 出售。返回 你能获得的 最大 利润。
    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii

 */
public class LC122_MaxProfitII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
