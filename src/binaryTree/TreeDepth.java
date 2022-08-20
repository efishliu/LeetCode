package binaryTree;
/*
    二叉树的深度，采用后序遍历和层次遍历两种方式
 */
public class TreeDepth {
    public static int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return Math.max(leftDepth,rightDepth) + 1;
    }
}
