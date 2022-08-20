package dynamicProgramming;
/*
    题目：最大子数组和
    难度：easy
    给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    子数组 是数组中的一个连续部分。
    链接：https://leetcode.cn/problems/maximum-subarray/
 */
public class LC53_MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0)  return 0;

        int maxSum = nums[0];
        int ans = maxSum;
        for(int i = 1; i < n; i++){
            if(maxSum + nums[i] > nums[i]){
                maxSum += nums[i];
            }else{
                maxSum = nums[i];
            }
            ans = Math.max(ans, maxSum);
        }
        return ans;
    }
}
