package dynamicProgramming;
/*
    题目：最长递增子序列
    难度：medium
    给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
    例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
    链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 */
/*
    动态规划：
        1.定义状态：状态为以i为结尾的序列，
        2.dp数组含义：dp[i]为以i为结尾序列的最长子序列长度
        3.状态转移：dp[i] = if(arr[j] < arr[i]) dp[i] = max(dp[i], dp[j] + 1)
        4.定义边界值：dp[i] = 1
 */
public class LC300_LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 1;
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
