package binaryTree;
/*
    题目：二叉搜索树中第K小的元素
    难度：medium
    给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
    链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class LC230_KthSmallest {
    boolean find = false;
    int index = 0;
    int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }
    public void dfs(TreeNode root, int k){
        if(find || root == null)    return;
        dfs(root.left, k);
        index++;
        if(index == k){
            find = true;
            ans = root.val;
        }
        dfs(root.right, k);
    }
}
