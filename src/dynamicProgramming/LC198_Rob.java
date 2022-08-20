package dynamicProgramming;
/*
    题目：打家劫舍
    难度：medium
    你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
    影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
    给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
    链接：https://leetcode-cn.com/problems/house-robber
 */
public class LC198_Rob {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n  < 1)  return 0;
        if(n == 1)  return nums[0];
        if(n == 2)  return Math.max(nums[0], nums[1]);
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= n; i++){
            dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        if(n  < 1)  return 0;
        if(n == 1)  return nums[0];
        if(n == 2)  return Math.max(nums[0], nums[1]);
        int prev1 = 0;
        int prev2 = 0;
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(prev2, prev1 + nums[i]);
            prev1 = prev2;
            prev2 = ans;
        }
        return ans;
    }
}
