package dynamicProgramming;

/*
    题目：零钱兑换II
    难度：medium
    给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
    请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
    假设每一种面额的硬币有无限个。
    题目数据保证结果符合 32 位带符号整数。
    链接：https://leetcode-cn.com/problems/coin-change-2
 */
/*
    动态规划问题
    状态：可以凑成该金额的组合数目
    dp[i]含义：可以凑成金额i的组合数目
    状态转移方程： dp[i] = dp[i] + dp[i-coins[j]]
    本题需要注意的是状态转移方程的顺序，外层函数应该为coins避免重复计算数目
    如【1，2】和【2，1】为同一种组合方式
 */
public class LC518_Change {
    //完全背包组合问题，物品外层遍历，背包内层遍历
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = 0;i < coins.length;i++){
            for(int j = coins[i];j <= amount;j++){
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
    //采用传统背包思路进行构建
    public int change2(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];//不加入
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];//加入i-1
                }
            }
        }
        return dp[n][amount];
    }
}
