package binaryTree;
/*
    题目：二叉树剪枝
    难度：medium
    给你二叉树的根结点root，此外树的每个结点的值要么是 0 ，要么是 1 。
    返回移除了所有不包含 1 的子树的原二叉树。
    节点 node 的子树为 node 本身加上所有 node 的后代。
    链接：https://leetcode-cn.com/problems/binary-tree-pruning
 */
/*
    后序遍历剪枝
 */
public class LC814_PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null)    return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.val == 0 && root.left == null && root.right == null){
            return null;
        }else{
            return root;
        }
    }
}
