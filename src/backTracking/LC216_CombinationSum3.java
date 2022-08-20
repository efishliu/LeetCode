package backTracking;

import java.util.LinkedList;
import java.util.List;

/*
    题目：组合总和III
    难度：medium
    找出所有相加之和为n 的k个数的组合，且满足下列条件：
    只使用数字1到9
    每个数字最多使用一次
    返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
    链接：https://leetcode-cn.com/problems/combination-sum-iii

 */
public class LC216_CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new LinkedList<>();
        dfs(k, n, 1, new LinkedList<>(), 0, ans);
        return ans;
    }
    public void dfs(int k, int n,int index, List<Integer> buffer,int bufferSum, List<List<Integer>> ans){
        if(buffer.size() == k && bufferSum == n){
            ans.add(new LinkedList<>(buffer));
            return;
        }

        for(int i = index; i <= 9; i++){
            buffer.add(i);
            bufferSum += i;
            dfs(k, n, i + 1, buffer, bufferSum, ans);
            buffer.remove(buffer.size() - 1);
            bufferSum -= i;
        }
    }
}
