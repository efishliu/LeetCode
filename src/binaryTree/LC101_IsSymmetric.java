package binaryTree;
/*
    题目：对称二叉树
    难度：easy
    给你一个二叉树的根节点 root ， 检查它是否轴对称
    链接：https://leetcode-cn.com/problems/symmetric-tree/
 */
public class LC101_IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
