package backTracking;
/*
    题目：组合总和
    难度：medium
    给你一个 无重复元素 的整数数组candidates 和一个目标整数target，
    找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
    candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
    对于给定的输入，保证和为target 的不同组合数少于 150 个。
    链接：https://leetcode-cn.com/problems/combination-sum
 */
import java.util.LinkedList;
import java.util.List;

public class LC39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        dfs(candidates, target, 0, ans, new LinkedList<>());
        return ans;
    }
    public void dfs(int[] candidates, int target, int index, List<List<Integer>> ans, List<Integer> buffer){
        if(target < 0){
            return;
        }else if(target == 0){
            ans.add(new LinkedList<>(buffer));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            buffer.add(candidates[i]);
            //核心点在于i，可以重复取，并且按序不会有重复出现
            dfs(candidates, target - candidates[i], i, ans, buffer);
            buffer.remove(buffer.size() - 1);
        }
    }
}
