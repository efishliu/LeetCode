package binaryTree;
/*
    题目：验证二叉搜索树
    难度：medium
    给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
    有效 二叉搜索树定义如下：
        节点的左子树只包含 小于 当前节点的数。
        节点的右子树只包含 大于 当前节点的数。
        所有左子树和右子树自身必须也是二叉搜索树。
    链接：https://leetcode.cn/problems/validate-binary-search-tree
 */
public class LC98_IsValidBST {
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null)    return true;
        if(!isValidBST(root.left)){
            return false;
        }
        if(root.val <= prev){
            return false;
        }
        prev = root.val;
        return isValidBST(root.right);
    }
}
