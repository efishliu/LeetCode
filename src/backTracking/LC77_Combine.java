package backTracking;

import java.util.LinkedList;
import java.util.List;

/*
    题目：组合
    难度：medium
    给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
    你可以按 任何顺序 返回答案。
    链接：https://leetcode-cn.com/problems/combinations/
 */
/*
    该题按回溯法的模板有两种思路
    1.  dfs()   //不选当前
        buffer.add()  dfs() buffer.removeLast() //选当前节点
    2.  for(i = index; i <= n; i++) //从第一个开始选，一直到第n个
            buffer.add
            dfs(i + 1)//从i+1开始选
            buffer.removeLast
    第二种方法不用进行去重操作
 */
public class LC77_Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        dfs(n, k, 1, new LinkedList(), ans);
        return ans;
    }
    public void dfs(int n, int k, int index, List<Integer> buffer, List<List<Integer>> ans){
        if(index > n){
            if(buffer.size() == k){
                ans.add(new LinkedList(buffer));
            }
            return;
        }
        dfs(n, k, index + 1, buffer, ans);   //不选

        buffer.add(index);  //选
        dfs(n, k, index + 1, buffer, ans);
        buffer.remove(buffer.size() - 1);
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        dfs2(n, k, 1, new LinkedList(), ans);
        return ans;
    }
    public void dfs2(int n, int k, int index, List<Integer> buffer, List<List<Integer>> ans){
        if(buffer.size() == k){
            ans.add(new LinkedList(buffer));
            return;
        }

        for(int i = index; i <= n; i++){
            buffer.add(i);
            dfs2(n, k, i + 1, buffer, ans);
            buffer.remove(buffer.size() - 1);
        }
    }

    //dfs剪枝
    public void dfs3(int n, int k, int index, List<Integer> buffer, List<List<Integer>> ans){
        if(buffer.size() == k){
            ans.add(new LinkedList(buffer));
            return;
        }
        //剪枝
        for(int i = index; i <= n - (k - buffer.size()) + 1; i++){
            buffer.add(i);
            dfs3(n, k, i + 1, buffer, ans);
            buffer.remove(buffer.size() - 1);
        }
    }
}
