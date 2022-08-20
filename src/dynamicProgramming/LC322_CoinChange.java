package dynamicProgramming;

import java.util.Arrays;

/*
    题目：零钱兑换
    难度：medium
    给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
    计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
    你可以认为每种硬币的数量是无限的。
    链接：https://leetcode-cn.com/problems/coin-change
 */
/*
    解题思路：
    1、采用动态规划自底而上解决 dp[i] = min(dp[i-coin]+1,dp[i])
    2、采用递归自上而下解决，并利用数组记录已计算过的位置。
 */
public class LC322_CoinChange {
    // 动态规划解决
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int coin : coins){
            for(int j = coin; j <= amount; j++){
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }

    //采用递归+标记数组解决
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        boolean[] visited = new boolean[amount + 1];
        dfs(coins,amount,dp,visited);
        return dp[amount];
    }
    public int dfs(int[] coins,int amount, int[] dp,boolean[] visited){
        //如果计算过直接返回
        if(visited[amount]) return dp[amount];
        if(amount == 0) return 0;
        if(amount < 0)  return -1;

        int minVal = Integer.MAX_VALUE;
        for(int coin : coins){
            if(amount - coin >= 0){
                int temp = dfs(coins, amount - coin, dp, visited);
                if(temp == -1)  continue;
                minVal = Math.min(minVal, temp + 1);
            }
        }
        dp[amount] = minVal == Integer.MAX_VALUE ? -1 : minVal;
        visited[amount] = true;
        return dp[amount];
    }
}
