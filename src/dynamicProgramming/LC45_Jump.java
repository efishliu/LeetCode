package dynamicProgramming;
/*
    题目：跳跃游戏II
    难度：medium
    给你一个非负整数数组nums ，你最初位于数组的第一个位置。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    你的目标是使用最少的跳跃次数到达数组的最后一个位置。
    假设你总是可以到达数组的最后一个位置。
    链接：https://leetcode-cn.com/problems/jump-game-ii
 */
public class LC45_Jump {
    //自己的做法 8%
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i = 1; i < n; i++){
            dp[i] = i;
            for(int j = 0; j < i; j++){
                if(j + nums[j] >= i){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    break;
                }
            }
        }
        return dp[n - 1];
    }
    //
    public int jump2(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        int rangeMax = 0;
        int ans = 0;
        for(int i = 0; i < n - 1; i++){
            //当前能跳最远距离
            farthest = Math.max(farthest, i + nums[i]);
            //如果到达上一个区间能跳的最远距离
            if(i == rangeMax){
                ans++;
                //该区间的最远距离
                rangeMax = farthest;
            }
        }
        return ans;
    }

}
