package binaryTree;
/*
    题目：翻转二叉树
    难度：easy
    给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
    链接：https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class LC226_InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
