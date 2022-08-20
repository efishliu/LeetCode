package backTracking;

import java.util.*;
//※
/*
    题目：全排列II
    难度：medium
    给定一个可包含重复数字的序列 nums ，按任意顺序返回所有不重复的全排列。
    链接：https://leetcode-cn.com/problems/permutations-ii/
 */
/*
    解决方法1：直接进行回溯，利用set进行去重
    解决方法2：不利用set去重，采用visited数组，当i>0 && nums[i] == nums[i - 1] && visited == false时跳过，
                即当前元素不能作为头元素
 */
public class LC47_PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        if(n == 0)  return ans;
        boolean[] visited = new boolean[n];
        dfs(nums,n,0,visited,new LinkedList<>(),set);
        for(List<Integer> item : set){
            ans.add(item);
        }
        return ans;
    }
    public void dfs(int[] nums,int n, int layer, boolean[] visited, List<Integer> buffer,Set<List<Integer>> set){
        if(layer == n && !set.contains(buffer)){
            set.add(new ArrayList(buffer));
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                buffer.add(nums[i]);
                visited[i] = true;
                dfs(nums,n,layer+1,visited,buffer,set);
                buffer.remove(buffer.size() - 1);
                visited[i] = false;
            }
        }
    }

    //方法2
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs2(nums, visited, new LinkedList<>(), ans);
        return ans;
    }

    public void dfs2(int[] nums, boolean[] visited, List<Integer> buffer, List<List<Integer>> ans){
        if(buffer.size() == nums.length){
            ans.add(new LinkedList(buffer));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false){
                continue;
            }
            if(visited[i] == false){
                visited[i] = true;
                buffer.add(nums[i]);
                dfs2(nums, visited, buffer, ans);
                visited[i] = false;
                buffer.remove(buffer.size() - 1);
            }
        }
    }
}
