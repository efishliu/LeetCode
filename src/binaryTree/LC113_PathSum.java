package binaryTree;

import java.util.LinkedList;
import java.util.List;

/*
    题目：路径总和II
    难度：medium
    给你二叉树的根节点 root 和一个整数目标和 targetSum ，
    找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
    链接：https://leetcode.cn/problems/path-sum-ii/
 */
public class LC113_PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null)    return ans;
        dfs(root, targetSum, ans, new LinkedList<>());
        return ans;
    }
    public void dfs(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> buffer){
        if(root == null)    return;
        buffer.add(root.val);
        if(root.val == targetSum && root.left == null && root.right == null) {
            ans.add(new LinkedList(buffer));
        }
        dfs(root.left, targetSum - root.val, ans, buffer);
        dfs(root.right, targetSum - root.val, ans, buffer);
        buffer.remove(buffer.size() - 1);
    }
}
