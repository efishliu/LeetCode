package dynamicProgramming;
/*
    题目：组合总和IV
    难度：medium
    给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
    题目数据保证答案符合 32 位整数范围。
    链接：https://leetcode-cn.com/problems/combination-sum-iv
 */
/*
    对于排列问题，不管物品的顺序，即不用设置dp[i]
 */
public class LC377_CombinationSum4 {
    //完全背包，排列问题，target在外层，物品在内层
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int num : nums){
                if(i >= num){
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
