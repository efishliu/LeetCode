package dynamicProgramming;
/*
    题目：最后一块石头的重量II
    难度：medium
    有一堆石头，用整数数组stones 表示。其中stones[i] 表示第 i 块石头的重量。
    每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：
        如果x == y，那么两块石头都会被完全粉碎；
        如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
    最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
    链接：https://leetcode-cn.com/problems/last-stone-weight-ii
 */
/*
    0-1背包问题的通用解法：
        1.(推荐) 采用一维数组解法dp[j]代表重量为j市的状态，注意遍历顺序！
        for(int num : nums)
            for(int j = target; j >= num; j--)
        物品在外层，重量在内层，且内层应该倒序，因为是0-1背包，j不应该使用该行之前的值。
        2.采用二维数组解法(不推荐，应该与完全背包统一解法，容易与完全背包混淆)
        dp[i][j]表示前i个物品是否可以组成质量为j的情形,，不管遍历顺序
        for(int num : nums)
            for(int j = 1; j <= target; j++)
 */
public class LC1049_LastStoneWeightII {

    //解法I：dp[i][j]为boolean型，表示前i个物品是否可以组成质量为j的情形
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int stone : stones){
            sum += stone;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= target; j++){
                if(j >= stones[i - 1]){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stones[i - 1]];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for(int i = target; i >= 0; i--){
            if(dp[n][i] == true){
                return sum - 2 * i;
            }
        }
        return 0;
    }
    //解法II：dp[i][j]定义为前i个物品在最大容量为j是能装的最大价值为dp[i][j]
    //其中这里的物品重量为stons[i],价值也为stons[i]
    public int lastStoneWeightII2(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int stone : stones){
            sum += stone;
        }
        int target = sum / 2;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= target; j++){
                if(j >= stones[i - 1]){
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return sum - 2 * dp[n][target];
    }

    //解法III：采用一维数组
    public int lastStoneWeightII3(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int stone : stones){
            sum += stone;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        dp[0] = 0;

        for(int i = 0; i < n; i++){
            for(int j = target; j >= stones[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }
}
