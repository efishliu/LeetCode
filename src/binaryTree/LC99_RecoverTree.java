package binaryTree;
/*
    题目：恢复二叉搜索树
    难度：medium
    给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
    链接：https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
/*
    对于一个二叉搜索树来说，第一反应就是要想到中序遍历，并且BST树的中序遍历是有序的。
    此题未解决......
 */
public class LC99_RecoverTree {
    //记录两个错误节点
    TreeNode node1 = null;
    TreeNode node2 = null;
    //BST中序遍历的前驱节点
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        dfs(root);
        //交换两个错误节点的值
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
    public void dfs(TreeNode root) {
        if (root == null) return;
        //中序遍历 - 左子树
        dfs(root.left);
        //中序遍历 - 根
        //如果发现异常，记录两个节点的位置
        //------未解决的关键点--------
        if (root.val < prev.val) {
            //如果是第一次找到记录左边错误节点
            node1 = (node1 == null) ? prev : node1;
            //记录右边的错误节点
            node2 = root;
        }
        prev = root;
        //中序遍历 - 右子树
        dfs(root.right);
    }
}
