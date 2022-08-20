package backTracking;
/*
    题目：全排列
    难度：medium
    给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    链接：https://leetcode-cn.com/problems/permutations/
 */
import java.util.LinkedList;
import java.util.List;

public class LC46_Permute {
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        dfs(nums, n, 0, visited, new LinkedList<>());
        return ans;
    }
    public void dfs(int[] nums, int n, int layer, boolean[] visited, List<Integer> buffer){
        if(n == layer){
            ans.add(new LinkedList(buffer));
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                buffer.add(nums[i]);
                dfs(nums, n, layer + 1, visited, buffer);
                buffer.remove(buffer.size() - 1);
                visited[i] = false;
            }
        }
    }
}
