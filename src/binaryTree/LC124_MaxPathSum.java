package binaryTree;

/*
    题目：二叉树中的最大路径和
    难度：hard
    路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
    路径和 是路径中各节点值的总和。
    给你一个二叉树的根节点 root ，返回其 最大路径和 。
    链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 */
/*
    采用后序遍历，先计算左右节点的最大路径和，再计算当前路径和，返回经过根路径的最大路径和
 */
public class LC124_MaxPathSum {

    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        oneSideMax(root);
        return ans;
    }
    public int oneSideMax(TreeNode root){
        if(root == null)    return 0;
        int left = Math.max(0,oneSideMax(root.left));
        int right = Math.max(0,oneSideMax(root.right));
        ans = Math.max(ans,left + right + root.val);
        return Math.max(left,right) + root.val;
    }
}
