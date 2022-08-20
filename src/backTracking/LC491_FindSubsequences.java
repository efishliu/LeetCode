package backTracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
    题目：递增子序列
    难度：medium
    给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
    数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
    链接：https://leetcode-cn.com/problems/increasing-subsequences
 */
public class LC491_FindSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        dfs(nums, 0, new LinkedList<>(), ans);
        return ans;
    }

    public void dfs(int[] nums, int begin, List<Integer> buffer, List<List<Integer>> ans){
        if(buffer.size() >= 2){
            ans.add(new LinkedList<>(buffer));
        }

        Set<Integer> set = new HashSet<>();
        for(int i = begin; i < nums.length; i++){
            if((!buffer.isEmpty() && nums[i] < buffer.get(buffer.size() - 1))
            || (set.contains(nums[i]))){
                continue;
            }
            buffer.add(nums[i]);
            set.add(nums[i]);
            dfs(nums, i + 1, buffer, ans);
            buffer.remove(buffer.size() - 1);
        }
    }
}
