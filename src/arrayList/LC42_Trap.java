package arrayList;
/*
    题目：接雨水
    难度：hard
    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    链接：https://leetcode-cn.com/problems/trapping-rain-water/
 */
/*
    本题核心：在i处能接的雨水应为左边最大的高度和右边高度的最大值-i处的高度
 */
public class LC42_Trap {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        //leftMax[i]->[0,i]的max height
        int[] leftMax = new int[n];
        //rightMax[i]->[i,n-1]的max height
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for(int i = 1; i < n - 1; i++){
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for(int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        for(int i = 1; i < n - 1; i++){
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}
