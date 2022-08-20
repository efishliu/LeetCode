package arrayList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
    题目：三数之和
    难度：中等
    给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
    使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
    注意：答案中不可以包含重复的三元组。
    链接：https://leetcode.cn/problems/3sum
 */
public class LC15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        if(n < 3){
            return res;
        }
        Arrays.sort(nums);

        for(int i = 0; i < n - 2; i++){
            int k = n - 1;
            //重复跳过
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j < n - 1; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                while(j < k && nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }
                if(j == k || nums[i] + nums[j] + nums[k] > 0){
                    break;
                }
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                }
            }
        }
        return res;
    }
    //方法2：回溯会超时
    public List<List<Integer>> threeSum2(int[] nums){
        int n = nums.length;
        List<List<Integer>> ans = new LinkedList<>();
        if(n < 3)   return ans;
        Arrays.sort(nums);
        boolean[] visited = new boolean[n];
        dfs(nums, 0, n, 0, new LinkedList<>(), ans, visited);
        return ans;
    }
    public void dfs(int[] nums, int index, int n,int target,
                    List<Integer> buffer, List<List<Integer>> ans, boolean[] visited){
        if(buffer.size() > 3 || index > n){
            return;
        }
        if(buffer.size() == 3 && target == 0){
            ans.add(new LinkedList<>(buffer));
        }
        for(int i = index; i < n; i++){
            if(i > index && nums[i] == nums[i - 1] && visited[i] == false)  continue;
            buffer.add(nums[i]);
            visited[i] = true;
            dfs(nums, i + 1, n, target - nums[i], buffer, ans, visited);
            visited[i] = false;
            buffer.remove(buffer.size() - 1);
        }
    }
}
