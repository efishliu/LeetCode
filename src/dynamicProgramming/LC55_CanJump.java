package dynamicProgramming;
/*
    题目：跳跃游戏
    难度：medium
    给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    判断你是否能够到达最后一个下标。
    链接：https://leetcode-cn.com/problems/jump-game
 */
/*
    贪心算法
 */
public class LC55_CanJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for(int i = 0; i < n; i++){
            //之前节点的最远距离能否到达i
            if(farthest < i)    return false;
            farthest = Math.max(farthest, i + nums[i]);
        }
        return true;
    }
}
