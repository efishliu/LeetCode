package search;
import java.util.*;
/*
    题目：两数之和
    难度：easy
    给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    你可以按任意顺序返回答案。
    链接：https://leetcode.cn/problems/two-sum
 */
public class LC1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int t = target - nums[i];
            if(map.containsKey(t)){
                return new int[]{map.get(t), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
