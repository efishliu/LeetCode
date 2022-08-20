package dynamicProgramming;
/*
    题目：目标和
    难度：medium
    给你一个整数数组 nums 和一个整数 target 。
    向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
    例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
    返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
    链接：https://leetcode-cn.com/problems/target-sum
 */
/*
    数学思路 pos数 - neg数 = target 且 pos数 + neg数 = sum;
    可得 pos = (sum + target) / 2;
 */
public class LC494_FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        //目标值比sum还大，不可能
        if(target > sum)    return 0;
        //pos值存在小数，不可能
        if((sum + target) % 2  == 1)    return 0;
        int tar = (sum + target) / 2;
        //pos之和为负数，不可能
        if(tar < 0) return 0;
        int[][] dp = new int[n + 1][tar + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= tar; j++){
                if(j >= nums[i - 1]){
                    dp[i][j] =dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][tar];
    }
    //一维数组解法
    public int findTargetSumWays2(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(target > sum)    return 0;
        if((sum + target) % 2  == 1)    return 0;
        int tar = (sum + target) / 2;
        //不能为负数
        if(tar < 0) return 0;
        int[] dp = new int[tar + 1];
        dp[0] = 1;
        for(int num : nums){
            for(int j = tar; j >= num; j--){
                dp[j] += dp[j - num];
            }
        }
        return dp[tar];
    }


}
