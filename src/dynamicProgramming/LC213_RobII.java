package dynamicProgramming;
/*
    题目：打家劫舍II
    难度：medium
    你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
    这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
    如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
    给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
    链接：https://leetcode-cn.com/problems/house-robber-ii
 */
/*
    将区间分为：[0,n-2]和[1,n-1]处理
 */
public class LC213_RobII {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)  return nums[0];
        return Math.max(robRange(nums, 0, n - 2),
                        robRange(nums, 1, n - 1));
    }
    public int robRange(int[] nums, int left, int right) {
        int prev1 = 0;
        int prev2 = 0;
        int ans = 0;
        for(int i = right; i >= left; i--){
            ans = Math.max(prev2, prev1 + nums[i]);
            prev1 = prev2;
            prev2 = ans;
        }
        return ans;
    }

}
