package backTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
    题目：组合总和II
    难度：medium
    给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
    candidates中的每个数字在每个组合中只能使用一次。
    注意：解集不能包含重复的组合。
    链接：https://leetcode-cn.com/problems/combination-sum-ii
 */
/*
    方法1：使用一个visited数组记录当前选择的情况，如果当前元素与前一个元素相同 num[i] == num[i - 1],并且
          前一个元素未选择visited[i] = false,则当前元素不能选择应跳过。
    方法2：如果在当前层元素i > begin 并且 当前元素与前一个元素相同 num[i] == num[i - 1] 则跳过。

*/
public class LC40_CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        int n = candidates.length;
        boolean[] visited = new boolean[n];
        Arrays.sort(candidates);
        dfs(candidates, target, 0, ans, visited, new LinkedList<>());
        return ans;
    }
    public void dfs(int[] candidates, int target, int index, List<List<Integer>> ans,
                    boolean[] visited, List<Integer> buffer){
        if(target < 0){
            return;
        }else if(target == 0){
            ans.add(new LinkedList<>(buffer));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(i > 0 && candidates[i] == candidates[i - 1] && visited[i - 1] == false){
                continue;
            }
            buffer.add(candidates[i]);
            visited[i] = true;
            dfs(candidates, target - candidates[i], i + 1, ans, visited, buffer);
            buffer.remove(buffer.size() - 1);
            visited[i] = false;
        }
    }

    //方法2
    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        int n = candidates.length;
        Arrays.sort(candidates);
        dfs2(candidates, target, 0, ans, new LinkedList<>());
        return ans;
    }
    public void dfs2(int[] candidates, int target, int index, List<List<Integer>> ans, List<Integer> buffer){
        if(target < 0){
            return;
        }else if(target == 0){
            ans.add(new LinkedList<>(buffer));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i - 1]){
                continue;
            }
            buffer.add(candidates[i]);
            dfs2(candidates, target - candidates[i], i + 1, ans, buffer);
            buffer.remove(buffer.size() - 1);
        }
    }
}
