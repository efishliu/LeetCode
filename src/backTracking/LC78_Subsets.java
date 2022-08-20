package backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    题目：子集
    难度：medium
    给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
    解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
    链接：https://leetcode-cn.com/problems/subsets/
 */
public class LC78_Subsets {
    //方法一：传统回溯
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        dfs(nums, 0, new LinkedList<>(), ans);
        return ans;
    }
    public void dfs(int[] nums, int index, List<Integer> buffer, List<List<Integer>> ans){
        ans.add(buffer);
        if(index == nums.length){
            return;
        }

        for(int i = index; i < nums.length; i++){
            buffer.add(nums[i]);
            dfs(nums, i + 1, buffer, ans);
            buffer.remove(buffer.size() - 1);
        }
    }
    //方法二：选或不选回溯
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = nums.length;
        backTrack(ans,nums,n,0,new ArrayList<Integer>());
        return ans;
    }
    public void backTrack(List<List<Integer>> ans,int[] nums,int n,int layer,List<Integer> buffer){
        if(layer == n){
            ans.add(new ArrayList<Integer>(buffer));
            return;
        }
        buffer.add(nums[layer]);
        backTrack(ans,nums,n,layer+1,buffer);
        buffer.remove(buffer.size()-1);
        backTrack(ans,nums,n,layer+1,buffer);
    }

}
